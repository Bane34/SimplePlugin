package com.github.bane34.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.bane34.main.SimplePlugin;

public class EnteringWorld implements Listener {
	private SimplePlugin plugin;
	
	public EnteringWorld(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerEnterStrikeLightning(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		World world = player.getWorld();
		Location location = player.getLocation();
		
		FileConfiguration config = plugin.getConfig();
		String text_path = "Config.welcome-message";
		String title_path = "Config.welcom-message-title";
		
		if(config.getString(text_path).equals("true")) {
			String text = "Config.welcome-message-text";
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(text)).replaceAll("%player%", player.getName()));
		}
		
		if(config.getString(title_path).equals("true")) {
			String text = "Config.welcome-message-title";
			player.sendTitle(ChatColor.translateAlternateColorCodes('&', config.getString(text).replaceAll("%player%", player.getName())), null, 10, 70, 20);
		}
		
		world.strikeLightningEffect(location);
	}
}