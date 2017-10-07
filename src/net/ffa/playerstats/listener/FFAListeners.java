package net.ffa.playerstats.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.ffa.playerstats.FFAPlugin;

public class FFAListeners implements Listener {
	
	private FFAPlugin plugin;
	
	public FFAListeners(FFAPlugin plugin) {
	
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	
	}
	
	/*@EventHandler
	public void death(PlayerDeathEvent e) {
		e.getDrops().clear();
		EntityDamageEvent damage = e.getEntity().getLastDamageCause();
		switch(damage.getCause()) {
		case ENTITY_ATTACK:
			e.getEntity().sendMessage(ChatColor.DARK_GRAY + "You were killed by: " + ChatColor.RED + e.getEntity().getKiller().getName());
			break;
		}
	}*/
	
	@EventHandler
	public void respawn(PlayerRespawnEvent e) {
		e.setRespawnLocation(plugin.getSpawn());
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setContents(plugin.getDefaultItemsArray(0));
		e.getPlayer().getInventory().setHelmet(plugin.getDefaultItemsArray(1)[0]);
		e.getPlayer().getInventory().setChestplate(plugin.getDefaultItemsArray(1)[1]);
		e.getPlayer().getInventory().setLeggings(plugin.getDefaultItemsArray(1)[2]);
		e.getPlayer().getInventory().setBoots(plugin.getDefaultItemsArray(1)[3]);
	}
	
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		e.getPlayer().teleport(plugin.getSpawn());
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setContents(plugin.getDefaultItemsArray(0));
		e.getPlayer().getInventory().setArmorContents(plugin.getDefaultItemsArray(1));
	}

}
