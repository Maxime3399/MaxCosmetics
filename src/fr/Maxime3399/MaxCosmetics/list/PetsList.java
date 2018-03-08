package fr.Maxime3399.MaxCosmetics.list;

import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;

public class PetsList {
	
	public static int getCount(Player p) {
		
		int result = 0;
		MaxPlayer mp = PlayersManager.getMaxPlayer(p);
		
		if(mp.isPet_silverfish()) {
			result++;
		}
		if(mp.isPet_catblack()) {
			result++;
		}
		if(mp.isPet_catblackbaby()) {
			result++;
		}
		
		return result;
		
	}
	
	public static int getMax() {
		
		int result = 3;
		return result;
		
	}
	
	public static int requiredExp(int level) {
		
		int result = level*3;
		
		return result;
		
	}
	
	public static String statusColor(int stats) {
		
		String result = "";
		
		if(stats <= 20) {
			result = "§6";
		}else if(stats <= 40) {
			result = "§e";
		}else if(stats <= 60) {
			result = "§a";
		}else if(stats <= 80) {
			result = "§2";
		}else if(stats <= 100) {
			result = "§b";
		}
		
		return result;
		
	}
	
	public static String getLevelColor(int level) {
		
		String result = "";
		
		if(level <= 5) {
			result = "§8";
		}else if(level <= 10) {
			result = "§8§l";
		}else if(level <= 15) {
			result = "§7";
		}else if(level <= 20) {
			result = "§7§l";
		}else if(level <= 25) {
			result = "§6";
		}else if(level <= 30) {
			result = "§6§l";
		}else if(level <= 35) {
			result = "§e";
		}else if(level <= 40) {
			result = "§e§l";
		}else if(level <= 45) {
			result = "§a";
		}else if(level <= 50) {
			result = "§a§l";
		}else if(level <= 55) {
			result = "§2";
		}else if(level <= 60) {
			result = "§2§l";
		}else if(level <= 65) {
			result = "§b";
		}else if(level <= 70) {
			result = "§b§l";
		}else if(level <= 75) {
			result = "§3";
		}else if(level <= 80) {
			result = "§3§l";
		}else if(level <= 85) {
			result = "§9";
		}else if(level <= 90) {
			result = "§9§l";
		}else if(level <= 95) {
			result = "§1";
		}else if(level <= 100) {
			result = "§1§l";
		}
		
		return result;
		
	}

}
