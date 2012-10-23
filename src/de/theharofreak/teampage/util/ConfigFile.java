package de.theharofreak.teampage.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import de.theharofreak.teampage.TeamPage;

public class ConfigFile {
	
	//Constructor
	private TeamPage plugin;
	public ConfigFile (TeamPage plugin) {
		this.plugin = plugin;
	}
	
	//Method for loading config
	public void loadConfigFile() {
		FileConfiguration config;
		
		//Check if file already exists
		if(new File("plugins/TeamPage/config.yml").exists()) {
			config = plugin.getConfig();
			System.out.println(plugin.prefix + "Config successfully loaded.");
			
			//Load file from plugin
		} else {
			plugin.saveDefaultConfig();
			config = plugin.getConfig();
			System.out.println(plugin.prefix + "No config found. Creating one ...");
			System.out.println(plugin.prefix + "Config successfully loaded.");
			
		}
		
		
	}

}
