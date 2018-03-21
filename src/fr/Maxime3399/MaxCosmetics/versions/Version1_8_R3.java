package fr.Maxime3399.MaxCosmetics.versions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Version1_8_R3 implements Versions{
	
	public void sendJSONMessage(Player p, String message) {
		
		IChatBaseComponent comp = ChatSerializer.a(message);
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
		
	}
	
	public ItemStack generateSpawnEgg(int typeID) {
		
		ItemStack IS = new ItemStack(Material.MONSTER_EGG, 1, (short) typeID);
		
		return IS;
		
	}
	
	public void entityMoove(Entity e, Location loc, double speed) {
		
		((EntityInsentient) ((CraftEntity) e).getHandle()).getNavigation().a(loc.getX(), loc.getY(), loc.getZ(), speed);
		
	}

}
