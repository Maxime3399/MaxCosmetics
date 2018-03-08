package fr.Maxime3399.MaxCosmetics.versions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Versions {
	
	public void sendJSONMessage(Player p, String message);
	
	public ItemStack generateSpawnEgg(int typeID);

}
