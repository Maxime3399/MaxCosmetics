package fr.Maxime3399.MaxCosmetics.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.utils.BlockUtils;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class PetBallAction {
	
	public static ArrayList<ArmorStand> balls = new ArrayList<>();
	public static boolean use = false;
	
	public static void act(Pet pet, Player p) {
		
		pet.setCanDispawn(false);
		
		Random r = new Random();
		
		List<Location > list = BlockUtils.circle(p.getLocation(), 10, 0, false, true, 0);
		
		Location loc = list.get(r.nextInt(list.size()+1));
		
		if(p.getLocation().distance(loc) < 6 || loc.getWorld().getBlockAt(loc).getType() != Material.AIR) {
			
			act(pet, p);
			
		}else {
			
			pet.setMoove(false);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					
					ArmorStand as = loc.getWorld().spawn(loc, ArmorStand.class);
					as.setGravity(true);
					as.setVisible(false);
					as.setSmall(true);
					as.setHelmet(new ItemStack(Material.SLIME_BLOCK));
					balls.add(as);
					
					VersionsManager.getVClass().entityMoove(pet.getEntity(), as.getLocation(), 1);
					
					new BukkitRunnable() {
						
						boolean get = false;
						
						@Override
						public void run() {
							
							if(!get) {
								
								if(as.getLocation().distance(pet.getEntity().getLocation()) < 1) {
									
									as.setGravity(false);
									get = true;
									
								}
								
							}else {
								
								pet.setMoove(true);
								as.teleport(pet.getEntity().getLocation().add(0, 1, 0));
								
								if(pet.getEntity().getLocation().distance(p.getLocation()) < 1) {
									
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
							
						}
						
					}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					
				}
				
			}, 5);
			
		}
		
	}

}
