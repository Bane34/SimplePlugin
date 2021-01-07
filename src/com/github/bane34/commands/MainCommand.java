package com.github.bane34.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.bane34.events.Inventorys;
import com.github.bane34.main.SimplePlugin;

import net.md_5.bungee.api.ChatColor;

public class MainCommand implements CommandExecutor{
	private SimplePlugin plugin;
	
	public MainCommand(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(plugin.name + " You cant use this command in the prompt");
			return false;
		}
		else {
			Player player = (Player) sender;
			
			if(args.length > 0) {
				switch(args[0]) {
				case "version":
					player.sendMessage(plugin.name + " is on version: " + plugin.version);
					break;
				case "reload":
					plugin.reloadConfig();
					player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&aPlugin reloaded succesfully"), null, 10, 30, 10);
					break;
				case "inventory":
					Inventorys inventory = new Inventorys();
					inventory.createInventory(player);
					
					break;
				default:
					player.sendMessage("Wrong argument");
					break;
				}
				return true;
			}
			else {
				player.sendMessage("A pechi le gusta oliveira");
				return false;
			}
		}
	}
}
