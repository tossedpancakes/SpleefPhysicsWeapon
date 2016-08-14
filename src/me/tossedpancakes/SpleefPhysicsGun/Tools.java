package me.tossedpancakes.SpleefPhysicsGun;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Tools {
	public static List<Entity> getMobsAroundPoint(Location location, double radius) {
		List<Entity> entities = getEntitiesAroundPoint(location, radius, 0);
		for (int i = 0 ; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if ( !(e instanceof Player || e instanceof LivingEntity)) {
				entities.remove(e);
				i--;
			}
		}
		return entities;
	}
	public static List<Entity> getPlayersAroundPoint(Location location, double radius) {
		List<Entity> entities = getEntitiesAroundPoint(location, radius, 0);
		Entity e;
		for (int i = 0 ; i < entities.size(); i++) {
			e = entities.get(i);
			if ( !(e instanceof Player)) {
				entities.remove(e);
				i--;
			}
		}
		return entities;
	}
	public static List<Entity> getEntitiesAroundPoint(Location location, double radius) {
		return getEntitiesAroundPoint(location, radius, 0);
	}
	public static List<Entity> getEntitiesAroundPoint(Location location,
			double radius, double minRadius) {
		List<Entity> entities = location.getWorld().getEntities();
		List<Entity> list = location.getWorld().getEntities();
		for (Entity entity : entities) {
			if (entity.getWorld() != location.getWorld()) {
				list.remove(entity);
			} else if (entity.getLocation().distance(location) > radius || 
					   entity.getLocation().distance(location) < minRadius) {
				list.remove(entity);
			}
		}
		return list;
	}
	public static List<Entity> getEntitiesAroundFromList(Location location,
			double radius, List<Entity> entities) {
		List<Entity> list = new ArrayList<Entity>();
		list.addAll(entities);
		for (Entity entity : entities) {
			if (entity.getWorld() != location.getWorld())
				list.remove(entity);
			else if (entity.getLocation().distance(location) > radius)
				list.remove(entity);
		}
		return list;
	}
	// for getting a vector pointing toward another location
	public static Vector getDirection(Location location, Location destination) {
		double x1, y1, z1;
		double x0, y0, z0;
		x1 = destination.getX();
		y1 = destination.getY();
		z1 = destination.getZ();
		x0 = location.getX();
		y0 = location.getY();
		z0 = location.getZ();
		return new Vector(x1 - x0, y1 - y0, z1 - z0);
	}
}
