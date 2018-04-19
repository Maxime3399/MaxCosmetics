package fr.Maxime3399.MaxCosmetics.utils;

public class StringUtils {
	
	public static String getRarityColor(String rarity) {
		
		if(rarity.equalsIgnoreCase("common")) {
			
			return "§a";
			
		}else if(rarity.equalsIgnoreCase("rare")){
			
			return "§9";
			
		}else if(rarity.equalsIgnoreCase("rare")){
			
			return "§5";
			
		}else {
			
			return "§6";
			
		}
		
	}

}
