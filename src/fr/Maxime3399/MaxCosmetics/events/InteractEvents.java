package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;
import fr.Maxime3399.MaxCosmetics.menus.ExerciseMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class InteractEvents implements Listener {
	
	@EventHandler
	public void onInteractEntity(PlayerInteractAtEntityEvent e) {
		
		boolean entity = false;
		Pet pet = null;
		
		for(Pet pets : PetsManager.getPets()) {
			
			if(pets.getEntity().equals(e.getRightClicked())) {
				
				entity = true;
				pet = pets;
				
			}
			
		}
		
		if(entity) {
			
			Player p = e.getPlayer();
			
			if(pet.getPlayer().equals(p)) {
				
				ExerciseMenu.openMenu(p, p, pet.getType());
				p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 100, 1);
				
			}else {
				
				if(p.hasPermission("maxcosmetics.other")) {
					
					ExerciseMenu.openMenu(p, p.getPlayer(), pet.getType());
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 100, 1);
					
				}else {
					
					p.sendMessage(MessageUtils.getString("player_no_pet"));
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					
				}
				
			}
			
		}
		
	}

}
