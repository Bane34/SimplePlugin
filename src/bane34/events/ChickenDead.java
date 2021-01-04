package bane34.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ChickenDead implements Listener {
	
	@EventHandler
	public void onChickenDeath(EntityDeathEvent event) {
		if(event.getEntityType().equals(EntityType.CHICKEN)) {
			Chicken chicken = (Chicken) event.getEntity();
			World world = chicken.getWorld();
			Location location = chicken.getLocation();
						
			world.strikeLightning(location);
			return;
		}
		
		return;
	}
}
