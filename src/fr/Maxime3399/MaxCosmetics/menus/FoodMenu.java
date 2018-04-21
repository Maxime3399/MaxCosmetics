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
		
		Inventory i = Bukkit.createInventory(null, 45, MessageUtils.getString("menu_name_food"));
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
		
		ItemStack ISfpotato = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfpotato = ISfpotato.getItemMeta();
		ArrayList<String> ALfpotato = new ArrayList<>();
		ALfpotato.add(MessageUtils.getString("menu_item_food_potato_add"));
		ALfpotato.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_potato());
		ALfpotato.add(" ");
		if(mpd.getFood_potato() > 0) {
			ISfpotato = new ItemStack(Material.POTATO_ITEM);
			if(mpd.getFood_potato() <= 64) {
				ISfpotato.setAmount(mpd.getFood_potato());
			}else {
				ISfpotato.setAmount(64);
			}
			IMfpotato = ISfpotato.getItemMeta();
			IMfpotato.setDisplayName(MessageUtils.getString("menu_item_food_potato"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfpotato.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfpotato.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfpotato.add(" ");
				ALfpotato.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfpotato.setDisplayName(MessageUtils.getString("menu_item_food_potato_no"));
			ALfpotato.add(MessageUtils.getString("menu_item_get"));
			ALfpotato.add(" ");
			if(mpd.getGold() >= 4) {
				ALfpotato.add(MessageUtils.getString("menu_item_food_potato_pay"));
			}else {
				ALfpotato.add(MessageUtils.getString("menu_item_food_potato_pay_no"));
			}
		}
		IMfpotato.setLore(ALfpotato);
		ISfpotato.setItemMeta(IMfpotato);
		i.addItem(ISfpotato);
		
		ItemStack ISfmelon = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfmelon = ISfmelon.getItemMeta();
		ArrayList<String> ALfmelon = new ArrayList<>();
		ALfmelon.add(MessageUtils.getString("menu_item_food_melon_add"));
		ALfmelon.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_melon());
		ALfmelon.add(" ");
		if(mpd.getFood_melon() > 0) {
			ISfmelon = new ItemStack(Material.MELON_BLOCK);
			if(mpd.getFood_melon() <= 64) {
				ISfmelon.setAmount(mpd.getFood_melon());
			}else {
				ISfmelon.setAmount(64);
			}
			IMfmelon = ISfmelon.getItemMeta();
			IMfmelon.setDisplayName(MessageUtils.getString("menu_item_food_melon"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfmelon.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfmelon.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfmelon.add(" ");
				ALfmelon.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfmelon.setDisplayName(MessageUtils.getString("menu_item_food_melon_no"));
			ALfmelon.add(MessageUtils.getString("menu_item_get"));
			ALfmelon.add(" ");
			if(mpd.getGold() >= 5) {
				ALfmelon.add(MessageUtils.getString("menu_item_food_melon_pay"));
			}else {
				ALfmelon.add(MessageUtils.getString("menu_item_food_melon_pay_no"));
			}
		}
		IMfmelon.setLore(ALfmelon);
		ISfmelon.setItemMeta(IMfmelon);
		i.addItem(ISfmelon);
		
		ItemStack ISffish = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMffish = ISffish.getItemMeta();
		ArrayList<String> ALffish = new ArrayList<>();
		ALffish.add(MessageUtils.getString("menu_item_food_fish_add"));
		ALffish.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_fish());
		ALffish.add(" ");
		if(mpd.getFood_fish() > 0) {
			ISffish = new ItemStack(Material.COOKED_FISH);
			if(mpd.getFood_fish() <= 64) {
				ISffish.setAmount(mpd.getFood_fish());
			}else {
				ISffish.setAmount(64);
			}
			IMffish = ISffish.getItemMeta();
			IMffish.setDisplayName(MessageUtils.getString("menu_item_food_fish"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALffish.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALffish.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALffish.add(" ");
				ALffish.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMffish.setDisplayName(MessageUtils.getString("menu_item_food_fish_no"));
			ALffish.add(MessageUtils.getString("menu_item_get"));
			ALffish.add(" ");
			if(mpd.getGold() >= 6) {
				ALffish.add(MessageUtils.getString("menu_item_food_fish_pay"));
			}else {
				ALffish.add(MessageUtils.getString("menu_item_food_fish_pay_no"));
			}
		}
		IMffish.setLore(ALffish);
		ISffish.setItemMeta(IMffish);
		i.addItem(ISffish);
		
		ItemStack ISfgrass = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfgrass = ISfgrass.getItemMeta();
		ArrayList<String> ALfgrass = new ArrayList<>();
		ALfgrass.add(MessageUtils.getString("menu_item_food_grass_add"));
		ALfgrass.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_grass());
		ALfgrass.add(" ");
		if(mpd.getFood_grass() > 0) {
			ISfgrass = new ItemStack(Material.GRASS);
			if(mpd.getFood_grass() <= 64) {
				ISfgrass.setAmount(mpd.getFood_grass());
			}else {
				ISfgrass.setAmount(64);
			}
			IMfgrass = ISfgrass.getItemMeta();
			IMfgrass.setDisplayName(MessageUtils.getString("menu_item_food_grass"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfgrass.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfgrass.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfgrass.add(" ");
				ALfgrass.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfgrass.setDisplayName(MessageUtils.getString("menu_item_food_grass_no"));
			ALfgrass.add(MessageUtils.getString("menu_item_get"));
			ALfgrass.add(" ");
			if(mpd.getGold() >= 7) {
				ALfgrass.add(MessageUtils.getString("menu_item_food_grass_pay"));
			}else {
				ALfgrass.add(MessageUtils.getString("menu_item_food_grass_pay_no"));
			}
		}
		IMfgrass.setLore(ALfgrass);
		ISfgrass.setItemMeta(IMfgrass);
		i.addItem(ISfgrass);
		
		ItemStack ISfmushroomb = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfmushroomb = ISfmushroomb.getItemMeta();
		ArrayList<String> ALfmushroomb = new ArrayList<>();
		ALfmushroomb.add(MessageUtils.getString("menu_item_food_mushroom_b_add"));
		ALfmushroomb.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_mushroom_b());
		ALfmushroomb.add(" ");
		if(mpd.getFood_mushroom_b() > 0) {
			ISfmushroomb = new ItemStack(Material.BROWN_MUSHROOM);
			if(mpd.getFood_mushroom_b() <= 64) {
				ISfmushroomb.setAmount(mpd.getFood_mushroom_b());
			}else {
				ISfmushroomb.setAmount(64);
			}
			IMfmushroomb = ISfmushroomb.getItemMeta();
			IMfmushroomb.setDisplayName(MessageUtils.getString("menu_item_food_mushroom_b"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfmushroomb.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfmushroomb.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfmushroomb.add(" ");
				ALfmushroomb.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfmushroomb.setDisplayName(MessageUtils.getString("menu_item_food_mushroom_b_no"));
			ALfmushroomb.add(MessageUtils.getString("menu_item_get"));
			ALfmushroomb.add(" ");
			if(mpd.getGold() >= 8) {
				ALfmushroomb.add(MessageUtils.getString("menu_item_food_mushroom_b_pay"));
			}else {
				ALfmushroomb.add(MessageUtils.getString("menu_item_food_mushroom_b_pay_no"));
			}
		}
		IMfmushroomb.setLore(ALfmushroomb);
		ISfmushroomb.setItemMeta(IMfmushroomb);
		i.addItem(ISfmushroomb);
		
		ItemStack ISfmushroomr = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfmushroomr = ISfmushroomr.getItemMeta();
		ArrayList<String> ALfmushroomr = new ArrayList<>();
		ALfmushroomr.add(MessageUtils.getString("menu_item_food_mushroom_r_add"));
		ALfmushroomr.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_mushroom_r());
		ALfmushroomr.add(" ");
		if(mpd.getFood_mushroom_r() > 0) {
			ISfmushroomr = new ItemStack(Material.RED_MUSHROOM);
			if(mpd.getFood_mushroom_r() <= 64) {
				ISfmushroomr.setAmount(mpd.getFood_mushroom_r());
			}else {
				ISfmushroomr.setAmount(64);
			}
			IMfmushroomr = ISfmushroomr.getItemMeta();
			IMfmushroomr.setDisplayName(MessageUtils.getString("menu_item_food_mushroom_r"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfmushroomr.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfmushroomr.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfmushroomr.add(" ");
				ALfmushroomr.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfmushroomr.setDisplayName(MessageUtils.getString("menu_item_food_mushroom_r_no"));
			ALfmushroomr.add(MessageUtils.getString("menu_item_get"));
			ALfmushroomr.add(" ");
			if(mpd.getGold() >= 9) {
				ALfmushroomr.add(MessageUtils.getString("menu_item_food_mushroom_r_pay"));
			}else {
				ALfmushroomr.add(MessageUtils.getString("menu_item_food_mushroom_r_pay_no"));
			}
		}
		IMfmushroomr.setLore(ALfmushroomr);
		ISfmushroomr.setItemMeta(IMfmushroomr);
		i.addItem(ISfmushroomr);
		
		ItemStack ISfflower = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfflower = ISfflower.getItemMeta();
		ArrayList<String> ALfflower = new ArrayList<>();
		ALfflower.add(MessageUtils.getString("menu_item_food_flower_add"));
		ALfflower.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_flower());
		ALfflower.add(" ");
		if(mpd.getFood_flower() > 0) {
			ISfflower = new ItemStack(Material.YELLOW_FLOWER);
			if(mpd.getFood_flower() <= 64) {
				ISfflower.setAmount(mpd.getFood_flower());
			}else {
				ISfflower.setAmount(64);
			}
			IMfflower = ISfflower.getItemMeta();
			IMfflower.setDisplayName(MessageUtils.getString("menu_item_food_flower"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfflower.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfflower.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfflower.add(" ");
				ALfflower.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfflower.setDisplayName(MessageUtils.getString("menu_item_food_flower_no"));
			ALfflower.add(MessageUtils.getString("menu_item_get"));
			ALfflower.add(" ");
			if(mpd.getGold() >= 10) {
				ALfflower.add(MessageUtils.getString("menu_item_food_flower_pay"));
			}else {
				ALfflower.add(MessageUtils.getString("menu_item_food_flower_pay_no"));
			}
		}
		IMfflower.setLore(ALfflower);
		ISfflower.setItemMeta(IMfflower);
		i.addItem(ISfflower);
		
		ItemStack ISfwheat = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfwheat = ISfwheat.getItemMeta();
		ArrayList<String> ALfwheat = new ArrayList<>();
		ALfwheat.add(MessageUtils.getString("menu_item_food_wheat_add"));
		ALfwheat.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_wheat());
		ALfwheat.add(" ");
		if(mpd.getFood_wheat() > 0) {
			ISfwheat = new ItemStack(Material.WHEAT);
			if(mpd.getFood_wheat() <= 64) {
				ISfwheat.setAmount(mpd.getFood_wheat());
			}else {
				ISfwheat.setAmount(64);
			}
			IMfwheat = ISfwheat.getItemMeta();
			IMfwheat.setDisplayName(MessageUtils.getString("menu_item_food_wheat"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfwheat.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfwheat.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfwheat.add(" ");
				ALfwheat.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfwheat.setDisplayName(MessageUtils.getString("menu_item_food_wheat_no"));
			ALfwheat.add(MessageUtils.getString("menu_item_get"));
			ALfwheat.add(" ");
			if(mpd.getGold() >= 11) {
				ALfwheat.add(MessageUtils.getString("menu_item_food_wheat_pay"));
			}else {
				ALfwheat.add(MessageUtils.getString("menu_item_food_wheat_pay_no"));
			}
		}
		IMfwheat.setLore(ALfwheat);
		ISfwheat.setItemMeta(IMfwheat);
		i.addItem(ISfwheat);
		
		ItemStack ISfcake = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfcake = ISfcake.getItemMeta();
		ArrayList<String> ALfcake = new ArrayList<>();
		ALfcake.add(MessageUtils.getString("menu_item_food_cake_add"));
		ALfcake.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_cake());
		ALfcake.add(" ");
		if(mpd.getFood_cake() > 0) {
			ISfcake = new ItemStack(Material.CAKE);
			if(mpd.getFood_cake() <= 64) {
				ISfcake.setAmount(mpd.getFood_cake());
			}else {
				ISfcake.setAmount(64);
			}
			IMfcake = ISfcake.getItemMeta();
			IMfcake.setDisplayName(MessageUtils.getString("menu_item_food_cake"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfcake.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfcake.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfcake.add(" ");
				ALfcake.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfcake.setDisplayName(MessageUtils.getString("menu_item_food_cake_no"));
			ALfcake.add(MessageUtils.getString("menu_item_get"));
			ALfcake.add(" ");
			if(mpd.getGold() >= 12) {
				ALfcake.add(MessageUtils.getString("menu_item_food_cake_pay"));
			}else {
				ALfcake.add(MessageUtils.getString("menu_item_food_cake_pay_no"));
			}
		}
		IMfcake.setLore(ALfcake);
		ISfcake.setItemMeta(IMfcake);
		i.addItem(ISfcake);
		
		ItemStack ISfcookie = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfcookie = ISfcookie.getItemMeta();
		ArrayList<String> ALfcookie = new ArrayList<>();
		ALfcookie.add(MessageUtils.getString("menu_item_food_cookie_add"));
		ALfcookie.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_cookie());
		ALfcookie.add(" ");
		if(mpd.getFood_cookie() > 0) {
			ISfcookie = new ItemStack(Material.COOKIE);
			if(mpd.getFood_cookie() <= 64) {
				ISfcookie.setAmount(mpd.getFood_cookie());
			}else {
				ISfcookie.setAmount(64);
			}
			IMfcookie = ISfcookie.getItemMeta();
			IMfcookie.setDisplayName(MessageUtils.getString("menu_item_food_cookie"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfcookie.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfcookie.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfcookie.add(" ");
				ALfcookie.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfcookie.setDisplayName(MessageUtils.getString("menu_item_food_cookie_no"));
			ALfcookie.add(MessageUtils.getString("menu_item_get"));
			ALfcookie.add(" ");
			if(mpd.getGold() >= 13) {
				ALfcookie.add(MessageUtils.getString("menu_item_food_cookie_pay"));
			}else {
				ALfcookie.add(MessageUtils.getString("menu_item_food_cookie_pay_no"));
			}
		}
		IMfcookie.setLore(ALfcookie);
		ISfcookie.setItemMeta(IMfcookie);
		i.addItem(ISfcookie);
		
		ItemStack ISfpie = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfpie = ISfpie.getItemMeta();
		ArrayList<String> ALfpie = new ArrayList<>();
		ALfpie.add(MessageUtils.getString("menu_item_food_pie_add"));
		ALfpie.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_pie());
		ALfpie.add(" ");
		if(mpd.getFood_pie() > 0) {
			ISfpie = new ItemStack(Material.PUMPKIN_PIE);
			if(mpd.getFood_pie() <= 64) {
				ISfpie.setAmount(mpd.getFood_pie());
			}else {
				ISfpie.setAmount(64);
			}
			IMfpie = ISfpie.getItemMeta();
			IMfpie.setDisplayName(MessageUtils.getString("menu_item_food_pie"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfpie.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfpie.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfpie.add(" ");
				ALfpie.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfpie.setDisplayName(MessageUtils.getString("menu_item_food_pie_no"));
			ALfpie.add(MessageUtils.getString("menu_item_get"));
			ALfpie.add(" ");
			if(mpd.getGold() >= 14) {
				ALfpie.add(MessageUtils.getString("menu_item_food_pie_pay"));
			}else {
				ALfpie.add(MessageUtils.getString("menu_item_food_pie_pay_no"));
			}
		}
		IMfpie.setLore(ALfpie);
		ISfpie.setItemMeta(IMfpie);
		i.addItem(ISfpie);
		
		ItemStack ISfgolden = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMfgolden = ISfgolden.getItemMeta();
		ArrayList<String> ALfgolden = new ArrayList<>();
		ALfgolden.add(MessageUtils.getString("menu_item_food_golden_add"));
		ALfgolden.add(MessageUtils.getString("menu_item_food_posses")+mpd.getFood_golden());
		ALfgolden.add(" ");
		if(mpd.getFood_golden() > 0) {
			ISfgolden = new ItemStack(Material.GOLDEN_APPLE);
			if(mpd.getFood_golden() <= 64) {
				ISfgolden.setAmount(mpd.getFood_golden());
			}else {
				ISfgolden.setAmount(64);
			}
			IMfgolden = ISfgolden.getItemMeta();
			IMfgolden.setDisplayName(MessageUtils.getString("menu_item_food_golden"));
			if(PetsList.getPetHunger(mpd, pet) <= 99) {
				ALfgolden.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALfgolden.add(MessageUtils.getString("menu_item_food_nohunger"));
				ALfgolden.add(" ");
				ALfgolden.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMfgolden.setDisplayName(MessageUtils.getString("menu_item_food_golden_no"));
			ALfgolden.add(MessageUtils.getString("menu_item_get"));
			ALfgolden.add(" ");
			if(mpd.getGold() >= 15) {
				ALfgolden.add(MessageUtils.getString("menu_item_food_golden_pay"));
			}else {
				ALfgolden.add(MessageUtils.getString("menu_item_food_golden_pay_no"));
			}
		}
		IMfgolden.setLore(ALfgolden);
		ISfgolden.setItemMeta(IMfgolden);
		i.addItem(ISfgolden);
		
		ItemStack ISdwater = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMdwater = ISdwater.getItemMeta();
		ArrayList<String> ALdwater = new ArrayList<>();
		ALdwater.add(MessageUtils.getString("menu_item_drink_water_add"));
		ALdwater.add(MessageUtils.getString("menu_item_food_posses")+mpd.getDrink_water());
		ALdwater.add(" ");
		if(mpd.getDrink_water() > 0) {
			ISdwater = new ItemStack(Material.WATER_BUCKET);
			if(mpd.getDrink_water() <= 64) {
				ISdwater.setAmount(mpd.getDrink_water());
			}else {
				ISdwater.setAmount(64);
			}
			IMdwater = ISdwater.getItemMeta();
			IMdwater.setDisplayName(MessageUtils.getString("menu_item_drink_water"));
			if(PetsList.getPetThirst(mpd, pet) <= 99) {
				ALdwater.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALdwater.add(MessageUtils.getString("menu_item_drink_nothirst"));
				ALdwater.add(" ");
				ALdwater.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMdwater.setDisplayName(MessageUtils.getString("menu_item_drink_water_no"));
			ALdwater.add(MessageUtils.getString("menu_item_get"));
			ALdwater.add(" ");
			if(mpd.getGold() >= 3) {
				ALdwater.add(MessageUtils.getString("menu_item_drink_water_pay"));
			}else {
				ALdwater.add(MessageUtils.getString("menu_item_drink_water_pay_no"));
			}
		}
		IMdwater.setLore(ALdwater);
		ISdwater.setItemMeta(IMdwater);
		i.setItem(18, ISdwater);
		
		ItemStack ISdmilk = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMdmilk = ISdmilk.getItemMeta();
		ArrayList<String> ALdmilk = new ArrayList<>();
		ALdmilk.add(MessageUtils.getString("menu_item_drink_milk_add"));
		ALdmilk.add(MessageUtils.getString("menu_item_food_posses")+mpd.getDrink_milk());
		ALdmilk.add(" ");
		if(mpd.getDrink_milk() > 0) {
			ISdmilk = new ItemStack(Material.MILK_BUCKET);
			if(mpd.getDrink_milk() <= 64) {
				ISdmilk.setAmount(mpd.getDrink_milk());
			}else {
				ISdmilk.setAmount(64);
			}
			IMdmilk = ISdmilk.getItemMeta();
			IMdmilk.setDisplayName(MessageUtils.getString("menu_item_drink_milk"));
			if(PetsList.getPetThirst(mpd, pet) <= 99) {
				ALdmilk.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALdmilk.add(MessageUtils.getString("menu_item_drink_nothirst"));
				ALdmilk.add(" ");
				ALdmilk.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMdmilk.setDisplayName(MessageUtils.getString("menu_item_drink_milk_no"));
			ALdmilk.add(MessageUtils.getString("menu_item_get"));
			ALdmilk.add(" ");
			if(mpd.getGold() >= 6) {
				ALdmilk.add(MessageUtils.getString("menu_item_drink_milk_pay"));
			}else {
				ALdmilk.add(MessageUtils.getString("menu_item_drink_milk_pay_no"));
			}
		}
		IMdmilk.setLore(ALdmilk);
		ISdmilk.setItemMeta(IMdmilk);
		i.setItem(19, ISdmilk);
		
		ItemStack ISdlava = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMdlava = ISdlava.getItemMeta();
		ArrayList<String> ALdlava = new ArrayList<>();
		ALdlava.add(MessageUtils.getString("menu_item_drink_lava_add"));
		ALdlava.add(MessageUtils.getString("menu_item_food_posses")+mpd.getDrink_lava());
		ALdlava.add(" ");
		if(mpd.getDrink_lava() > 0) {
			ISdlava = new ItemStack(Material.LAVA_BUCKET);
			if(mpd.getDrink_lava() <= 64) {
				ISdlava.setAmount(mpd.getDrink_lava());
			}else {
				ISdlava.setAmount(64);
			}
			IMdlava = ISdlava.getItemMeta();
			IMdlava.setDisplayName(MessageUtils.getString("menu_item_drink_lava"));
			if(PetsList.getPetThirst(mpd, pet) <= 99) {
				ALdlava.add(MessageUtils.getString("menu_item_food_click_eat"));
			}else {
				ALdlava.add(MessageUtils.getString("menu_item_drink_nothirst"));
				ALdlava.add(" ");
				ALdlava.add(MessageUtils.getString("menu_item_food_click_eat_no"));
			}
		}else {
			IMdlava.setDisplayName(MessageUtils.getString("menu_item_drink_lava_no"));
			ALdlava.add(MessageUtils.getString("menu_item_get"));
			ALdlava.add(" ");
			if(mpd.getGold() >= 9) {
				ALdlava.add(MessageUtils.getString("menu_item_drink_lava_pay"));
			}else {
				ALdlava.add(MessageUtils.getString("menu_item_drink_lava_pay_no"));
			}
		}
		IMdlava.setLore(ALdlava);
		ISdlava.setItemMeta(IMdlava);
		i.setItem(20, ISdlava);
		
		ItemStack ISback = new ItemStack(Material.ARROW);
		ItemMeta IMback = ISback.getItemMeta();
		ArrayList<String> ALback = new ArrayList<>();
		IMback.setDisplayName(MessageUtils.getString("menu_item_back"));
		ALback.add(" ");
		ALback.add(MessageUtils.getString("menu_item_back_lore_1"));
		ALback.add(MessageUtils.getString("menu_item_back_lore_2"));
		IMback.setLore(ALback);
		ISback.setItemMeta(IMback);
		i.setItem(44, ISback);
		
		ItemStack ISgold = new ItemStack(Material.GOLD_INGOT);
		if(mpd.getGold() > 0) {
			if(mpd.getGold() > 64) {
				ISgold.setAmount(64);
			}else {
				ISgold.setAmount(mpd.getGold());
			}
		}else {
			ISgold.setAmount(1);
		}
		ItemMeta IMgold = ISgold.getItemMeta();
		IMgold.setDisplayName(MessageUtils.getString("menu_item_gold").replaceAll("#GOLD#", ""+mpd.getGold()));
		ISgold.setItemMeta(IMgold);
		i.setItem(40, ISgold);
		
		open.openInventory(i);
		
	}

}
