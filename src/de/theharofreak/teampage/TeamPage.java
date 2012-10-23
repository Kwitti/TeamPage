package de.theharofreak.teampage;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.theharofreak.teampage.commands.TeamCommand;
import de.theharofreak.teampage.util.ConfigFile;

public class TeamPage extends JavaPlugin {
	
	//Strings
	public String prefix = "[TeamPage] ";
	public String sc = ChatColor.GRAY + "[" + ChatColor.GOLD + "TeamPage" + ChatColor.GRAY + "] ";

	//Classes
	ConfigFile config = new ConfigFile(this);
	
	@Override
	public void onDisable() {
		//PrintStuff
		System.out.println(prefix + "Plugin disabled.");
	}
	
	@Override
	public void onEnable() {
		//Commands
		getCommand("team").setExecutor(new TeamCommand(this));
		
		//Load config
		config.loadConfigFile();
		
		//PrintStuff
		System.out.println(prefix + "Plugin enabled.");
	}

}
