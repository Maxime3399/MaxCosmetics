package fr.Maxime3399.MaxCosmetics.actions;

import java.util.ArrayList;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.custom.Pet;

public class PetBallAction {
	
	public static ArrayList<ArmorStand> balls = new ArrayList<>();
	public static boolean use = false;
	
	public static void act(Pet pet, Player p) {
		
		pet.setCanDispawn(false);
		
		
		
	}

}
