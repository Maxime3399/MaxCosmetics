package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.menus.CosPetsMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

@SuppressWarnings("deprecation")
public class ChatEvents implements Listener {
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		
		Player p = e.getPlayer();
		MaxPlayer mp = PlayersManager.getMaxPlayer(p);
		
		if(mp.getRename_pet() != null) {
			
			String pet = mp.getRename_pet();
			String name = e.getMessage();
			
			if(mp.isMccmd() && name.contains("mccmd")) {
				
				return;
				
			}else {
				
				if(name.contains(" ")) {
					
					p.sendMessage(MessageUtils.getString("player_rename_space"));
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					
				}else {
					
					
					PetsList.renamePet(PlayersManager.getMaxPlayer(mp.getInvData()), pet, name);
					mp.setRename_pet(null);
					p.sendMessage(MessageUtils.getString("player_rename_success"));
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
					CosPetsMenu.openMenu(p, mp.getInvData());
					
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}

}
