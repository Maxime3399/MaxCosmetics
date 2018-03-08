package fr.Maxime3399.MaxCosmetics.managers;

import org.bukkit.Bukkit;

import fr.Maxime3399.MaxCosmetics.versions.Version1_8_R3;
import fr.Maxime3399.MaxCosmetics.versions.Versions;

public class VersionsManager {
	
	private static String version;
	private static Versions vclass;
	
	public static boolean setupVersion() {
		
		boolean result = true;
		
		try {
			
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
			e.printStackTrace();
			
		}
		
		if(version.equals("v1_8_R3")) {
			
			vclass = new Version1_8_R3();
			
		}else {
			
			result = false;
			
		}
		
		return result;
		
	}

	public static Versions getVClass() {
		
		return vclass;
		
	}

	public static String getVersion() {
		
		return version;
		
	}

}
