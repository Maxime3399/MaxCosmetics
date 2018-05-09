package fr.Maxime3399.MaxCosmetics.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class ExerciseMenu {
	
	public static void openMenu(Player open, Player data, String pet) {
		
		Inventory i = Bukkit.createInventory(null, 18, MessageUtils.getString("menu_name_exercise"));
		MaxPlayer mp = PlayersManager.getMaxPlayer(open);
		mp.setInvData(data);
		mp.setFoodpet(pet);
		MaxPlayer mpd = PlayersManager.getMaxPlayer(data);
		
		ItemStack IStball = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMtball = IStball.getItemMeta();
		ArrayList<String> ALtball = new ArrayList<>();
		ALtball.add(MessageUtils.getString("menu_item_toy_ball_add_1"));
		ALtball.add(MessageUtils.getString("menu_item_toy_ball_add_2"));
		ALtball.add(MessageUtils.getString("menu_item_food_posses")+mpd.getToy_ball());
		ALtball.add(" ");
		if(mpd.getToy_ball() > 0) {
			IStball = new ItemStack(Material.SLIME_BALL);
			if(mpd.getToy_ball() <= 64) {
				IStball.setAmount(mpd.getToy_ball());
			}else {
				IStball.setAmount(64);
			}
			IMtball = IStball.getItemMeta();
			IMtball.setDisplayName(MessageUtils.getString("menu_item_toy_ball"));
			if(PetsList.getPetExercise(mpd, pet) <= 99) {
				ALtball.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALtball.add(MessageUtils.getString("menu_item_food_tired"));
				ALtball.add(" ");
				ALtball.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMtball.setDisplayName(MessageUtils.getString("menu_item_toy_ball_no"));
			ALtball.add(MessageUtils.getString("menu_item_get"));
			ALtball.add(" ");
			if(mpd.getGold() >= 1) {
				ALtball.add(MessageUtils.getString("menu_item_toy_ball_pay"));
			}else {
				ALtball.add(MessageUtils.getString("menu_item_toy_ball_pay_no"));
			}
		}
		IMtball.setLore(ALtball);
		IStball.setItemMeta(IMtball);
		i.addItem(IStball);
		
		ItemStack IStfreesbie = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMtfreesbie = IStfreesbie.getItemMeta();
		ArrayList<String> ALtfreesbie = new ArrayList<>();
		ALtfreesbie.add(MessageUtils.getString("menu_item_toy_freesbie_add_1"));
		ALtfreesbie.add(MessageUtils.getString("menu_item_toy_freesbie_add_2"));
		ALtfreesbie.add(MessageUtils.getString("menu_item_food_posses")+mpd.getToy_freesbie());
		ALtfreesbie.add(" ");
		if(mpd.getToy_freesbie() > 0) {
			IStfreesbie = new ItemStack(Material.CARPET);
			if(mpd.getToy_freesbie() <= 64) {
				IStfreesbie.setAmount(mpd.getToy_freesbie());
			}else {
				IStfreesbie.setAmount(64);
			}
			IMtfreesbie = IStfreesbie.getItemMeta();
			IMtfreesbie.setDisplayName(MessageUtils.getString("menu_item_toy_freesbie"));
			if(PetsList.getPetExercise(mpd, pet) <= 99) {
				ALtfreesbie.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALtfreesbie.add(MessageUtils.getString("menu_item_food_tired"));
				ALtfreesbie.add(" ");
				ALtfreesbie.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMtfreesbie.setDisplayName(MessageUtils.getString("menu_item_toy_freesbie_no"));
			ALtfreesbie.add(MessageUtils.getString("menu_item_get"));
			ALtfreesbie.add(" ");
			if(mpd.getGold() >= 1) {
				ALtfreesbie.add(MessageUtils.getString("menu_item_toy_freesbie_pay"));
			}else {
				ALtfreesbie.add(MessageUtils.getString("menu_item_toy_freesbie_pay_no"));
			}
		}
		IMtfreesbie.setLore(ALtfreesbie);
		IStfreesbie.setItemMeta(IMtfreesbie);
		i.addItem(IStfreesbie);
		
		open.openInventory(i);
		
	}

}
