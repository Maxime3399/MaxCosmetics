package fr.Maxime3399.MaxCosmetics.custom;

import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.utils.MySQLUtils;

public class MaxPlayer {
	
	//Player informations
	private Player player;
	private int gold;
	private String lootboox;
	private String enable;
	
	//System
	private Player invData;
	private String rename_pet;
	private boolean mccmd;
	private String foodpet;
	
	//Food
	private int food_appple;
	private int food_bread;
	private int food_carrot;
	private int food_potato;
	private int food_melon;
	private int food_fish;
	private int food_grass;
	private int food_mushroom_b;
	private int food_mushroom_r;
	private int food_flower;
	private int food_wheat;
	private int food_cake;
	private int food_cookie;
	private int food_pie;
	private int food_golden;
	
	//Drink
	private int drink_water;
	private int drink_milk;
	private int drink_lava;
	
	//Toys
	private int toy_ball;
	private int toy_freesbie;
	private int toy_laser;
	private int toy_run;
	
	
	//Silverfish pet
	private boolean pet_silverfish;
	private String pet_silverfish_name;
	private int pet_silverfish_level;
	private int pet_silverfish_exp;
	private int pet_silverfish_hunger;
	private int pet_silverfish_thirst;
	private int pet_silverfish_exercise;
	
	//Catblack pet
	private boolean pet_catblack;
	private String pet_catblack_name;
	private int pet_catblack_level;
	private int pet_catblack_exp;
	private int pet_catblack_hunger;
	private int pet_catblack_thirst;
	private int pet_catblack_exercise;
	
	//Catblackbaby pet
	private boolean pet_catblackbaby;
	private String pet_catblackbaby_name;
	private int pet_catblackbaby_level;
	private int pet_catblackbaby_exp;
	private int pet_catblackbaby_hunger;
	private int pet_catblackbaby_thirst;
	private int pet_catblackbaby_exercise;

