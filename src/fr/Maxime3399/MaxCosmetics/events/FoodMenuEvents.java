package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.menus.ConfirmMenu;
import fr.Maxime3399.MaxCosmetics.menus.FoodMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class FoodMenuEvents implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase(MessageUtils.getString("menu_name_food"))) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				MaxPlayer mp = PlayersManager.getMaxPlayer(p);
				MaxPlayer mpd = PlayersManager.getMaxPlayer(mp.getInvData());
				
				if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_apple"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_appple(mpd.getFood_appple()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+5);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_apple_no"))) {
					if(mpd.getGold() >= 1) {
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
											mpd.setGold(mpd.getGold()-1);
											mpd.setFood_appple(mpd.getFood_appple()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
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
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
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
			
			e.setCancelled(true);
			
		}
		
	}
	
}
