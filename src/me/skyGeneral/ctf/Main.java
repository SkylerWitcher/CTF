package me.skyGeneral.ctf;

import me.skyGeneral.ctf.listeners.ListenerClass;
import me.skyGeneral.ctf.utils.Utils;

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	static Server server;
	public void onEnable(){
		
		//Initialize the Utils.
		Utils.init(this);
		
		//Register the listeners.
		new ListenerClass(this);
		
		//Register the commands.
		
		
		//Set the server & console.
		server = getServer();
		ConsoleCommandSender console = getConsole();
		
		//Display a message in the console saying CTF has been enabled.
		console.sendMessage(Utils.colorize("&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-"));
		console.sendMessage(Utils.colorize(""));
		console.sendMessage(Utils.colorize(""));
		console.sendMessage(Utils.colorize("&e" + getDescription().getFullName() + " &6v. &e" + getDescription().getVersion() + "&6is now enabled."));
		console.sendMessage(Utils.colorize("&6Made during a Dev Contest."));
		console.sendMessage(Utils.colorize(""));
		console.sendMessage(Utils.colorize(""));
		console.sendMessage(Utils.colorize("&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-"));
	}
	
	public void onDisable(){
		Utils.saveAll();
	}
	public static ConsoleCommandSender getConsole(){
		return server.getConsoleSender();
	}	

}
