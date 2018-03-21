package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.menus.ConfirmMenu;
import fr.Maxime3399.MaxCosmetics.menus.CosPetsMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class CosPetsMenuEvents implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase(MessageUtils.getString("menu_name_cos_pets"))) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				MaxPlayer mp = PlayersManager.getMaxPlayer(p);
				MaxPlayer mpd = PlayersManager.getMaxPlayer(mp.getInvData());
				
				if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_cos_pets_silverfish"))) {
					
					if(mpd.isPet_silverfish()) {
						if(e.getClick() == ClickType.RIGHT) {
							//feed
						}else if(e.getClick() == ClickType.MIDDLE) {
							mp.setRename_pet("pet_silverfish");
							VersionsManager.getVClass().sendJSONMessage(p, "[{\"text\":\""+MessageUtils.getString("player_rename_info")+"\"},{\"text\":\""+MessageUtils.getString("super_cancell")+"\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/mccmd pet_rename_cancell\"}}]");
							mp.setMccmd(true);
							p.playSound(p.getLocation(), Sound.ANVIL_USE, 100, 1);
							p.closeInventory();
						}else {
							if(PetsManager.havePet(mp.getInvData())) {
								PetsManager.removePet(mp.getInvData());
								mp.getInvData().getWorld().playSound(mp.getInvData().getLocation(), Sound.HORSE_GALLOP, 3, 1);
								CosPetsMenu.openMenu(p, mp.getInvData());
								mpd.setEnable(mpd.getEnable().replaceAll("pet_silverfish", ""));
							}else {
								if(mpd.getPet_silverfish_hunger() < 10 && mp.getPet_silverfish_thirst() < 10) {
									p.sendMessage(MessageUtils.getString("player_pet_spawn_bar"));
									p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
								}else {
									mp.getInvData().getWorld().playSound(mp.getInvData().getLocation(), Sound.HORSE_GALLOP, 3, 2);
									p.closeInventory();
									mpd.setEnable(mpd.getEnable()+"pet_silverfish");
									PetsList.spawnPet(mp.getInvData());
								}
							}
						}
					}else {
						if(mpd.getGold() >= 10) {
							ConfirmMenu.confirm(p);
							new BukkitRunnable() {
								@Override
								public void run() {
									if(ConfirmMenu.getPlayer(p) == 1) {
										ConfirmMenu.removePlayer(p);
										this.cancel();
										Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											@Override
											public void run() {
												mpd.setGold(mpd.getGold()-10);
												mpd.setPet_silverfish(true);
												CosPetsMenu.openMenu(p, mp.getInvData());
												p.sendMessage(MessageUtils.getString("player_pay_success"));
												p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
											}
										}, 1);
									}else if(ConfirmMenu.getPlayer(p) == 2) {
										ConfirmMenu.removePlayer(p);
										this.cancel();
										Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											@Override
											public void run() {
												CosPetsMenu.openMenu(p, mp.getInvData());
												p.sendMessage(MessageUtils.getString("player_pay_cancell"));
												p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
											}
										}, 1);
									}
								}
							}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
						}else {
							if(mp == mpd) {
								p.sendMessage(MessageUtils.getString("player_you_pay_no"));
							}else {
								p.sendMessage(MessageUtils.getString("player_other_pay_no"));
							}
							p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
						}
					}
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
