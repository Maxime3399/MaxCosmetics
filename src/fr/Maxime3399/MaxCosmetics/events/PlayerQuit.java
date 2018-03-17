package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			MaxPlayer mps = PlayersManager.getMaxPlayer(pls);
			
			if(mps.getInvData() == p) {
				
				if(pls.getOpenInventory() != null) {
					
					if(pls.getOpenInventory().getTopInventory().getName().contains("§8")) {
						
						pls.closeInventory();
						pls.sendMessage(MessageUtils.getString("player_disconnected"));
						pls.playSound(pls.getLocation(), Sound.CHICKEN_EGG_POP, 100, 2);
						
					}
					
				}
				
				mps.setInvData(pls);
				
			}
			
		}
		
		PlayersManager.removePlayer(p);
		
	}

}
