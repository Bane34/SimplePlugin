package bane34.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import bane34.commands.MainCommand;

public class SimplePlugin extends JavaPlugin{
	PluginDescriptionFile pdffile = getDescription();
	String version = pdffile.getVersion();
	String name = "[" + pdffile.getName() + "]";
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + " inizializated");
		registerCommand();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin disabled");
	}
	
	public void registerCommand() {
		this.getCommand("simpleplugin").setExecutor(new MainCommand(this));
	}
}
