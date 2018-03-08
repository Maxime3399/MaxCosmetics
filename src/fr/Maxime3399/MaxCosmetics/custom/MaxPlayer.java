package fr.Maxime3399.MaxCosmetics.custom;

import org.bukkit.entity.Player;

import fr.Maxime3399.MaxCosmetics.utils.MySQLUtils;

public class MaxPlayer {
	
	//Player informations
	private Player player;
	private int gold;
	private String lootboox;
	private String enable;
	
	//Inventory
	private Player invData;
	
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
		
		//Inventory
		this.setInvData(p);
		
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
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "lootbox", String.valueOf(lootboox));
		MySQLUtils.setString("maxcosmetics_players", "uuid", player.getUniqueId().toString(), "enable", String.valueOf(enable));
		
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
