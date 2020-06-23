package com.retrogray.ezmessager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.retrogray.ezmessager.Main;
import com.retrogray.ezmessager.utils.Utils;

public class BaseCommand implements CommandExecutor{
	
	private Main plugin;
	public BaseCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("ezm").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can execute this command!");
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("EZM.base")) {
			if (args.length == 0) {
				p.sendMessage(Utils.chat("&7[&eEZM&7] Commands:"));
				p.sendMessage(Utils.chat("&7[&eEZM&7] &e/EZM reload &7- &aReloads the plugin."));
				p.sendMessage(Utils.chat("&7[&eEZM&7] &e/EZM win &7- &aLlama."));
				return true;
			}
		}
		if(p.hasPermission("EZM.reload")) {
			if(args[0].equalsIgnoreCase("reload")) {
				plugin.reloadConfig();
				p.sendMessage(Utils.chat("&7[&eEZM&7] &eConfig has been reloaded!"));
				Bukkit.getConsoleSender().sendMessage("[EZM] Config has been reloaded!");
				return true;
			}
		}
			if (args[0].equalsIgnoreCase("win")) {
				p.sendMessage(Utils.chat("&6&lIt really whips the llama's ass"));
				return true;
			}
		
		return false;
	}

}
