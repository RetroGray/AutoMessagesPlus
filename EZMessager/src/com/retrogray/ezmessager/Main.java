package com.retrogray.ezmessager;

import java.util.LinkedHashSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.retrogray.ezmessager.commands.BaseCommand;
import com.retrogray.ezmessager.utils.Utils;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		BukkitScheduler scheduler = getServer().getScheduler();
		
		Bukkit.getConsoleSender().sendMessage("=+---------------------------------------+=");
		Bukkit.getConsoleSender().sendMessage("Enabled EZMessager");
		Bukkit.getConsoleSender().sendMessage("Author: RetroGray (www.retrogray.com)");
		Bukkit.getConsoleSender().sendMessage("=+---------------------------------------+=");
		this.saveDefaultConfig();
		
		new BaseCommand(this);
	
		LinkedHashSet<String> messagesArray = (LinkedHashSet<String>)getConfig().getConfigurationSection("messages").getKeys(false);
		
		int delay = getConfig().getInt("delay") * 20;
		int messages = messagesArray.size();
		String[] message = {"NOTbutts"};
		int[] taskCounter = {0};
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			
				@Override
				public void run() {
					
					try {
						if (taskCounter[0] >= messages) taskCounter[0] = 0;
						taskCounter[0]++;
					} catch (Exception e) {
						Bukkit.getConsoleSender().sendMessage("Resetting counter BROKEN!");
					}
					
					try {
						message[0] = getConfig().getString("messages." + taskCounter[0]);
					} catch (Exception e) {
						Bukkit.getConsoleSender().sendMessage("[AMP] Make sure you set up the config correctly!");
					}
					
					try {
					for (Player on : Bukkit.getOnlinePlayers())
						on.sendMessage(Utils.chat(message[0].toString()));
					} catch (Exception e) {
						Bukkit.getConsoleSender().sendMessage("[AMP] Please contact support!");
					}
		    		
				}
        		
        		
		} , 0L, delay );
    		
	 }
		    
}


