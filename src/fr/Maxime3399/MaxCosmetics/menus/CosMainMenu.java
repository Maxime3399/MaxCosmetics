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

public class CosMainMenu {
	
	public static void openMenu(Player open, Player data) {
		
		Inventory i = Bukkit.createInventory(null, 9, MessageUtils.getString("menu_name_cos_main"));
		MaxPlayer mp = PlayersManager.getMaxPlayer(open);
		mp.setInvData(data);
		
		ItemStack ISpets = new ItemStack(Material.BONE);
		ItemMeta IMpets = ISpets.getItemMeta();
		ArrayList<String> ALpets = new ArrayList<>();
		IMpets.setDisplayName(MessageUtils.getString("menu_item_cos_main_pets"));
		if(PetsList.getCount(data) >= PetsList.getMax()) {
			ALpets.add(MessageUtils.getString("menu_item_cos_main_pets_unlocked")+"§a§l"+PetsList.getCount(data)+"/"+PetsList.getMax());
		}else {
			ALpets.add(MessageUtils.getString("menu_item_cos_main_pets_unlocked")+PetsList.getCount(data)+"/"+PetsList.getMax());
		}
		IMpets.setLore(ALpets);
		ISpets.setItemMeta(IMpets);
		i.addItem(ISpets);
		
		open.openInventory(i);
		
	}

}
