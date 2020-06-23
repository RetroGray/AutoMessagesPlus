package com.retrogray.automessagesplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.retrogray.automessagesplus.Main;
import com.retrogray.automessagesplus.utils.Utils;

public class BaseCommand implements CommandExecutor{
	
	private Main plugin;
	public BaseCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("amp").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can execute this command!");
		}
		
		Player p = (Player) sender;
		if(p.hasPermission("amp.base")) {
			if (args.length == 0) {
				p.sendMessage(Utils.chat("&7[&eAMP&7] Commands:"));
				p.sendMessage(Utils.chat("&7[&eAMP&7] &e/amp reload &7- &aReloads the plugin."));
				p.sendMessage(Utils.chat("&7[&eAMP&7] &e/amp win &7- &aLlama."));
				return true;
			}
		}
		if(p.hasPermission("amp.reload")) {
			if(args[0].equalsIgnoreCase("reload")) {
				plugin.reloadConfig();
				p.sendMessage(Utils.chat("&7[&eAMP&7] &eConfig has been reloaded!"));
				Bukkit.getConsoleSender().sendMessage("[AMP] Config has been reloaded!");
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
