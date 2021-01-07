package bane34.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CreaturesSpawn implements Listener {
	
	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) {
		if(event.getEntityType() == EntityType.CREEPER) {
			Creeper creeper = (Creeper) event.getEntity();
			
			creeper.setPowered(true);
			creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
		}
		else if(event.getEntityType() == EntityType.ZOMBIE) {
			Zombie zombie = (Zombie) event.getEntity();
			zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
			zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			
			ItemStack sharpnessSword = new ItemStack(Material.DIAMOND_SWORD);
			sharpnessSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			zombie.getEquipment().setItemInMainHand(sharpnessSword);
		}
	}
	
}
