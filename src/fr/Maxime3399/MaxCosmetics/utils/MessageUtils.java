package fr.Maxime3399.MaxCosmetics.utils;

import org.bukkit.Bukkit;

public class MessageUtils {
	
	public static void sendConsoleMessage(String MessageID) {
		
		if(MessageID.equals("console_database_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cUne erreur est survenue lors de la connexion à la base de données !");
		}else if(MessageID.equals("console_version_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cCette version n'est pas compatible !");
		}else if(MessageID.equals("console_load_success")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §aLe plugin a correctement démarré !");
		}else if(MessageID.equals("console_table_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cLes table n'ont pas pu êres crées dans la base de données !");
		}else if(MessageID.equals("console_cmd_error")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cCette commande ne peut pas être utilisée par la console !");
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
		}else if(MessageID.equals("menu_item_cos_pets_left_no")) {
			result = "§c§mClique gauche pour faire apparaître";
		}else if(MessageID.equals("menu_item_cos_pets_left_spawn")) {
			result = "§6Clique gauche §7pour faire apparaître";
		}else if(MessageID.equals("menu_item_cos_pets_left_dispawn")) {
			result = "§6Clique gauche §7pour faire dispparaître";
		}else if(MessageID.equals("menu_item_cos_pets_right")) {
			result = "§bClique droit §7pour nourir";
		}else if(MessageID.equals("menu_item_cos_pets_middle")) {
			result = "§eClique molette §7pour renommer";
		}else if(MessageID.equals("menu_item_found")) {
			result = "§7Trouvable dans un §bCoffre mystère";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay")) {
			result = "§eAchetable pour §610 or";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay_no")) {
			result = "§cIl te faut §610 or";
		}else if(MessageID.equals("player_other_pay_no")) {
			result = "§cCe joueur n'as pas assez d'§6or§c !";
		}else if(MessageID.equals("player_you_pay_no")) {
			result = "§cTu n'as pas assez d'§6or§c !";
		}else if(MessageID.equals("player_pay_success")) {
			result = "§aAchat effectué !";
		}else if(MessageID.equals("player_pay_cancell")) {
			result = "§cAchat annulé !";
		}else if(MessageID.equals("player_disconnected")) {
			result = "§cLe joueur s'est déconnecté !";
		}else if(MessageID.equals("player_rename_space")) {
			result = "§cLe nom ne peut pas contenir d'espaces !";
		}else if(MessageID.equals("player_rename_success")) {
			result = "§aNom modifié !";
		}else if(MessageID.equals("player_rename_info")) {
			result = "§eEcris dans le chat le nouveau nom de ton animal";
		}else if(MessageID.equals("super_cancell")) {
			result = " §c§l[ANNULER]";
		}else if(MessageID.equals("player_cmd_error")) {
			result = " §cTu ne peux pas utiliser cette commande !";
		}else if(MessageID.equals("player_rename_cancell")) {
			result = "§cChangement de nom annulé !";
		}else if(MessageID.equals("menu_item_cos_pets_bar_1")) {
			result = "§c§oTon animal ne peut pas appraître";
		}else if(MessageID.equals("menu_item_cos_pets_bar_2")) {
			result = "§c§osi il a soif ou faim.";
		}else if(MessageID.equals("player_pet_spawn_bar")) {
			result = "§cTon animal ne peut pas apparaître si il a faim ou soif.";
		}else if(MessageID.equals("menu_name_food")) {
			result = "§8Nourrir";
		}else if(MessageID.equals("menu_item_food_apple")) {
			result = "§ePomme";
		}else if(MessageID.equals("menu_item_food_apple_no")) {
			result = "§6Pomme";
		}else if(MessageID.equals("menu_item_food_click_eat")) {
			result = "§3Clique §7pour donner";
		}else if(MessageID.equals("menu_item_food_click_eat_no")) {
			result = "§c§mClique pour donner";
		}else if(MessageID.equals("menu_item_food_nohunger")) {
			result = "§cTon animal a assez mangé !";
		}else if(MessageID.equals("menu_item_get")) {
			result = "§7Obtenable dans un §bCoffre mystère";
		}else if(MessageID.equals("menu_item_food_pay")) {
			result = "§eAchetable pour §61 or";
		}else if(MessageID.equals("menu_item_food_pay_no")) {
			result = "§cIl te faut §61 or";
		}else if(MessageID.equals("player_hunger_max")) {
			result = "§cTon animal a assez mangé !";
		}else if(MessageID.equals("menu_item_food_apple_add")) {
			result = "§7Nouriture : §a+5";
		}
		
		return result;
		
	}

}
