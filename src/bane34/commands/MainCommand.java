package bane34.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import bane34.main.SimplePlugin;

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
				if(args[0].equalsIgnoreCase("version")) {
					player.sendMessage(plugin.name + " is on version: " + plugin.version);
					return true;
				}
				else {
					player.sendMessage("Wrong argument");
					return false;
				}
			}
			else {
				player.sendMessage("A pechi le gusta oliveira");
				return false;
			}
		}
	}
}
