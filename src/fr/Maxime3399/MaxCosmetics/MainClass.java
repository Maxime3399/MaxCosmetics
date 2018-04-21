package fr.Maxime3399.MaxCosmetics;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Maxime3399.MaxCosmetics.actions.PetBallAction;
import fr.Maxime3399.MaxCosmetics.commands.CommandMccmd;
import fr.Maxime3399.MaxCosmetics.custom.Pet;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.EventsManager;
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.menus.CosMainMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;
import fr.Maxime3399.MaxCosmetics.utils.MySQLUtils;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		PetsManager.use = true;
		PlayersManager.use = true;
		PetBallAction.use = true;
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				
				MessageUtils.sendConsoleMessage("console_config");
				disable();
				
			}else {
				
				if(MySQLUtils.connect()) {
					
					if(MySQLUtils.execute("\r\n" + 
							"CREATE TABLE IF NOT EXISTS `maxcosmetics_players` (\r\n" + 
							"  `uuid` varchar(255) NOT NULL,\r\n" + 
							"  `gold` int(255) NOT NULL,\r\n" + 
							"  `lootbox` varchar(255) NOT NULL,\r\n" + 
							"  `enable` varchar(255) NOT NULL,\r\n" + 
							"  `last_connect` varchar(255) NOT NULL,\r\n" + 
							"  `food_apple` int(255) NOT NULL,\r\n" + 
							"  `food_bread` int(255) NOT NULL,\r\n" + 
							"  `food_carrot` int(255) NOT NULL,\r\n" + 
							"  `food_potato` int(255) NOT NULL,\r\n" + 
							"  `food_melon` int(255) NOT NULL,\r\n" + 
							"  `food_fish` int(255) NOT NULL,\r\n" + 
							"  `food_grass` int(255) NOT NULL,\r\n" + 
							"  `food_mushroom_b` int(255) NOT NULL,\r\n" + 
							"  `food_mushroom_r` int(255) NOT NULL,\r\n" + 
							"  `food_flower` int(255) NOT NULL,\r\n" + 
							"  `food_wheat` int(255) NOT NULL,\r\n" + 
							"  `food_cake` int(255) NOT NULL,\r\n" + 
							"  `food_cookie` int(255) NOT NULL,\r\n" + 
							"  `food_pie` int(255) NOT NULL,\r\n" + 
							"  `food_golden` int(255) NOT NULL,\r\n" + 
							"  `drink_water` int(255) NOT NULL,\r\n" + 
							"  `drink_milk` int(255) NOT NULL,\r\n" + 
							"  `drink_lava` int(255) NOT NULL,\r\n" + 
							"  `toy_ball` int(255) NOT NULL,\r\n" + 
							"  `toy_freesbie` int(255) NOT NULL,\r\n" + 
							"  `toy_laser` int(255) NOT NULL,\r\n" + 
							"  `toy_run` int(255) NOT NULL,\r\n" + 
							"  `pet_silverfish` varchar(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_name` varchar(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_level` int(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_exp` int(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_hunger` int(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_thirst` int(255) NOT NULL,\r\n" + 
							"  `pet_silverfish_exercise` int(255) NOT NULL,\r\n" + 
							"  `pet_catblack` varchar(255) NOT NULL,\r\n" + 
							"  `pet_catblack_name` varchar(255) NOT NULL,\r\n" + 
							"  `pet_catblack_level` int(255) NOT NULL,\r\n" + 
							"  `pet_catblack_exp` int(255) NOT NULL,\r\n" + 
							"  `pet_catblack_hunger` int(255) NOT NULL,\r\n" + 
							"  `pet_catblack_thirst` int(255) NOT NULL,\r\n" + 
							"  `pet_catblack_exercise` int(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby` varchar(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_name` varchar(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_level` int(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_exp` int(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_hunger` int(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_thirst` int(255) NOT NULL,\r\n" + 
							"  `pet_catblackbaby_exercise` int(255) NOT NULL,\r\n" + 
							"  PRIMARY KEY (`uuid`)\r\n" + 
							") ENGINE=MyISAM DEFAULT CHARSET=latin1;", false)) {
						
						for(Player pls : Bukkit.getOnlinePlayers()) {
							
							PlayersManager.addPlayer(pls);
							
						}
						EventsManager.registerEvents();
						PetsManager.startScheduler();
						MessageUtils.sendConsoleMessage("console_load_success");
						for(Player pls : Bukkit.getOnlinePlayers()) {
							
							PetsList.spawnPet(pls);
							
						}
						
					}else {
						
						MessageUtils.sendConsoleMessage("console_table_error");
						disable();
						
					}
					
				}else {
					
					MessageUtils.sendConsoleMessage("console_database_error");
					disable();
					
				}
				
			}
			
		}else {
			
			MessageUtils.sendConsoleMessage("console_version_error");
			disable();
			
		}
		
	}
	
	public void onDisable() {
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			if(PetsManager.havePet(pls)) {
				PetsManager.removePet(PetsManager.getPlayerPet(pls));
			}
			PlayersManager.removePlayer(pls);
			
		}
		
		for(ArmorStand as : PetBallAction.balls) {
			
			as.remove();
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}
	
	private static void disable() {
		
		Bukkit.getPluginManager().disablePlugin(plugin);
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		
		if(cmd.getName().equalsIgnoreCase("cos")) {
			
			Player p = (Player) sender;
			CosMainMenu.openMenu(p, p);
			
		}else if(cmd.getName().equalsIgnoreCase("mccmd")) {
			CommandMccmd.command(sender, cmd.getName(), label, args);
		}else if(cmd.getName().equalsIgnoreCase("test")) {
			
			Player p = (Player) sender;
			Pet pet = PetsManager.getPlayerPet(p);
			VersionsManager.getVClass().entityMoove(pet.getEntity(), p.getLocation(), 2);
			
		}else if(cmd.getName().equalsIgnoreCase("rm")) {
			
			for(Entity e : Bukkit.getWorld("world").getEntities()) {
				
				if(e.getCustomName() != null) {
					
					if(e.getCustomName().equalsIgnoreCase("§0TEST")) {
						
						e.remove();
						
					}
					
				}
				
			}
			
		}
		
		return true;
		
	}

}
