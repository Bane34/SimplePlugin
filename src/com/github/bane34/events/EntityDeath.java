package com.github.bane34.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class EntityDeath implements Listener {
	
	@EventHandler
	public void onChickenDeath(EntityDeathEvent event) {
		if(event.getEntityType().equals(EntityType.CHICKEN)) {
			Chicken chicken = (Chicken) event.getEntity();
			World world = chicken.getWorld();
			Location location = chicken.getLocation();
						
			world.createExplosion(location, 6f);
			return;
		}
		
	}
	
	@EventHandler
	public void onSheepDeath(EntityDeathEvent event) {
		if(event.getEntityType().equals(EntityType.SHEEP)) {
			Sheep sheep = (Sheep) event.getEntity();
			World world = sheep.getWorld();
			Location location = sheep.getLocation();
			
			world.strikeLightning(location);
			return;
		}
	}
	
	 @EventHandler
	 public void onPlayerKill(EntityDeathEvent event) {
		 Player killer = event.getEntity().getKiller();
		 EntityType entity = event.getEntityType();
		 
		 if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.PLAYER)) {
			 ItemStack stack = new ItemStack(Material.EMERALD, 1);
			 ItemMeta meta = stack.getItemMeta();
			 
			 meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aGun piu piu"));
			 
			 List<String> lore = new ArrayList<String>();
			 lore.add(ChatColor.translateAlternateColorCodes('&', "&7Gun that makes an explosion, siria sponsor this"));
			 
			 meta.setLore(lore);
			 meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			 meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			 
			 stack.setItemMeta(meta);
			 
			 if(killer.getInventory().firstEmpty() == -1) {
				 killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYour inventory is full boi"));
				 return;
			 }
			 else {
				 killer.getInventory().addItem(stack);
				 return;
			 }
		 }
	 }
}
