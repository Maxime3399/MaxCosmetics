package fr.Maxime3399.MaxCosmetics.list;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;

public class PetsList {
	
	public static String getConfigMessage(String pet) {
		
		String result = "§cYou don't have the permission !";
		
		if(MainClass.getInstance().getConfig().isString("Pets."+pet+".Message")) {
			result = MainClass.getInstance().getConfig().getString("Pets."+pet+".Message");
		}
		
		return result.replaceAll("&", "§");
		
	}
	
	public static String getConfigLore(String pet) {
		
		String result = "§cYou don't have the permission";
		
		if(MainClass.getInstance().getConfig().isString("Pets."+pet+".Lore")) {
			result = MainClass.getInstance().getConfig().getString("Pets."+pet+".Lore");
		}
		
		return result.replaceAll("&", "§");
		
	}
	
	public static String getConfigPermission(String pet) {
		
		String result = "#####";
		
		if(MainClass.getInstance().getConfig().isString("Pets."+pet+".Permission")) {
			result = MainClass.getInstance().getConfig().getString("Pets."+pet+".Permission");
		}
		
		return result;
		
	}
	
	public static String getConfigType(String pet) {
		
		String result = "common";
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			if(MainClass.getInstance().getConfig().isString("Pets."+pet+".Type")) {
				result = MainClass.getInstance().getConfig().getString("Pets."+pet+".Type");
			}
		}
		
		return result;
		
	}
	
	public static int getConfigCost(String pet) {
		
		int result = 30;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			if(MainClass.getInstance().getConfig().isInt("Pets."+pet+".Cost")) {
				result = MainClass.getInstance().getConfig().getInt("Pets."+pet+".Cost");
			}
		}
		
		return result;
		
	}
	
	public static String getConfigRarity(String pet) {
		
		String result = "common";
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			if(MainClass.getInstance().getConfig().isString("Pets."+pet+".Rarity")) {
				result = MainClass.getInstance().getConfig().getString("Pets."+pet+".Rarity");
			}
		}
		
		return result;
		
	}
	
	public static boolean getConfigEnable(String pet) {
		
		boolean result = true;
		
		if(MainClass.getInstance().getConfig().isBoolean("Pets."+pet+".Enable")) {
			
			result = MainClass.getInstance().getConfig().getBoolean("Pets."+pet+".Enable");
			
		}
		
		return result;
		
	}
	
	public static ArrayList<String> getPets(){
		
		ArrayList<String> result = new ArrayList<>();
		
		if(getConfigEnable("pet_silverfish")) {
			result.add("pet_silverfish");
		}
		
		return result;
		
	}
	
	public static int getCount(Player p) {
		
		int result = 0;
		MaxPlayer mp = PlayersManager.getMaxPlayer(p);
		
		if(mp.isPet_silverfish() && getConfigEnable("pet_silverfish")) {
			result++;
		}
		
		return result;
		
	}
	
	public static int getMax() {
		
		int result = getPets().size();
		
		return result;
		
	}
	
	public static int requiredExp(int level) {
		
		int result = level*3;
		
		return result;
		
	}
	
	public static int getPetExp(MaxPlayer mp, String pet) {
		
		int result = 0;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			result = mp.getPet_silverfish_exp();
		}
		
		return result;
		
	}
	
	public static void setPetExp(MaxPlayer mp, String pet, int value) {
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_exp(value);
		}
		
	}
	
	public static int getPetLevel(MaxPlayer mp, String pet) {
		
		int result = 0;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			result = mp.getPet_silverfish_level();
		}
		
		return result;
		
	}
	
	public static void setPetLevel(MaxPlayer mp, String pet, int value) {
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_level(value);
		}
		
	}
	
	public static void setPetHunger(MaxPlayer mp, String pet, int value) {
		
		if(value > 100) {
			value = 100;
		}else if(value < 0) {
			value = 0;
		}
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_hunger(value);
		}
		
	}
	
	public static void setPetThirst(MaxPlayer mp, String pet, int value) {
		
		if(value > 100) {
			value = 100;
		}else if(value < 0) {
			value = 0;
		}
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_thirst(value);
		}
		
	}
	
	public static void setPetExercise(MaxPlayer mp, String pet, int value) {
		
		if(value > 100) {
			value = 100;
		}else if(value < 0) {
			value = 0;
		}
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_exercise(value);
		}
		
	}
	
	public static int getPetHunger(MaxPlayer mp, String pet) {
		
		int result = 0;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			result = mp.getPet_silverfish_hunger();
		}
		
		return result;
		
	}
	
	public static int getPetThirst(MaxPlayer mp, String pet) {
		
		int result = 0;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			result = mp.getPet_silverfish_thirst();
		}
		
		return result;
		
	}
	
	public static int getPetExercise(MaxPlayer mp, String pet) {
		
		int result = 0;
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			result = mp.getPet_silverfish_exercise();
		}
		
		return result;
		
	}
	
	public static void spawnPet(Player p) {
		
		MaxPlayer mp = PlayersManager.getMaxPlayer(p);
		
		if(mp.getEnable().contains("pet_silverfish")) {
			if(getConfigEnable("pet_silverfish")) {
				Entity en = mp.getInvData().getWorld().spawn(mp.getInvData().getLocation(), Silverfish.class);
				PetsManager.addPet(en, mp.getPet_silverfish_name(), p, mp.getPet_silverfish_level(), "pet_silverfish");
			}else {
				removePet(p);
			}
		}
		
	}
	
	public static void removePet(Player p) {
		
		MaxPlayer mp = PlayersManager.getMaxPlayer(p);
		PetsManager.removePet(p);
		
		if(mp.getEnable().contains("pet_silverfish")) {
			mp.setEnable(mp.getEnable().replaceAll("pet_silverfish", ""));
		}
		
	}
	
	public static void renamePet(MaxPlayer mp, String pet, String name) {
		
		if(pet.equalsIgnoreCase("pet_silverfish")) {
			mp.setPet_silverfish_name(name);
		}
		
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
