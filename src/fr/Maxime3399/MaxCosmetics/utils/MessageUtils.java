package fr.Maxime3399.MaxCosmetics.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageUtils {
	
	public static void sendPlayerMessage(Player p, String MessageID) {
		
		if(MessageID.equals("player_other_pay_no")) {
			p.sendMessage("§cCe joueur n'as pas assez d'§6or§c !");
		}else if(MessageID.equals("player_you_pay_no")) {
			p.sendMessage("§cTu n'as pas assez d'§6or§c !");
		}else if(MessageID.equals("player_pay_success")) {
			p.sendMessage("§aAchat effectué !");
		}else if(MessageID.equals("player_pay_cancell")) {
			p.sendMessage("§cAchat annulé !");
		}
		
	}
	
	public static void sendConsoleMessage(String MessageID) {
		
		if(MessageID.equals("console_database_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cUne erreur est survenue lors de la connexion à la base de données !");
		}else if(MessageID.equals("console_version_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cCette version n'est pas compatible !");
		}else if(MessageID.equals("console_load_success")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §aLe plugin a correctement démarré !");
		}else if(MessageID.equals("console_table_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cLes table n'ont pas pu êres crées dans la base de données !");
		}
		
	}
	
	public static String getString(String MessageID) {
		
		String result = "";
		
		if(MessageID.equals("menu_item_cos_main_pets")) {
			result = "§aAnimaux";
		}else if(MessageID.equals("menu_item_cos_main_pets_unlocked")) {
			result = "§7Débloqué : ";
		}else if(MessageID.equals("menu_name_cos_main")) {
			result = "§8Cosmétiques";
		}else if(MessageID.equals("menu_name_cos_pets")) {
			result = "§8Animaux";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish")) {
			result = "§aPoisson d'argent";
		}else if(MessageID.equals("menu_item_cos_pets_name")) {
			result = "§7Nom : §r";
		}else if(MessageID.equals("menu_item_cos_pets_level")) {
			result = "§7Niveau : ";
		}else if(MessageID.equals("menu_item_cos_pets_exp")) {
			result = "§7XP : §r";
		}else if(MessageID.equals("menu_item_cos_pets_hunger")) {
			result = "§7Faim : §r";
		}else if(MessageID.equals("menu_item_cos_pets_thirst")) {
			result = "§7Soif : §r";
		}else if(MessageID.equals("menu_item_cos_pets_exercise")) {
			result = "§7Exercice : §r";
		}else if(MessageID.equals("menu_item_cos_pets_left")) {
			result = "§6Clique gauche §7pour faire apparaître";
		}else if(MessageID.equals("menu_item_cos_pets_right")) {
			result = "§bClique droit §7pour nourir";
		}else if(MessageID.equals("menu_item_cos_pets_middle")) {
			result = "§eClique molette §7pour renommer";
		}else if(MessageID.equals("menu_item_cos_pets_found")) {
			result = "§7Trouvable dans un §bCoffre mystère";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay")) {
			result = "§eObtenable pour §610 or";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay_no")) {
			result = "§cIl te faut §610 or";
		}
		
		return result;
		
	}

}