	public MaxPlayer(Player p) {
		
		//Player informations
		this.setPlayer(p);
		this.setGold(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "gold"));
		this.setLootboox(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "lootbox"));
		this.setEnable(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "enable"));
		
		//System
		this.setInvData(p);
		this.setRename_pet(null);
		this.setMccmd(false);
		
		//Food
		this.setFood_appple(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_apple"));
		this.setFood_bread(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_bread"));
		this.setFood_carrot(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_carrot"));
		this.setFood_potato(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_potato"));
		this.setFood_melon(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_melon"));
		this.setFood_fish(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_fish"));
		this.setFood_grass(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_grass"));
		this.setFood_mushroom_b(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_mushroom_b"));
		this.setFood_mushroom_r(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_mushroom_r"));
		this.setFood_flower(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_flower"));
		this.setFood_wheat(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_wheat"));
		this.setFood_cake(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_cake"));
		this.setFood_cookie(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_cookie"));
		this.setFood_pie(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_pie"));
		this.setFood_golden(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "food_golden"));
		
		//Drink
		this.setDrink_water(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "drink_water"));
		this.setDrink_milk(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "drink_milk"));
		this.setDrink_lava(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "drink_lava"));
		
		//Toys
		this.setToy_ball(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "toy_ball"));
		this.setToy_freesbie(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "toy_freesbie"));
		this.setToy_laser(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "toy_laser"));
		this.setToy_run(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "toy_run"));
		
		//Silverfish pet
		this.setPet_silverfish(Boolean.valueOf(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish")));
		this.setPet_silverfish_name(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_name"));
		this.setPet_silverfish_level(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_level"));
		this.setPet_silverfish_exp(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_exp"));
		this.setPet_silverfish_hunger(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_hunger"));
		this.setPet_silverfish_thirst(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_thirst"));
		this.setPet_silverfish_exercise(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_silverfish_exercise"));
		
		//Catblack pet
		this.setPet_catblack(Boolean.valueOf(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack")));
		this.setPet_catblack_name(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_name"));
		this.setPet_catblack_level(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_level"));
		this.setPet_catblack_exp(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_exp"));
		this.setPet_catblack_hunger(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_hunger"));
		this.setPet_catblack_thirst(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_thirst"));
		this.setPet_catblack_exercise(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblack_exercise"));
		
		//Catblackbaby pet
		this.setPet_catblackbaby(Boolean.valueOf(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby")));
		this.setPet_catblackbaby_name(MySQLUtils.getString("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_name"));
		this.setPet_catblackbaby_level(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_level"));
		this.setPet_catblackbaby_exp(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_exp"));
		this.setPet_catblackbaby_hunger(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_hunger"));
		this.setPet_catblackbaby_thirst(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_thirst"));
		this.setPet_catblackbaby_exercise(MySQLUtils.getInt("maxcosmetics_players", "uuid", p.getUniqueId().toString(), "pet_catblackbaby_exercise"));
		
	}
	
	public void synchronize() {
		
		//Player informations
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "gold", gold);
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "lootbox", lootboox);
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "enable", enable);
		
		//Food
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_apple", food_appple);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_bread", food_bread);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_cake", food_cake);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_carrot", food_carrot);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_cookie", food_cookie);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_fish", food_fish);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_flower", food_flower);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_golden", food_golden);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_grass", food_grass);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_melon", food_melon);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_mushroom_b", food_mushroom_b);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_mushroom_r", food_mushroom_r);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_pie", food_pie);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_potato", food_potato);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "food_wheat", food_wheat);
		
		//Drink
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "drink_water", drink_water);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "drink_milk", drink_milk);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "drink_lava", drink_lava);
		
		//Toys
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "toy_ball", toy_ball);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "toy_freesbie", toy_freesbie);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "toy_laser", toy_laser);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "toy_run", toy_run);
		
		//Silverfish pet
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish", String.valueOf(pet_silverfish));
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_name", pet_silverfish_name);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_level", pet_silverfish_level);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_exp", pet_silverfish_exp);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_hunger", pet_silverfish_hunger);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_thirst", pet_silverfish_thirst);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_silverfish_exercise", pet_silverfish_exercise);
		
		//Catblack pet
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack", String.valueOf(pet_catblack));
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_name", pet_catblack_name);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_level", pet_catblack_level);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_exp", pet_catblack_exp);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_hunger", pet_catblack_hunger);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_thirst", pet_catblack_thirst);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblack_exercise", pet_catblack_exercise);
		
		//Catblackbaby pet
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby", String.valueOf(pet_catblackbaby));
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_name", pet_catblackbaby_name);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_level", pet_catblackbaby_level);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_exp", pet_catblackbaby_exp);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_hunger", pet_catblackbaby_hunger);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_thirst", pet_catblackbaby_thirst);
		MySQLUtils.setInt("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "pet_catblackbaby_exercise", pet_catblackbaby_exercise);
		
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getLootboox() {
		return lootboox;
	}

	public void setLootboox(String lootboox) {
		this.lootboox = lootboox;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Player getInvData() {
		return invData;
	}

	public void setInvData(Player invData) {
		this.invData = invData;
	}

	public String getRename_pet() {
		return rename_pet;
	}

	public void setRename_pet(String rename_pet) {
		this.rename_pet = rename_pet;
	}

	public boolean isMccmd() {
		return mccmd;
	}

	public void setMccmd(boolean mccmd) {
		this.mccmd = mccmd;
	}

	public String getFoodpet() {
		return foodpet;
	}

	public void setFoodpet(String foodpet) {
		this.foodpet = foodpet;
	}

	public int getFood_appple() {
		return food_appple;
	}

	public void setFood_appple(int food_appple) {
		this.food_appple = food_appple;
	}

	public int getFood_bread() {
		return food_bread;
	}

	public void setFood_bread(int food_bread) {
		this.food_bread = food_bread;
	}

	public int getFood_carrot() {
		return food_carrot;
	}

	public void setFood_carrot(int food_carrot) {
		this.food_carrot = food_carrot;
	}

	public int getFood_potato() {
		return food_potato;
	}

	public void setFood_potato(int food_potato) {
		this.food_potato = food_potato;
	}

	public int getFood_melon() {
		return food_melon;
	}

	public void setFood_melon(int food_melon) {
		this.food_melon = food_melon;
	}

	public int getFood_fish() {
		return food_fish;
	}

	public void setFood_fish(int food_fish) {
		this.food_fish = food_fish;
	}

	public int getFood_grass() {
		return food_grass;
	}

	public void setFood_grass(int food_grass) {
		this.food_grass = food_grass;
	}

	public int getFood_mushroom_b() {
		return food_mushroom_b;
	}

	public void setFood_mushroom_b(int food_mushroom_b) {
		this.food_mushroom_b = food_mushroom_b;
	}

	public int getFood_mushroom_r() {
		return food_mushroom_r;
	}

	public void setFood_mushroom_r(int food_mushroom_r) {
		this.food_mushroom_r = food_mushroom_r;
	}

	public int getFood_flower() {
		return food_flower;
	}

	public void setFood_flower(int food_flower) {
		this.food_flower = food_flower;
	}

	public int getFood_wheat() {
		return food_wheat;
	}

	public void setFood_wheat(int food_wheat) {
		this.food_wheat = food_wheat;
	}

	public int getFood_cake() {
		return food_cake;
	}

	public void setFood_cake(int food_cake) {
		this.food_cake = food_cake;
	}

	public int getFood_cookie() {
		return food_cookie;
	}

	public void setFood_cookie(int food_cookie) {
		this.food_cookie = food_cookie;
	}

	public int getFood_pie() {
		return food_pie;
	}

	public void setFood_pie(int food_pie) {
		this.food_pie = food_pie;
	}

	public int getFood_golden() {
		return food_golden;
	}

	public void setFood_golden(int food_golden) {
		this.food_golden = food_golden;
	}

	public int getDrink_water() {
		return drink_water;
	}

	public void setDrink_water(int drink_water) {
		this.drink_water = drink_water;
	}

	public int getDrink_milk() {
		return drink_milk;
	}

	public void setDrink_milk(int drink_milk) {
		this.drink_milk = drink_milk;
	}

	public int getDrink_lava() {
		return drink_lava;
	}

	public void setDrink_lava(int drink_lava) {
		this.drink_lava = drink_lava;
	}

	public int getToy_ball() {
		return toy_ball;
	}

	public void setToy_ball(int toy_ball) {
		this.toy_ball = toy_ball;
	}

	public int getToy_freesbie() {
		return toy_freesbie;
	}

	public void setToy_freesbie(int toy_freesbie) {
		this.toy_freesbie = toy_freesbie;
	}

	public int getToy_laser() {
		return toy_laser;
	}

	public void setToy_laser(int toy_laser) {
		this.toy_laser = toy_laser;
	}

	public int getToy_run() {
		return toy_run;
	}

	public void setToy_run(int toy_run) {
		this.toy_run = toy_run;
	}

	public boolean isPet_silverfish() {
		return pet_silverfish;
	}

	public void setPet_silverfish(boolean pet_silverfish) {
		this.pet_silverfish = pet_silverfish;
	}

	public String getPet_silverfish_name() {
		return pet_silverfish_name;
	}

	public void setPet_silverfish_name(String pet_silverfish_name) {
		this.pet_silverfish_name = pet_silverfish_name;
	}

	public int getPet_silverfish_level() {
		return pet_silverfish_level;
	}

	public void setPet_silverfish_level(int pet_silverfish_level) {
		this.pet_silverfish_level = pet_silverfish_level;
	}

	public int getPet_silverfish_exp() {
		return pet_silverfish_exp;
	}

	public void setPet_silverfish_exp(int pet_silverfish_exp) {
		this.pet_silverfish_exp = pet_silverfish_exp;
	}

	public int getPet_silverfish_hunger() {
		return pet_silverfish_hunger;
	}

	public void setPet_silverfish_hunger(int pet_silverfish_hunger) {
		this.pet_silverfish_hunger = pet_silverfish_hunger;
	}

	public int getPet_silverfish_thirst() {
		return pet_silverfish_thirst;
	}

	public void setPet_silverfish_thirst(int pet_silverfish_thirst) {
		this.pet_silverfish_thirst = pet_silverfish_thirst;
	}

	public int getPet_silverfish_exercise() {
		return pet_silverfish_exercise;
	}

	public void setPet_silverfish_exercise(int pet_silverfish_exercise) {
		this.pet_silverfish_exercise = pet_silverfish_exercise;
	}

	public boolean isPet_catblack() {
		return pet_catblack;
	}

	public void setPet_catblack(boolean pet_catblack) {
		this.pet_catblack = pet_catblack;
	}

	public String getPet_catblack_name() {
		return pet_catblack_name;
	}

	public void setPet_catblack_name(String pet_catblack_name) {
		this.pet_catblack_name = pet_catblack_name;
	}

	public int getPet_catblack_level() {
		return pet_catblack_level;
	}

	public void setPet_catblack_level(int pet_catblack_level) {
		this.pet_catblack_level = pet_catblack_level;
	}

	public int getPet_catblack_exp() {
		return pet_catblack_exp;
	}

	public void setPet_catblack_exp(int pet_catblack_exp) {
		this.pet_catblack_exp = pet_catblack_exp;
	}

	public int getPet_catblack_hunger() {
		return pet_catblack_hunger;
	}

	public void setPet_catblack_hunger(int pet_catblack_hunger) {
		this.pet_catblack_hunger = pet_catblack_hunger;
	}

	public int getPet_catblack_thirst() {
		return pet_catblack_thirst;
	}

	public void setPet_catblack_thirst(int pet_catblack_thirst) {
		this.pet_catblack_thirst = pet_catblack_thirst;
	}

	public int getPet_catblack_exercise() {
		return pet_catblack_exercise;
	}

	public void setPet_catblack_exercise(int pet_catblack_exercise) {
		this.pet_catblack_exercise = pet_catblack_exercise;
	}

	public boolean isPet_catblackbaby() {
		return pet_catblackbaby;
	}

	public void setPet_catblackbaby(boolean pet_catblackbaby) {
		this.pet_catblackbaby = pet_catblackbaby;
	}

	public String getPet_catblackbaby_name() {
		return pet_catblackbaby_name;
	}

	public void setPet_catblackbaby_name(String pet_catblackbaby_name) {
		this.pet_catblackbaby_name = pet_catblackbaby_name;
	}

	public int getPet_catblackbaby_level() {
		return pet_catblackbaby_level;
	}

	public void setPet_catblackbaby_level(int pet_catblackbaby_level) {
		this.pet_catblackbaby_level = pet_catblackbaby_level;
	}

	public int getPet_catblackbaby_exp() {
		return pet_catblackbaby_exp;
	}

	public void setPet_catblackbaby_exp(int pet_catblackbaby_exp) {
		this.pet_catblackbaby_exp = pet_catblackbaby_exp;
	}

	public int getPet_catblackbaby_hunger() {
		return pet_catblackbaby_hunger;
	}

	public void setPet_catblackbaby_hunger(int pet_catblackbaby_hunger) {
		this.pet_catblackbaby_hunger = pet_catblackbaby_hunger;
	}

	public int getPet_catblackbaby_thirst() {
		return pet_catblackbaby_thirst;
	}

	public void setPet_catblackbaby_thirst(int pet_catblackbaby_thirst) {
		this.pet_catblackbaby_thirst = pet_catblackbaby_thirst;
	}

	public int getPet_catblackbaby_exercise() {
		return pet_catblackbaby_exercise;
	}

	public void setPet_catblackbaby_exercise(int pet_catblackbaby_exercise) {
		this.pet_catblackbaby_exercise = pet_catblackbaby_exercise;
	}

}
