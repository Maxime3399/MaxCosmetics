package fr.Maxime3399.MaxCosmetics.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.events.ChatEvents;
import fr.Maxime3399.MaxCosmetics.events.CosMainMenuEvents;
import fr.Maxime3399.MaxCosmetics.events.CosPetsMenuEvents;
import fr.Maxime3399.MaxCosmetics.events.PlayerJoin;
import fr.Maxime3399.MaxCosmetics.events.PlayerQuit;
import fr.Maxime3399.MaxCosmetics.menus.ConfirmMenu;

public class EventsManager {
	
	public static void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		Plugin p = MainClass.getInstance();
		
		//Classic events
		pm.registerEvents(new PlayerJoin(), p);
		pm.registerEvents(new PlayerQuit(), p);
		pm.registerEvents(new ChatEvents(), p);
		
		//Menu events
		pm.registerEvents(new ConfirmMenu(), p);
		pm.registerEvents(new CosMainMenuEvents(), p);
		pm.registerEvents(new CosPetsMenuEvents(), p);
		
	}

}
