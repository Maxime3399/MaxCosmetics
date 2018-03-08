package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.menus.ConfirmMenu;

public class EventsManager {
	
	public static void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		Plugin p = MainClass.getInstance();
		
		pm.registerEvents(new PlayerJoin(), p);
		pm.registerEvents(new PlayerQuit(), p);
		pm.registerEvents(new ConfirmMenu(), p);
		pm.registerEvents(new CosMainMenuEvents(), p);
		pm.registerEvents(new CosPetsMenuEvents(), p);
		
	}

}
