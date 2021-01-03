package bane34.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class ThrowingThings implements Listener {
	
	@EventHandler
	public void onProjectilHit(PlayerEggThrowEvent event) {
		Egg egg = event.getEgg();
		World world = egg.getWorld();
		Location location = egg.getLocation();
		
		world.strikeLightning(location);
		event.setHatching(false);
	}
}
