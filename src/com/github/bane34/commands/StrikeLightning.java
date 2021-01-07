package com.github.bane34.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.bane34.main.SimplePlugin;

public class StrikeLightning implements CommandExecutor {
	private SimplePlugin plugin;
	
	public StrikeLightning(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(plugin.name + " this command cant be used in this context");
			return false;
		}
		else {
			Player player = (Player) sender;
			
			if(args.length > 0) {
				Player target = Bukkit.getPlayerExact(args[0]);

				if(target != null) {
					World world = target.getWorld();
					Location location = target.getLocation();
					
					world.strikeLightning(location);
					return true;
				}
				else {
					player.sendMessage("You have to select a valid player");
					return false;
				}
			}
			else {
				player.sendMessage("Introduce the player you want to strike a lightning in");
				return false;
			}
		}
	}
}
