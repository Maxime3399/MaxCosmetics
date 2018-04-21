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
		}else if(MessageID.equals("console_config")) {
			Bukkit.getConsoleSender().sendMessage("§6§l[§r§3Max§9Cosmetics§6§l]§r §cLe fichier de configuration a été créé ! Merci de configurer le plugin.");
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
		}else if(MessageID.equals("menu_name_exercise")) {
			result = "§8Jouets";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish")) {
			result = "Poisson d'argent";
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
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay")) {
			result = "§eAchetable pour §6#COST# or";
		}else if(MessageID.equals("menu_item_cos_pets_silverfish_pay_no")) {
			result = "§cIl te faut §6#COST# or";
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
			result = "§c§oTon animal ne peut pas appraître si il";
		}else if(MessageID.equals("menu_item_cos_pets_bar_2")) {
			result = "§c§oa faim, soif ou est fatigué.";
		}else if(MessageID.equals("player_pet_spawn_bar")) {
			result = "§cTon animal ne peut pas apparaître si il a faim, soif ou est fatigué.";
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
			result = "§c§oTon animal a assez mangé !";
		}else if(MessageID.equals("menu_item_drink_nothirst")) {
			result = "§c§oTon animal n'a pas soif !";
		}else if(MessageID.equals("menu_item_food_tired")) {
			result = "§c§oTon animal a assez mangé !";
		}else if(MessageID.equals("menu_item_get")) {
			result = "§7Obtenable dans un §bCoffre mystère";
		}else if(MessageID.equals("menu_item_food_apple_pay")) {
			result = "§eAchetable pour §61 or";
		}else if(MessageID.equals("menu_item_food_apple_pay_no")) {
			result = "§cIl te faut §61 or";
		}else if(MessageID.equals("player_hunger_max")) {
			result = "§cTon animal a assez mangé !";
		}else if(MessageID.equals("player_thirst_max")) {
			result = "§cTon animal n'a pas soif !";
		}else if(MessageID.equals("player_exercise_max")) {
			result = "§cTon animal est fatigué !";
		}else if(MessageID.equals("menu_item_food_apple_add")) {
			result = "§7Nouriture : §a+5";
		}else if(MessageID.equals("menu_item_food_bread_add")) {
			result = "§7Nouriture : §a+10";
		}else if(MessageID.equals("menu_item_food_bread")) {
			result = "§ePain";
		}else if(MessageID.equals("menu_item_food_bread_no")) {
			result = "§6Pain";
		}else if(MessageID.equals("menu_item_food_bread_pay")) {
			result = "§eAchetable pour §62 or";
		}else if(MessageID.equals("menu_item_food_bread_pay_no")) {
			result = "§cIl te faut §62 or";
		}else if(MessageID.equals("menu_item_food_posses")) {
			result = "§7Possédé : §r";
		}else if(MessageID.equals("menu_item_food_carrot_add")) {
			result = "§7Nouriture : §a+15";
		}else if(MessageID.equals("menu_item_food_carrot")) {
			result = "§eCarotte";
		}else if(MessageID.equals("menu_item_food_carrot_no")) {
			result = "§6Carotte";
		}else if(MessageID.equals("menu_item_food_carrot_pay")) {
			result = "§eAchetable pour §63 or";
		}else if(MessageID.equals("menu_item_food_carrot_pay_no")) {
			result = "§cIl te faut §63 or";
		}else if(MessageID.equals("player_pet_levelup")) {
			result = "§aTon animal est monté de niveau !";
		}else if(MessageID.equals("player_pet_xexercise")) {
			result = "§cTon animal est fatigué !";
		}else if(MessageID.equals("player_pet_xhunger")) {
			result = "§cTon animal a faim !";
		}else if(MessageID.equals("player_pet_xthirst")) {
			result = "§cTon animal a soif !";
		}else if(MessageID.equals("menu_item_food_potato_add")) {
			result = "§7Nouriture : §a+20";
		}else if(MessageID.equals("menu_item_food_potato")) {
			result = "§ePatate";
		}else if(MessageID.equals("menu_item_food_potato_no")) {
			result = "§6Patate";
		}else if(MessageID.equals("menu_item_food_potato_pay")) {
			result = "§eAchetable pour §64 or";
		}else if(MessageID.equals("menu_item_food_potato_pay_no")) {
			result = "§cIl te faut §64 or";
		}else if(MessageID.equals("menu_item_food_melon_add")) {
			result = "§7Nouriture : §a+25";
		}else if(MessageID.equals("menu_item_food_melon")) {
			result = "§eMelon";
		}else if(MessageID.equals("menu_item_food_melon_no")) {
			result = "§6Melon";
		}else if(MessageID.equals("menu_item_food_melon_pay")) {
			result = "§eAchetable pour §65 or";
		}else if(MessageID.equals("menu_item_food_melon_pay_no")) {
			result = "§cIl te faut §65 or";
		}else if(MessageID.equals("menu_item_food_fish_add")) {
			result = "§7Nouriture : §a+30";
		}else if(MessageID.equals("menu_item_food_fish")) {
			result = "§ePoisson";
		}else if(MessageID.equals("menu_item_food_fish_no")) {
			result = "§6Poisson";
		}else if(MessageID.equals("menu_item_food_fish_pay")) {
			result = "§eAchetable pour §66 or";
		}else if(MessageID.equals("menu_item_food_fish_pay_no")) {
			result = "§cIl te faut §66 or";
		}else if(MessageID.equals("menu_item_food_grass_add")) {
			result = "§7Nouriture : §a+35";
		}else if(MessageID.equals("menu_item_food_grass")) {
			result = "§eHerbe";
		}else if(MessageID.equals("menu_item_food_grass_no")) {
			result = "§6Herbe";
		}else if(MessageID.equals("menu_item_food_grass_pay")) {
			result = "§eAchetable pour §67 or";
		}else if(MessageID.equals("menu_item_food_grass_pay_no")) {
			result = "§cIl te faut §67 or";
		}else if(MessageID.equals("menu_item_food_mushroom_b_add")) {
			result = "§7Nouriture : §a+40";
		}else if(MessageID.equals("menu_item_food_mushroom_b")) {
			result = "§eChampignon marron";
		}else if(MessageID.equals("menu_item_food_mushroom_b_no")) {
			result = "§6Champignon marron";
		}else if(MessageID.equals("menu_item_food_mushroom_b_pay")) {
			result = "§eAchetable pour §68 or";
		}else if(MessageID.equals("menu_item_food_mushroom_b_pay_no")) {
			result = "§cIl te faut §68 or";
		}else if(MessageID.equals("menu_item_food_mushroom_r_add")) {
			result = "§7Nouriture : §a+45";
		}else if(MessageID.equals("menu_item_food_mushroom_r")) {
			result = "§eChampignon rouge";
		}else if(MessageID.equals("menu_item_food_mushroom_r_no")) {
			result = "§6Champignon rouge";
		}else if(MessageID.equals("menu_item_food_mushroom_r_pay")) {
			result = "§eAchetable pour §69 or";
		}else if(MessageID.equals("menu_item_food_mushroom_r_pay_no")) {
			result = "§cIl te faut §69 or";
		}else if(MessageID.equals("menu_item_food_flower_add")) {
			result = "§7Nouriture : §a+50";
		}else if(MessageID.equals("menu_item_food_flower")) {
			result = "§eFleur";
		}else if(MessageID.equals("menu_item_food_flower_no")) {
			result = "§6Fleur";
		}else if(MessageID.equals("menu_item_food_flower_pay")) {
			result = "§eAchetable pour §610 or";
		}else if(MessageID.equals("menu_item_food_flower_pay_no")) {
			result = "§cIl te faut §610 or";
		}else if(MessageID.equals("menu_item_food_wheat_add")) {
			result = "§7Nouriture : §a+55";
		}else if(MessageID.equals("menu_item_food_wheat")) {
			result = "§eBlé";
		}else if(MessageID.equals("menu_item_food_wheat_no")) {
			result = "§6Blé";
		}else if(MessageID.equals("menu_item_food_wheat_pay")) {
			result = "§eAchetable pour §611 or";
		}else if(MessageID.equals("menu_item_food_wheat_pay_no")) {
			result = "§cIl te faut §611 or";
		}else if(MessageID.equals("menu_item_food_cake_add")) {
			result = "§7Nouriture : §a+60";
		}else if(MessageID.equals("menu_item_food_cake")) {
			result = "§eGâteau";
		}else if(MessageID.equals("menu_item_food_cake_no")) {
			result = "§6Gâteau";
		}else if(MessageID.equals("menu_item_food_cake_pay")) {
			result = "§eAchetable pour §612 or";
		}else if(MessageID.equals("menu_item_food_cake_pay_no")) {
			result = "§cIl te faut §612 or";
		}else if(MessageID.equals("menu_item_food_cookie_add")) {
			result = "§7Nouriture : §a+65";
		}else if(MessageID.equals("menu_item_food_cookie")) {
			result = "§eCookie";
		}else if(MessageID.equals("menu_item_food_cookie_no")) {
			result = "§6Cookie";
		}else if(MessageID.equals("menu_item_food_cookie_pay")) {
			result = "§eAchetable pour §613 or";
		}else if(MessageID.equals("menu_item_food_cookie_pay_no")) {
			result = "§cIl te faut §613 or";
		}else if(MessageID.equals("menu_item_food_pie_add")) {
			result = "§7Nouriture : §a+70";
		}else if(MessageID.equals("menu_item_food_pie")) {
			result = "§eTarte à la citrouille";
		}else if(MessageID.equals("menu_item_food_pie_no")) {
			result = "§6Tarte à la citrouille";
		}else if(MessageID.equals("menu_item_food_pie_pay")) {
			result = "§eAchetable pour §614 or";
		}else if(MessageID.equals("menu_item_food_pie_pay_no")) {
			result = "§cIl te faut §614 or";
		}else if(MessageID.equals("menu_item_food_golden_add")) {
			result = "§7Nouriture : §a+75";
		}else if(MessageID.equals("menu_item_food_golden")) {
			result = "§ePomme d'or";
		}else if(MessageID.equals("menu_item_food_golden_no")) {
			result = "§6Pomme d'or";
		}else if(MessageID.equals("menu_item_food_golden_pay")) {
			result = "§eAchetable pour §615 or";
		}else if(MessageID.equals("menu_item_food_golden_pay_no")) {
			result = "§cIl te faut §615 or";
		}else if(MessageID.equals("menu_item_drink_water_add")) {
			result = "§7Soif : §a+20";
		}else if(MessageID.equals("menu_item_drink_water")) {
			result = "§eEau";
		}else if(MessageID.equals("menu_item_drink_water_no")) {
			result = "§6Eau";
		}else if(MessageID.equals("menu_item_drink_water_pay")) {
			result = "§eAchetable pour §63 or";
		}else if(MessageID.equals("menu_item_drink_water_pay_no")) {
			result = "§cIl te faut §63 or";
		}else if(MessageID.equals("menu_item_drink_milk_add")) {
			result = "§7Soif : §a+40";
		}else if(MessageID.equals("menu_item_drink_milk")) {
			result = "§eLait";
		}else if(MessageID.equals("menu_item_drink_milk_no")) {
			result = "§6Lait";
		}else if(MessageID.equals("menu_item_drink_milk_pay")) {
			result = "§eAchetable pour §66 or";
		}else if(MessageID.equals("menu_item_drink_milk_pay_no")) {
			result = "§cIl te faut §66 or";
		}else if(MessageID.equals("menu_item_drink_lava_add")) {
			result = "§7Soif : §a+60";
		}else if(MessageID.equals("menu_item_drink_lava")) {
			result = "§eLave";
		}else if(MessageID.equals("menu_item_drink_lava_no")) {
			result = "§6Lave";
		}else if(MessageID.equals("menu_item_drink_lava_pay")) {
			result = "§eAchetable pour §69 or";
		}else if(MessageID.equals("menu_item_drink_lava_pay_no")) {
			result = "§cIl te faut §69 or";
		}else if(MessageID.equals("menu_item_found")) {
			result = "§7Trouvable dans un #BOX#";
		}else if(MessageID.equals("box_classic")) {
			result = "§bCoffre mystère";
		}else if(MessageID.equals("box_newyear")) {
			result = "§eCoffre de nouvel an";
		}else if(MessageID.equals("box_easter")) {
			result = "§2Coffre de pâques";
		}else if(MessageID.equals("box_summer")) {
			result = "§6Coffre de l'été";
		}else if(MessageID.equals("box_halloween")) {
			result = "§5Coffre d'halloween";
		}else if(MessageID.equals("box_christmas")) {
			result = "§cCoffre de noël";
		}else if(MessageID.equals("menu_item_back")) {
			result = "§7§oRetour";
		}else if(MessageID.equals("menu_item_back_lore_1")) {
			result = "§3Clique §7pour revenir au";
		}else if(MessageID.equals("menu_item_back_lore_2")) {
			result = "§7menu précédent";
		}else if(MessageID.equals("menu_item_gold")) {
			result = "§6Or : #GOLD#";
		}else if(MessageID.equals("player_no_pet")) {
			result = "§cCe n'est pas ton annimal !";
		}else if(MessageID.equals("menu_item_toy_ball_add_1")) {
			result = "§7Exercice : §a+10";
		}else if(MessageID.equals("menu_item_toy_ball_add_2")) {
			result = "§7Expérience : §a+20";
		}else if(MessageID.equals("menu_item_toy_ball")) {
			result = "§eBalle";
		}else if(MessageID.equals("menu_item_toy_ball_no")) {
			result = "§6Balle";
		}else if(MessageID.equals("menu_item_toy_ball_pay")) {
			result = "§eAchetable pour §65 or";
		}else if(MessageID.equals("menu_item_toy_ball_pay_no")) {
			result = "§cIl te faut §65 or";
		}
		return result;
		
	}

}
