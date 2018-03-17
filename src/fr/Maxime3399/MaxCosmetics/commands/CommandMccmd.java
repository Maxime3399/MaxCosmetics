package fr.Maxime3399.MaxCosmetics.commands;

import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.menus.CosPetsMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class CommandMccmd {

	public static void command(CommandSender sender, String cmd, String label, String[] args) {
		
		if(sender instanceof ConsoleCommandSender) {
			
			MessageUtils.sendConsoleMessage("console_cmd_error");
			
		}
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			MaxPlayer mp = PlayersManager.getMaxPlayer(p);
			
			if(mp.isMccmd()) {
				
				if(args.length == 1) {
					
					String action = args[0];
					
					if(action.equalsIgnoreCase("pet_rename_cancell")) {
						
						mp.setMccmd(false);
						p.sendMessage(MessageUtils.getString("player_rename_cancell"));
						p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
						CosPetsMenu.openMenu(p, mp.getInvData());
						
					}
					
				}
				
			}else {
				
				p.sendMessage(MessageUtils.getString("player_cmd_error"));
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
				
			}
			
		}
		
	}
	
}
