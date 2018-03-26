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
		ALfapple.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_appple());
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
				ALfapple.add(MessageUtils.getString("menu_item_food_apple_pay"));
			}else {
				ALfapple.add(MessageUtils.getString("menu_item_food_apple_pay_no"));
			}
		}
		IMfapple.setLore(ALfapple);
		ISfapple.setItemMeta(IMfapple);
		i.addItem(ISfapple);
		
		ItemStack ISfbread = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfbread = ISfbread.getItemMeta();
		ArrayList<String> ALfbread = new ArrayList<>();
		ALfbread.add(MessageUtils.getString("menu_item_food_bread_add"));
		ALfbread.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_bread());
		ALfbread.add(" ");
		if(mpd.getFood_bread() > 0) {
			ISfbread = new ItemStack(Material.BREAD);
			if(mpd.getFood_bread() <= 64) {
				ISfbread.setAmount(mpd.getFood_bread());
			}else {
				ISfbread.setAmount(64);
			}
			IMfbread = ISfbread.getItemMeta();
			IMfbread.setDisplayName(MessageUtils.getString("menu_item_food_bread"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfbread.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfbread.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfbread.add(" ");
				ALfbread.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfbread.setDisplayName(MessageUtils.getString("menu_item_food_bread_no"));
			ALfbread.add(MessageUtils.getString("menu_item_get"));
			ALfbread.add(" ");
			if(mpd.getGold() >= 2) {
				ALfbread.add(MessageUtils.getString("menu_item_food_bread_pay"));
			}else {
				ALfbread.add(MessageUtils.getString("menu_item_food_bread_pay_no"));
			}
		}
		IMfbread.setLore(ALfbread);
		ISfbread.setItemMeta(IMfbread);
		i.addItem(ISfbread);
		
		ItemStack ISfcarrot = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfcarrot = ISfcarrot.getItemMeta();
		ArrayList<String> ALfcarrot = new ArrayList<>();
		ALfcarrot.add(MessageUtils.getString("menu_item_food_carrot_add"));
		ALfcarrot.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_carrot());
		ALfcarrot.add(" ");
		if(mpd.getFood_carrot() > 0) {
			ISfcarrot = new ItemStack(Material.CARROT_ITEM);
			if(mpd.getFood_carrot() <= 64) {
				ISfcarrot.setAmount(mpd.getFood_carrot());
			}else {
				ISfcarrot.setAmount(64);
			}
			IMfcarrot = ISfcarrot.getItemMeta();
			IMfcarrot.setDisplayName(MessageUtils.getString("menu_item_food_carrot"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfcarrot.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfcarrot.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfcarrot.add(" ");
				ALfcarrot.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfcarrot.setDisplayName(MessageUtils.getString("menu_item_food_carrot_no"));
			ALfcarrot.add(MessageUtils.getString("menu_item_get"));
			ALfcarrot.add(" ");
			if(mpd.getGold() >= 3) {
				ALfcarrot.add(MessageUtils.getString("menu_item_food_carrot_pay"));
			}else {
				ALfcarrot.add(MessageUtils.getString("menu_item_food_carrot_pay_no"));
			}
		}
		IMfcarrot.setLore(ALfcarrot);
		ISfcarrot.setItemMeta(IMfcarrot);
		i.addItem(ISfcarrot);
		
		open.openInventory(i);
		
	}

}
