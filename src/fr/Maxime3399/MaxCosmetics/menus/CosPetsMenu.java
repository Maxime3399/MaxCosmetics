package fr.Maxime3399.MaxCosmetics.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class CosPetsMenu {
	
	@SuppressWarnings("deprecation")
	public static void openMenu(Player open, Player data) {
		
		Inventory i = Bukkit.createInventory(null, 9, MessageUtils.getString("menu_name_cos_pets"));
		MaxPlayer mp = PlayersManager.getMaxPlayer(open);
		mp.setInvData(data);
		MaxPlayer mpd = PlayersManager.getMaxPlayer(data);
		
		ItemStack ISsilverish = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta IMsilverfish = ISsilverish.getItemMeta();
		ArrayList<String> ALsilverfish = new ArrayList<>();
		if(mpd.isPet_silverfish()) {
			ISsilverish = VersionsManager.getVClass().generateSpawnEgg(EntityType.SILVERFISH.getTypeId());
			IMsilverfish = ISsilverish.getItemMeta();
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_name")+mpd.getPet_silverfish_name().replaceAll("&", "§"));
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_level")+PetsList.getLevelColor(mpd.getPet_silverfish_level())+mpd.getPet_silverfish_level());
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_exp")+mpd.getPet_silverfish_exp()+"§8/§b"+PetsList.requiredExp(mpd.getPet_silverfish_level()));
			ALsilverfish.add(" ");
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_hunger")+PetsList.statusColor(mpd.getPet_silverfish_hunger())+mpd.getPet_silverfish_hunger()+"§8/§r100");
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_thirst")+PetsList.statusColor(mpd.getPet_silverfish_thirst())+mpd.getPet_silverfish_thirst()+"§8/§r100");
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_exercise")+PetsList.statusColor(mpd.getPet_silverfish_exercise())+mpd.getPet_silverfish_exercise()+"§8/§r100");
			ALsilverfish.add(" ");
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_left"));
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_right"));
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_middle"));
			if(mpd.getEnable().contains("pet_silverfish")) {
				IMsilverfish.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				IMsilverfish.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			}
		}else {
			ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_found"));
			ALsilverfish.add(" ");
			if(mpd.getGold() >= 10) {
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_silverfish_pay"));
			}else {
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_silverfish_pay_no"));
			}
		}
		IMsilverfish.setLore(ALsilverfish);
		IMsilverfish.setDisplayName(MessageUtils.getString("menu_item_cos_pets_silverfish"));
		ISsilverish.setItemMeta(IMsilverfish);
		i.setItem(0, ISsilverish);
		
		open.openInventory(i);
		
	}

}
