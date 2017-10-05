package net.ffa.playerstats.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtil {
	
	public static String locationToString(Location location) {
		
		String toReturn =
			location.getWorld().getName() +"-"+
			location.getBlockX()+"-"+
			location.getBlockY()+"-"+
			location.getBlockZ()+"-"+
			location.getYaw()+"-"+
			location.getPitch();
		return toReturn;
		
		
	}
	
	public static Location locationFromString(String s) {
		String[] arr = s.split("-");
		String world = arr[0];
		int x = Integer.parseInt(arr[1]);
		int y = Integer.parseInt(arr[2]);
		int z = Integer.parseInt(arr[3]);
		float yaw = Float.parseFloat(arr[4]);
		float pitch = Float.parseFloat(arr[5]);
		
		return new Location(Bukkit.getWorld(world), (double)x, (double)y, (double)z,yaw,pitch);
	}

}
