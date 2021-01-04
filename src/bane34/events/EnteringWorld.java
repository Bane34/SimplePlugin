package bane34.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import bane34.main.SimplePlugin;

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
		String path = "Config.welcome-message";
		
		
		if(config.getString(path).equals("true")) {
			String text = "Config.welcome-message-text";
			player.sendMessage(config.getString(text));
		}
				
		world.strikeLightningEffect(location);
		
	}
}
