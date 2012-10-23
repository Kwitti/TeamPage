package de.theharofreak.teampage.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.theharofreak.teampage.TeamPage;

public class TeamCommand implements CommandExecutor {
	
	//Constructor
	private TeamPage plugin;
	public TeamCommand (TeamPage plugin) {
		this.plugin = plugin;
	}
	
	//ChatColors
	ChatColor red = ChatColor.RED;
	ChatColor gray = ChatColor.GRAY;
	ChatColor green = ChatColor.GREEN;
	ChatColor gold = ChatColor.GOLD;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Check if command is performed by console
		if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage(plugin.prefix + "This command is only for players!");
			return true;
		}
		
		Player player = (Player) sender;
		
		//Check if player has permission
		if(!player.hasPermission("TeamPage.Use")) {
			player.sendMessage(plugin.sc + red + "You don't have permission!");
			return true;
		}
		
		if(args.length > 0) {
			player.sendMessage(plugin.sc + red + "Too many arguments!");
			return true;
		}
		
		if(args.length == 0) {
			player.sendMessage(gray + "()----------" + gold + " Team " + gray + "----------()");
			player.sendMessage(green + "Online" + gray + " | " + red + "Offline");
			player.sendMessage(gray + "----------");
			player.sendMessage(green + getOnlineStaffs());
			player.sendMessage(red + getOfflineStaffs());
			player.sendMessage(gray + "----------");
			player.sendMessage(gray + "()----------" + gold + " Team " + gray + "----------()");
			return true;
			
		}
		
		return false;
	}

	public String getOnlineStaffs() {
		//Get list from config
		List<String> staffs = plugin.getConfig().getStringList("Staff");
		
		//Online member
		StringBuilder onlineStaffs = new StringBuilder();
		
		//Fetching each member
		for(String staff : staffs) {
			Player pstaff = Bukkit.getPlayer(staff);
			
			if(pstaff != null) {
				if(pstaff.isOnline()) {
					onlineStaffs.append(pstaff.getName() + "\n");
				}
			}
		}
		
		return onlineStaffs.toString();
	}
	
	public String getOfflineStaffs() {
		//Get list from config
		List<String> staffs = plugin.getConfig().getStringList("Staff");
		
		//Offline member
		StringBuilder offlineStaffs = new StringBuilder();
		
		//Fetching each member
		for(String staff : staffs) {
			Player pstaff = Bukkit.getPlayer(staff);
			
			if(pstaff == null) {
				offlineStaffs.append(staff + "\n");
			}			
		}

		return offlineStaffs.toString();	
	}

}
