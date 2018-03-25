package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.utils.MySQLUtils;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		MySQLUtils.execute("INSERT INTO `maxcosmetics_players` (`uuid`, `gold`, `lootbox`, `enable`, `food_apple`, `food_bread`, `food_carrot`, `food_potato`, `food_melon`, `food_fish`, `food_grass`, `food_mushroom_b`, `food_mushroom_r`, `food_flower`, `food_wheat`, `food_cake`, `food_cookie`, `food_pie`, `food_golden`, `drink_water`, `drink_milk`, `drink_lava`, `toy_ball`, `toy_freesbie`, `toy_laser`, `toy_run`, `pet_silverfish`, `pet_silverfish_name`, `pet_silverfish_level`, `pet_silverfish_exp`, `pet_silverfish_hunger`, `pet_silverfish_thirst`, `pet_silverfish_exercise`, `pet_catblack`, `pet_catblack_name`, `pet_catblack_level`, `pet_catblack_exp`, `pet_catblack_hunger`, `pet_catblack_thirst`, `pet_catblack_exercise`, `pet_catblackbaby`, `pet_catblackbaby_name`, `pet_catblackbaby_level`, `pet_catblackbaby_exp`, `pet_catblackbaby_hunger`, `pet_catblackbaby_thirst`, `pet_catblackbaby_exercise`) VALUES ('"+p.getUniqueId()+"', '0', '', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'false', '', '1', '0', '0', '0', '0', 'false', '', '1', '0', '0', '0', '0', 'false', '', '1', '0', '0', '0', '0');", true);
		PlayersManager.addPlayer(p);
		
		PetsList.spawnPet(p);
		
	}

}
