package fr.Maxime3399.MaxCosmetics.managers;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class PetsManager {
	
	private static ArrayList<Pet> list = new ArrayList<>();
	public static boolean use;
	
	public static Pet addPet(Entity e, String name, Player p, int lvl, String type) {
		
		Pet pet = new Pet(e, name, p, lvl, type);
		
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
						pet.setDelay(pet.getDelay()+1);
						MaxPlayer mp = PlayersManager.getMaxPlayer(pls);
						
						if(pet.getDelay() >= 1200) {
							
							PetsList.setPetExp(mp, pet.getType(), PetsList.getPetExp(mp, pet.getType())+1);
							PetsList.setPetHunger(mp, pet.getType(), PetsList.getPetHunger(mp, pet.getType())-1);
							PetsList.setPetExercise(mp, pet.getType(), PetsList.getPetExercise(mp, pet.getType())+1);
							Random r = new Random();
							PetsList.setPetThirst(mp, pet.getType(), PetsList.getPetThirst(mp, pet.getType())-(r.nextInt(3)+1));
							
							if(PetsList.getPetExp(mp, pet.getType()) >= PetsList.requiredExp(pet.getLevel())) {
								
								PetsList.setPetExp(mp, pet.getType(), PetsList.getPetExp(mp, pet.getType())-PetsList.requiredExp(pet.getLevel()));
								pet.setLevel(pet.getLevel()+1);
								PetsList.setPetLevel(mp, pet.getType(), pet.getLevel());
								pls.sendMessage(MessageUtils.getString("player_pet_levelup"));
								pls.playSound(pls.getLocation(), Sound.LEVEL_UP, 100, 1);
								
							}
							
							pet.setDelay(0);
							
						}
						
						if(PetsList.getPetExercise(mp, pet.getType()) >= 100) {
							
							PetsList.removePet(pls);
							pls.sendMessage(MessageUtils.getString("player_pet_xexercise"));
							pls.playSound(pls.getLocation(), Sound.BAT_DEATH, 100, 2);
							
						}else if(PetsList.getPetHunger(mp, pet.getType()) == 0) {
							
							PetsList.removePet(pls);
							pls.sendMessage(MessageUtils.getString("player_pet_xhunger"));
							pls.playSound(pls.getLocation(), Sound.BAT_DEATH, 100, 2);
							
						}else if(PetsList.getPetThirst(mp, pet.getType()) == 0) {
							
							PetsList.removePet(pls);
							pls.sendMessage(MessageUtils.getString("player_pet_xthirst"));
							pls.playSound(pls.getLocation(), Sound.BAT_DEATH, 100, 2);
							
						}
						
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
