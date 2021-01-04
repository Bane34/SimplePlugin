package bane34.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class ThrowingThings implements Listener {
	
	@EventHandler
	public void onEggHit(PlayerEggThrowEvent event) {
		Player player = event.getPlayer();
		if(player.isOp()) {
			Egg egg = event.getEgg();
			World world = egg.getWorld();
			Location location = egg.getLocation();
			
			world.strikeLightning(location);
			event.setHatching(false);
			
			return;
		}
		return;
	}
	
	@EventHandler
	public void onEnderPearlHit(ProjectileHitEvent event) {
		if(event.getEntityType().equals(EntityType.ENDER_PEARL)) {
			EnderPearl enderpearl = (EnderPearl) event.getEntity();
			World world = enderpearl.getWorld();
			
			world.createExplosion(event.getHitBlock().getLocation(), 4f);
			return;
		}
		else if(event.getEntityType().equals(EntityType.SNOWBALL)) {
			Snowball snowball = (Snowball) event.getEntity();
			World world = snowball.getWorld();
			
			if (event.getHitEntity() instanceof Entity) {
				world.createExplosion(event.getHitEntity().getLocation(), 0.5f);
				return;
			}
			else {
				world.createExplosion(event.getHitBlock().getLocation(), 0.5f);
				return;
			}
		}
	}
}