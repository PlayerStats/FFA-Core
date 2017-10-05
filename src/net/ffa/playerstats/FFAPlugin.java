package net.ffa.playerstats;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import lombok.Setter;
import net.ffa.playerstats.listener.FFAListeners;
import net.ffa.playerstats.listener.FFASetSpawnListener;
import net.ffa.playerstats.util.LocationUtil;

public class FFAPlugin extends JavaPlugin {

	private static FFAPlugin instance;
	@Getter @Setter private Location spawn;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		instance = this;
		
		spawn = getConfig().getString("spawn") == null ? null : LocationUtil.locationFromString(getConfig().getString("spawn"));
		
		registerListeners();
		log(this,"INFO","Plugin enabled successfully.");
	}
	
	public static FFAPlugin getInstance() {
		return instance;
	}
	
	void registerListeners() {
		new FFAListeners(this);
		new FFASetSpawnListener(this);
	}
	
	public static void log(FFAPlugin plugin, String type, String message) {
		plugin.getLogger().info("("+type+") " + message);
	}
	public static void log(String type, String message) {
		log(getInstance(),type,message);
	}
	//0 - armor
	//1 - items
	public List<ItemStack> getDefaultItems(int type){
		
		List<ItemStack> items = new ArrayList<>(), armor = new ArrayList<>();
		items.add(new ItemStack(Material.IRON_SWORD));
		items.add(new ItemStack(Material.FISHING_ROD));
		items.add(new ItemStack(Material.BOW));
		items.add(new ItemStack(Material.ARROW,64));
		items.add(new ItemStack(Material.GOLDEN_APPLE, 16));
		
		armor.add(new ItemStack(Material.GOLD_HELMET));
		armor.add(new ItemStack(Material.IRON_CHESTPLATE));
		armor.add(new ItemStack(Material.GOLD_LEGGINGS));
		armor.add(new ItemStack(Material.IRON_BOOTS));
		
		switch(type) {
		case 0:
			return items;
		case 1:
			return armor;
		default:
			return items;
		}
	}
	public ItemStack[] getDefaultItemsArray(int  type) {
		return getDefaultItems(type).toArray(new ItemStack[0]);
	}
}
