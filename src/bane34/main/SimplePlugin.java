package bane34.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import bane34.commands.MainCommand;
import bane34.events.EnteringWorld;

public class SimplePlugin extends JavaPlugin{
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String name = "[" + pdffile.getName() + "]";
	
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + " inizializated");
		registerCommand();
		registerEvents();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin disabled");
	}
	
	public void registerCommand() {
		this.getCommand("simpleplugin").setExecutor(new MainCommand(this));
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EnteringWorld(), this);
	}
}
