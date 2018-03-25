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

public class FoodMenu {
	
	public static void openMenu(Player open, Player data, String pet) {
		
		Inventory i = Bukkit.createInventory(null, 27, MessageUtils.getString("menu_name_food"));
		MaxPlayer mp = PlayersManager.getMaxPlayer(open);
		mp.setInvData(data);
		mp.setFoodpet(pet);
		MaxPlayer mpd = PlayersManager.getMaxPlayer(mp.getInvData());
		
		ItemStack ISfapple = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfapple = ISfapple.getItemMeta();
		ArrayList<String> ALfapple = new ArrayList<>();
		ALfapple.add(MessageUtils.getString("menu_item_food_apple_add"));
		ALfapple.add(" ");
		if(mpd.getFood_appple() > 0) {
			ISfapple = new ItemStack(Material.APPLE);
			if(mpd.getFood_appple() <= 64) {
				ISfapple.setAmount(mpd.getFood_appple());
			}else {
				ISfapple.setAmount(64);
			}
			IMfapple = ISfapple.getItemMeta();
			IMfapple.setDisplayName(MessageUtils.getString("menu_item_food_apple"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfapple.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfapple.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfapple.add(" ");
				ALfapple.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfapple.setDisplayName(MessageUtils.getString("menu_item_food_apple_no"));
			ALfapple.add(MessageUtils.getString("menu_item_get"));
			ALfapple.add(" ");
			if(mpd.getGold() >= 1) {
				ALfapple.add(MessageUtils.getString("menu_item_food_pay"));
			}else {
				ALfapple.add(MessageUtils.getString("menu_item_food_pay_no"));
			}
		}
		IMfapple.setLore(ALfapple);
		ISfapple.setItemMeta(IMfapple);
		i.addItem(ISfapple);
		
		open.openInventory(i);
		
	}

}
