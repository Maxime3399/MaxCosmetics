package fr.Maxime3399.MaxCosmetics.managers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;

public class PlayersManager {
	
	private static ArrayList<MaxPlayer> list = new ArrayList<>();
	
	public static MaxPlayer addPlayer(Player p) {
		
		MaxPlayer mp = new MaxPlayer(p);
		
		list.add(mp);
		
		return mp;
		
	}
	
	public static void removePlayer(MaxPlayer mp) {
		
		mp.synchronize();
		list.remove(mp);
		
	}
	
	public static void removePlayer(Player p) {
		
		MaxPlayer mp = getMaxPlayer(p);
		
		if(mp != null) {
			
			mp.synchronize();
			list.remove(mp);
			
		}
		
	}
	
	public static MaxPlayer getMaxPlayer(Player p) {
		
		MaxPlayer mp = null;
		
		for(MaxPlayer mps : list) {
			
			if(mps.getPlayer().equals(p)) {
				
				mp = mps;
				
			}
			
		}
		
		return mp;
		
	}
	
	public static ArrayList<MaxPlayer> getMaxPlayers(){
		
		return list;
		
	}

}
