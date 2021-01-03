package bane34.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EnteringWorld implements Listener {

	@EventHandler
	public void onPlayerEnter(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		World world = player.getWorld();
		Location location = player.getLocation();
		
		world.strikeLightningEffect(location);
		return;
	}
	
}
