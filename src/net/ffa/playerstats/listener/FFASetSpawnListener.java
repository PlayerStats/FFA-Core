package net.ffa.playerstats.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.ffa.playerstats.FFAPlugin;
import net.ffa.playerstats.util.LocationUtil;

public class FFASetSpawnListener implements Listener {

	private FFAPlugin plugin;
	public FFASetSpawnListener(FFAPlugin plugin) {
		
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void setSpawn(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().equalsIgnoreCase("/setspawn")) {
			if(e.getPlayer().hasPermission("ffa.setspawn")) {
				plugin.setSpawn(e.getPlayer().getLocation());
				plugin.getConfig().set("spawn", LocationUtil.locationToString(plugin.getSpawn()));
				plugin.saveConfig();
				
				plugin.reloadConfig();
				
				e.getPlayer().sendMessage(ChatColor.RED + "Done.");
			} else {
				e.getPlayer().sendMessage(ChatColor.RED + "No permission.");
			}
			e.setCancelled(true);
		}
	}
	
}
