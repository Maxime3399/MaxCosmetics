package fr.Maxime3399.MaxCosmetics.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.utils.BlockUtils;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class PetFreesbieAction {
	
	public static ArrayList<ArmorStand> freesbies = new ArrayList<>();
	public static boolean use = false;
	
	public static void act(Pet pet, Player p) {
		
		pet.setCanDispawn(false);
		
		Random r = new Random();
		
		List<Location > list = BlockUtils.circle(p.getLocation(), 8, 0, false, true, 0);
		
		Location loc = list.get(r.nextInt(list.size()+1));
		
		if(p.getLocation().distance(loc) < 6 || loc.getWorld().getBlockAt(loc).getType() != Material.AIR || loc.getWorld().getBlockAt(loc.add(0, -1, 0)).getType() == Material.AIR) {
			
			act(pet, p);
			
		}else {
			
			if(p.getLocation().getY() != loc.getY()) {
				
				act(pet, p);
				
			}else {
				
				pet.setMoove(false);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
					
					Location go = loc.add(0, 0.52, 0);
					
					@Override
					public void run() {
						
						ArmorStand as = p.getLocation().getWorld().spawn(p.getLocation().add(0, 3.5, 0), ArmorStand.class);
						as.setGravity(true);//======
						as.setVisible(false);
						as.setSmall(true);
						as.setHelmet(new ItemStack(Material.CARPET));
						freesbies.add(as);
						
						VersionsManager.getVClass().entityMoove(pet.getEntity(), go, 1);
						
						new BukkitRunnable() {
							
							int time = 0;
							boolean get = false;
							boolean canGet = false;
							
							@Override
							public void run() {
								
								time++;
								
								if(canGet) {
									
									if(!get) {
										
										if(as.getLocation().distance(pet.getEntity().getLocation()) < 1.32) {
											
											as.setGravity(false);
											get = true;
											
										}
										
									}else {
										
										pet.setMoove(true);
										as.teleport(pet.getEntity().getLocation().add(0, 1, 0));
										if(pet.getEntity().getType() == EntityType.SILVERFISH) {
											as.teleport(pet.getEntity().getLocation().add(0, -0.1, 0));
										}else {
											as.teleport(pet.getEntity().getLocation().add(0, 1, 0));
										}
										
										if(pet.getEntity().getLocation().distance(p.getLocation()) < 1) {
											
											freesbies.remove(as);
											as.remove();
											pet.setCanDispawn(true);
											MaxPlayer mp = PlayersManager.getMaxPlayer(p);
											if(PetsList.getPetExp(mp, pet.getType()) >= PetsList.requiredExp(pet.getLevel())) {
												
												PetsList.setPetExp(mp, pet.getType(), PetsList.getPetExp(mp, pet.getType())-PetsList.requiredExp(pet.getLevel()));
												pet.setLevel(pet.getLevel()+1);
												PetsList.setPetLevel(mp, pet.getType(), pet.getLevel());
												p.sendMessage(MessageUtils.getString("player_pet_levelup"));
												p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 1);
												
											}
											this.cancel();
											
										}
										
									}
									
									if(as.isOnGround()) {
										
										as.teleport(as.getLocation().add(0, +0.28, 0));
										
									}
									
								}else {
									
									
									boolean tomb = false;
									
									if(as.getLocation().distance(go) < 0.1) {
										tomb = true;
									}else if(as.getLocation().getBlock().getType() != Material.AIR) {
										tomb = true;
									}else if(as.getLocation().add(0, 1, 0).getBlock().getType() != Material.AIR) {
										tomb = true;
									}else if(as.getLocation().getX() == go.getX() && as.getLocation().getZ() == go.getZ()){
										tomb = true;
									}else if(as.isOnGround()) {
										tomb = true;
									}
									
									if(tomb) {
										
										as.setGravity(true);
										canGet = true;
										
									}else {
										
										float yaw = as.getLocation().getYaw();
										yaw = yaw-20;
										
										if(yaw <= -180) {
											yaw = 180;
										}
										
										Location ne = as.getLocation().clone();
										ne.setYaw(yaw);
										
								        Vector vec = go.toVector().subtract(as.getLocation().toVector());
								        as.setVelocity(vec.normalize().multiply(0.16));
								        
										as.teleport(ne);
										
									}
									
								}
								
								if(time == 1200) {
									
									as.remove();
									this.cancel();
									
								}
								
							}
							
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
						
					}
					
				}, 5);
				
			}
			
		}
		
	}

}
