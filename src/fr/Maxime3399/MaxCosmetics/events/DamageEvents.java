package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;

public class DamageEvents implements Listener {
	
	@EventHandler
	public void onDamege(EntityDamageEvent e) {
		
		for(Pet pets : PetsManager.getPets()) {
			
			if(pets.getEntity() == e.getEntity()) {
				
				e.setCancelled(true);
				
			}
			
		}
		
	}

}
