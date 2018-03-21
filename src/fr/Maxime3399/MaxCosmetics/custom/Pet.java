package fr.Maxime3399.MaxCosmetics.custom;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Maxime3399.MaxCosmetics.MainClass;
import fr.Maxime3399.MaxCosmetics.list.PetsList;

public class Pet {
	
	private int id;
	private Entity entity;
	private String name;
	private Player player;
	private int level;
	
	private boolean stop;
	
	public Pet(Entity e, String name, Player p, int lvl) {
		
		this.setId(e.getEntityId());
		this.setEntity(e);
		this.setName(name);
		this.setPlayer(p);
		this.setLevel(lvl);
		this.setStop(false);
		
		e.setCustomName(PetsList.getLevelColor(lvl)+lvl+"§r "+name.replaceAll("&", "§"));
		
		configureEntity();
		
		new BukkitRunnable() {
			@Override
			public void run() {
				for(Entity ens : entity.getWorld().getEntities()) {
					if(ens.getEntityId() == id) {
						setEntity(ens);
						ens.setCustomNameVisible(true);
					}
				}
				if(isStop()) {
					this.cancel();
				}
			}
		}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void configureEntity() {
		
		if(entity.getType().equals(EntityType.SILVERFISH)) {
			Silverfish a = (Silverfish) entity;
			a.setRemoveWhenFarAway(false);
			new BukkitRunnable() {
				@Override
				public void run() {
					a.setRemainingAir(999);
					a.setTarget(null);
					if(isStop()) {
						this.cancel();
					}
				}
			}.runTaskTimerAsynchronously(MainClass.getInstance(), 1, 1);
		}
		
	}
	
	

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		entity.setCustomName(PetsList.getLevelColor(level)+level+"§r "+name.replaceAll("&", "§"));
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		entity.setCustomName(PetsList.getLevelColor(level)+level+"§r "+name.replaceAll("&", "§"));
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
