package fr.Maxime3399.MaxCosmetics.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.custom.MaxPlayer;
import fr.Maxime3399.MaxCosmetics.list.PetsList;
import fr.Maxime3399.MaxCosmetics.managers.PlayersManager;
import fr.Maxime3399.MaxCosmetics.menus.ConfirmMenu;
import fr.Maxime3399.MaxCosmetics.menus.FoodMenu;
import fr.Maxime3399.MaxCosmetics.utils.MessageUtils;

public class FoodMenuEvents implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getAction() == null) {
			
			return;
			
		}else if(e.getInventory().getName().equalsIgnoreCase(MessageUtils.getString("menu_name_food"))) {
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
				
				return;
				
			}else {
				
				String item = e.getCurrentItem().getItemMeta().getDisplayName();
				Player p = (Player) e.getWhoClicked();
				MaxPlayer mp = PlayersManager.getMaxPlayer(p);
				MaxPlayer mpd = PlayersManager.getMaxPlayer(mp.getInvData());
				
				if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_apple"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_appple(mpd.getFood_appple()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+5);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_apple_no"))) {
					if(mpd.getGold() >= 1) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-1);
											mpd.setFood_appple(mpd.getFood_appple()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_bread"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_bread(mpd.getFood_bread()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+10);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_bread_no"))) {
					if(mpd.getGold() >= 2) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-2);
											mpd.setFood_bread(mpd.getFood_bread()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_carrot"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_carrot(mpd.getFood_carrot()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+15);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_carrot_no"))) {
					if(mpd.getGold() >= 3) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-3);
											mpd.setFood_carrot(mpd.getFood_carrot()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_potato"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_potato(mpd.getFood_potato()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+20);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_potato_no"))) {
					if(mpd.getGold() >= 4) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-4);
											mpd.setFood_potato(mpd.getFood_potato()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_melon"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_melon(mpd.getFood_melon()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+25);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_melon_no"))) {
					if(mpd.getGold() >= 5) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-5);
											mpd.setFood_melon(mpd.getFood_melon()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_fish"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_fish(mpd.getFood_fish()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+30);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_fish_no"))) {
					if(mpd.getGold() >= 6) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-6);
											mpd.setFood_fish(mpd.getFood_fish()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_grass"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_grass(mpd.getFood_grass()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+35);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_grass_no"))) {
					if(mpd.getGold() >= 7) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-7);
											mpd.setFood_grass(mpd.getFood_grass()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_mushroom_b"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_mushroom_b(mpd.getFood_mushroom_b()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+40);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_mushroom_b_no"))) {
					if(mpd.getGold() >= 8) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-8);
											mpd.setFood_mushroom_b(mpd.getFood_mushroom_b()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_mushroom_r"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_mushroom_r(mpd.getFood_mushroom_r()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+45);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_mushroom_r_no"))) {
					if(mpd.getGold() >= 9) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-9);
											mpd.setFood_mushroom_r(mpd.getFood_mushroom_r()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_flower"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_flower(mpd.getFood_flower()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+50);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_flower_no"))) {
					if(mpd.getGold() >= 10) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-10);
											mpd.setFood_flower(mpd.getFood_flower()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_wheat"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_wheat(mpd.getFood_wheat()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+55);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_wheat_no"))) {
					if(mpd.getGold() >= 11) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-11);
											mpd.setFood_wheat(mpd.getFood_wheat()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_cake"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_cake(mpd.getFood_cake()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+60);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_cake_no"))) {
					if(mpd.getGold() >= 12) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-12);
											mpd.setFood_cake(mpd.getFood_cake()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_cookie"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_cookie(mpd.getFood_cookie()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+65);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_cookie_no"))) {
					if(mpd.getGold() >= 13) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-13);
											mpd.setFood_cookie(mpd.getFood_cookie()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_pie"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_pie(mpd.getFood_pie()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+70);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_pie_no"))) {
					if(mpd.getGold() >= 14) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-14);
											mpd.setFood_pie(mpd.getFood_pie()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_golden"))) {
					if(PetsList.getPetHunger(mpd, mp.getFoodpet()) <= 99) {
						mpd.setFood_golden(mpd.getFood_golden()-1);
						PetsList.setPetHunger(mpd, mp.getFoodpet(), PetsList.getPetHunger(mpd, mp.getFoodpet())+75);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_hunger_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_food_golden_no"))) {
					if(mpd.getGold() >= 15) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-15);
											mpd.setFood_golden(mpd.getFood_golden()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_water"))) {
					if(PetsList.getPetThirst(mpd, mp.getFoodpet()) <= 99) {
						mpd.setDrink_water(mpd.getDrink_water()-1);
						PetsList.setPetThirst(mpd, mp.getFoodpet(), PetsList.getPetThirst(mpd, mp.getFoodpet())+20);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_thirst_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_water_no"))) {
					if(mpd.getGold() >= 3) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-3);
											mpd.setDrink_water(mpd.getDrink_water()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_milk"))) {
					if(PetsList.getPetThirst(mpd, mp.getFoodpet()) <= 99) {
						mpd.setDrink_milk(mpd.getDrink_milk()-1);
						PetsList.setPetThirst(mpd, mp.getFoodpet(), PetsList.getPetThirst(mpd, mp.getFoodpet())+40);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_thirst_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_milk_no"))) {
					if(mpd.getGold() >= 6) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-6);
											mpd.setDrink_milk(mpd.getDrink_milk()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_lava"))) {
					if(PetsList.getPetThirst(mpd, mp.getFoodpet()) <= 99) {
						mpd.setDrink_lava(mpd.getDrink_lava()-1);
						PetsList.setPetThirst(mpd, mp.getFoodpet(), PetsList.getPetThirst(mpd, mp.getFoodpet())+60);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 1);
						FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
					}else {
						p.sendMessage(MessageUtils.getString("player_thirst_max"));
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
				}else if(item.equalsIgnoreCase(MessageUtils.getString("menu_item_drink_lava_no"))) {
					if(mpd.getGold() >= 9) {
						ConfirmMenu.confirm(p);
						new BukkitRunnable() {
							@Override
							public void run() {
								if(ConfirmMenu.getPlayer(p) == 1) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											mpd.setGold(mpd.getGold()-9);
											mpd.setDrink_lava(mpd.getDrink_lava()+1);
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_success"));
											p.playSound(p.getLocation(), Sound.NOTE_PLING, 100, 2);
										}
									}, 1);
								}else if(ConfirmMenu.getPlayer(p) == 2) {
									ConfirmMenu.removePlayer(p);
									this.cancel();
									Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										@Override
										public void run() {
											FoodMenu.openMenu(p, mp.getInvData(), mp.getFoodpet());
											p.sendMessage(MessageUtils.getString("player_pay_cancell"));
											p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 100, 1);
										}
									}, 1);
								}
							}
						}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
					}else {
						if(mp == mpd) {
							p.sendMessage(MessageUtils.getString("player_you_pay_no"));
						}else {
							p.sendMessage(MessageUtils.getString("player_other_pay_no"));
						}
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 100, 1);
					}
					//======================
				}
				
			}
			
			e.setCancelled(true);
			
		}
		
	}
	
}
