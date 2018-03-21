package fr.Maxime3399.MaxCosmetics.managers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.Pet;

public class PetsManager {
	
	private static ArrayList<Pet> list = new ArrayList<>();
	public static boolean use;
	
	public static Pet addPet(Entity e, String name, Player p, int lvl) {
		
		Pet pet = new Pet(e, name, p, lvl);
		
		list.add(pet);
		
		return pet;
		
	}
	
	public static void removePet(Pet pet) {
		
		pet.setStop(true);
		pet.getEntity().remove();
		
		list.remove(pet);
		
	}
	
	public static void removePet(Player p) {
		
		if(havePet(p)) {
			
			removePet(getPlayerPet(p));
			
		}
		
	}
	
	public static boolean havePet(Player p) {
		
		if(getPlayerPet(p) == null) {
			
			return false;
			
		}else {
			
			return true;
			
		}
		
	}
	
	public static Pet getPlayerPet(Player p) {
		
		Pet pet = null;
		
		for(Pet pets : list) {
			
			if(pets.getPlayer() == p) {
				
				pet = pets;
				
			}
			
		}
		
		return pet;
		
	}
	
	public static ArrayList<Pet> getPets(){
		
		return list;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void startScheduler() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				for(Player pls : Bukkit.getOnlinePlayers()) {
					
					
					if(PetsManager.havePet(pls)) {
						
						Pet pet = PetsManager.getPlayerPet(pls);
						
						if(pls.getLocation().distance(pet.getEntity().getLocation()) > 30) {
							
							if(pls.isOnGround()) {
								pet.getEntity().teleport(pls.getLocation());
							}
							
						}else if(pls.getLocation().distance(pet.getEntity().getLocation()) > 10) {
							
							VersionsManager.getVClass().entityMoove(pet.getEntity(), pls.getLocation(), 2);
							
						}else if(pls.getLocation().distance(pet.getEntity().getLocation()) > 1) {
							
							VersionsManager.getVClass().entityMoove(pet.getEntity(), pls.getLocation(), 1);
							
						}
						
					}
					
				}
				
			}
			
		}, 1, 1);
		
	}

}
