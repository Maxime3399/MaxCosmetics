package fr.Maxime3399.MaxCosmetics.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class BlockUtils {

	 public static List<Location> circle (Location loc, Integer radius, Integer height, Boolean hollow, Boolean sphere, int plus_y) {
         List<Location> circleblocks = new ArrayList<Location>();
         int cx = loc.getBlockX();
         int cy = loc.getBlockY();
         int cz = loc.getBlockZ();
         for (int x = cx - radius; x <= cx +radius; x++)
             for (int z = cz - radius; z <= cz +radius; z++)
                 for (int y = (sphere ? cy - radius : cy); y < (sphere ? cy + radius : cy + height); y++) {
                     double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
                     if (dist < radius*radius && !(hollow && dist < (radius-1)*(radius-1))) {
                         Location l = new Location(loc.getWorld(), x, y + plus_y, z);
                         circleblocks.add(l);
                         }
                     }
  
         return circleblocks;
     }
	
}
