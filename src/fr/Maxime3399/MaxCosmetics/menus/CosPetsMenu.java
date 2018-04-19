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
import fr.Maxime3399.MaxCosmetics.managers.PetsManager;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.managers.VersionsManager;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;
import fr.Maxime3399.MaxCosmetics.utils.StringUtils;

public class CosPetsMenu {
	
	@SuppressWarnings("deprecation")
	public static void openMenu(Player open, Player data) {
		
		Inventory i = Bukkit.createInventory(null, 9, MessageUtils.getString("menu_name_cos_pets"));
		MaxPlayer mp = PlayersManager.getMaxPlayer(open);
		mp.setInvData(data);
		MaxPlayer mpd = PlayersManager.getMaxPlayer(data);
		
		ArrayList<ItemStack> items = new ArrayList<>();
		
		if(PetsList.getConfigEnable("pet_silverfish")) {
			ItemStack ISsilverfish = new ItemStack(Material.INK_SACK, 1, (short) 8);
			ItemMeta IMsilverfish = ISsilverfish.getItemMeta();
			ArrayList<String> ALsilverfish = new ArrayList<>();
			if(mpd.isPet_silverfish()) {
				ISsilverfish = VersionsManager.getVClass().generateSpawnEgg(EntityType.SILVERFISH.getTypeId());
				IMsilverfish = ISsilverfish.getItemMeta();
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_name")+mpd.getPet_silverfish_name().replaceAll("&", "§"));
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_level")+PetsList.getLevelColor(mpd.getPet_silverfish_level())+mpd.getPet_silverfish_level());
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_exp")+mpd.getPet_silverfish_exp()+"§8/§b"+PetsList.requiredExp(mpd.getPet_silverfish_level()));
				ALsilverfish.add(" ");
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_hunger")+PetsList.statusColor(mpd.getPet_silverfish_hunger())+mpd.getPet_silverfish_hunger()+"§8/§r100");
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_thirst")+PetsList.statusColor(mpd.getPet_silverfish_thirst())+mpd.getPet_silverfish_thirst()+"§8/§r100");
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_exercise")+PetsList.statusColor(mpd.getPet_silverfish_exercise())+mpd.getPet_silverfish_exercise()+"§8/§r100");
				ALsilverfish.add(" ");
				if(mpd.getPet_silverfish_hunger() < 5 || mpd.getPet_silverfish_thirst() < 5 || mpd.getPet_silverfish_exercise() >= 95) {
					ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_bar_1"));
					ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_bar_2"));
					ALsilverfish.add(" ");
					ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_left_no"));
				}else {
					if(PetsManager.havePet(mp.getInvData())) {
						ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_left_dispawn"));
					}else {
						ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_left_spawn"));
					}
				}
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_right"));
				ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_middle"));
				if(PetsManager.havePet(mp.getInvData())) {
					IMsilverfish.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					IMsilverfish.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				}
			}else {
				if(PetsList.getConfigPermission("pet_silverfish").equalsIgnoreCase("#####")) {
					ALsilverfish.add(MessageUtils.getString("menu_item_found").replaceAll("#BOX#", MessageUtils.getString("box_"+PetsList.getConfigType("pet_silverfish"))));
					ALsilverfish.add(" ");
					if(mpd.getGold() >= PetsList.getConfigCost("pet_silverfish")) {
						ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_silverfish_pay").replaceAll("#COST#", PetsList.getConfigCost("pet_silverfish")+""));
					}else {
						ALsilverfish.add(MessageUtils.getString("menu_item_cos_pets_silverfish_pay_no").replaceAll("#COST#", PetsList.getConfigCost("pet_silverfish")+""));
					}
				}else {
					ALsilverfish.add(PetsList.getConfigLore("pet_silverfish"));
				}
			}
			IMsilverfish.setLore(ALsilverfish);
			IMsilverfish.setDisplayName(StringUtils.getRarityColor(PetsList.getConfigRarity("pet_silverfish"))+MessageUtils.getString("menu_item_cos_pets_silverfish"));
			ISsilverfish.setItemMeta(IMsilverfish);
			items.add(ISsilverfish);
		}
		
		for(ItemStack its : items) {
			i.addItem(its);
		}
		
		open.openInventory(i);
		
	}

}
