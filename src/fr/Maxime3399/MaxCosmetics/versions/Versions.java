package fr.Maxime3399.MaxCosmetics.versions;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Versions {
	
	public void sendJSONMessage(Player p, String message);
	
	public ItemStack generateSpawnEgg(int typeID);
	
	public void entityMoove(Entity e, Location loc, double speed);

}
