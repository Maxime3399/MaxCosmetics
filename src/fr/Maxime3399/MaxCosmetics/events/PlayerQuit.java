package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			MaxPlayer mps = PlayersManager.getMaxPlayer(pls);
			
			if(mps.getInvData() == p) {
				
				mps.setInvData(pls);
				
			}
			
		}
		
		PlayersManager.removePlayer(p);
		
	}

}
