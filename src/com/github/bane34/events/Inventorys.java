package com.github.bane34.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventorys implements Listener {
	private Inventory inventory = null;
	private ItemStack item;
	private ItemMeta meta;
	private List<String> lore;
	
	
	
	public void createInventory(Player player) {
		inventory = Bukkit.createInventory(null, 54, "My inventory"); //The inventory size must be multiple of 9
		
		//First item
		item = new ItemStack(Material.REDSTONE_BLOCK, 1);
		meta = item.getItemMeta();
		lore = new ArrayList<String>();
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Teleporter"));
		
		lore.add("Sends you a message");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		inventory.setItem(20, item);
		
		if(player.isOp()) {
			item = new ItemStack(Material.DIAMOND, 1);
			meta = item.getItemMeta();
			lore = new ArrayList<String>();
			
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "Teleporter"));
			lore.add("Gives you illegal shit if you are op");
			meta.setLore(lore);
			item.setItemMeta(meta);
			
			inventory.setItem(22, item);
		}
		
		ItemStack decoration = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		
		for(int i = 0; i < 54; i++) {
			if(inventory.getItem(i) == null) {
				inventory.setItem(i, decoration);
			}
			else {
				continue;
			}
		}
		
		player.openInventory(inventory);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		//String name = "My inventory";
		Inventory inventory = event.getClickedInventory();
		

		if(inventory.equals(inventory)) {
			if(event.getCurrentItem() == null || event.getSlotType() == null || event.getCurrentItem().getType() == Material.AIR) {
				event.setCancelled(true);
				return;
			}
			else {
				if(event.getCurrentItem().hasItemMeta()) {
					Player player = (Player) event.getWhoClicked();
					
					event.setCancelled(true);
					if(event.getSlot() == 20) {
						player.closeInventory();
						player.sendTitle("A pechi le gusta oliveira", null, 10, 50, 10);
					}
					else if (event.getSlot() == 22) {
						if(player.isOp()) {
							player.closeInventory();
							player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
							return;
						}
						else {
							player.sendMessage("No diamonds for you bitch");
							player.closeInventory();
							return;
						}
					}
				}
				return;
			}
		}
	}
	
	@EventHandler
	public void onInventoryDrag(final InventoryDragEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getInventory() == inventory) {
			event.setCancelled(true);
			player.closeInventory();
			return;
		}
	}
}
