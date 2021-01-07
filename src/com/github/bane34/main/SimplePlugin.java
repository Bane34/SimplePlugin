package bane34.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import bane34.commands.MainCommand;
import bane34.commands.StrikeLightning;
import bane34.events.CreaturesSpawn;
import bane34.events.EnteringWorld;
import bane34.events.EntityDeath;
import bane34.events.ThrowingThings;

public class SimplePlugin extends JavaPlugin{
	public String configPath;
	
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String name = "[" + pdffile.getName() + "]";
	
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + " inizializated");
		
		registerCommand();
		registerEvent();
		registerConfig();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin disabled");
	}
	
	public void registerCommand() {
		this.getCommand("simpleplugin").setExecutor(new MainCommand(this));
		this.getCommand("strikelightning").setExecutor(new StrikeLightning(this));
	}
	
	public void registerEvent() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EnteringWorld(this), this);
		pm.registerEvents(new ThrowingThings(), this);
		pm.registerEvents(new CreaturesSpawn(), this);
		pm.registerEvents(new EntityDeath(), this);
	}
	
	public void registerConfig() {
		File config = new File(this.getDataFolder(), "config.yml");
		configPath = config.getPath();
		
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
	
}
