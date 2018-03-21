package fr.Maxime3399.MaxCosmetics;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Maxime3399.MaxCosmetics.commands.CommandMccmd;
import fr.Maxime3399.MaxCosmetics.custom.Pet;
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
		
		if(VersionsManager.setupVersion()) {
			
			File f = new File(getDataFolder(), "config.yml");
			if(!f.exists()) {
				
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
				
			}
			
			if(MySQLUtils.connect()) {
				
				if(MySQLUtils.execute("CREATE TABLE IF NOT EXISTS `#database#`.`maxcosmetics_players` ( `uuid` VARCHAR(255) NOT NULL , `gold` INT(255) NOT NULL , `lootbox` VARCHAR(255) NOT NULL , `enable` VARCHAR(255) NOT NULL , `pet_silverfish` VARCHAR(255) NOT NULL , `pet_silverfish_name` VARCHAR(255) NOT NULL , `pet_silverfish_level` INT(255) NOT NULL , `pet_silverfish_exp` INT(255) NOT NULL , `pet_silverfish_hunger` INT(255) NOT NULL , `pet_silverfish_thirst` INT(255) NOT NULL , `pet_silverfish_exercise` INT(255) NOT NULL , `pet_catblack` VARCHAR(255) NOT NULL , `pet_catblack_name` VARCHAR(255) NOT NULL , `pet_catblack_level` INT(255) NOT NULL , `pet_catblack_exp` INT(255) NOT NULL , `pet_catblack_hunger` INT(255) NOT NULL , `pet_catblack_thirst` INT(255) NOT NULL , `pet_catblack_exercise` INT(255) NOT NULL , `pet_catblackbaby` VARCHAR(255) NOT NULL , `pet_catblackbaby_name` VARCHAR(255) NOT NULL , `pet_catblackbaby_level` INT(255) NOT NULL , `pet_catblackbaby_exp` INT(255) NOT NULL , `pet_catblackbaby_hunger` INT(255) NOT NULL , `pet_catblackbaby_thirst` INT(255) NOT NULL , `pet_catblackbaby_exercise` INT(255) NOT NULL , PRIMARY KEY (`uuid`)) ENGINE = MyISAM;", false)) {
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						
						PlayersManager.addPlayer(pls);
						
					}
					EventsManager.registerEvents();
					PetsManager.startScheduler();
					MessageUtils.sendConsoleMessage("console_load_success");
					
				}else {
					
					MessageUtils.sendConsoleMessage("console_table_error");
					disable();
					
				}
				
			}else {
				
				MessageUtils.sendConsoleMessage("console_database_error");
				disable();
				
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
