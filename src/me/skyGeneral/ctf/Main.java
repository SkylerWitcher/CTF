package me.skyGeneral.ctf;

import me.skyGeneral.ctf.listeners.ListenerClass;
import me.skyGeneral.ctf.utils.Colors;

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	static Server server;
	public void onEnable(){
		new ListenerClass();
		server = getServer();
		ConsoleCommandSender console = getConsole();
		console.sendMessage(Colors.colorize("&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-"));
		console.sendMessage(Colors.colorize(""));
		console.sendMessage(Colors.colorize(""));
		console.sendMessage(Colors.colorize("&e" + getDescription().getFullName() + " &6v. &e" + getDescription().getVersion() + "&6is now enabled."));
		console.sendMessage(Colors.colorize("&6Made during a Dev Contest."));
		console.sendMessage(Colors.colorize(""));
		console.sendMessage(Colors.colorize(""));
		console.sendMessage(Colors.colorize("&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-"));
	}
	public static ConsoleCommandSender getConsole(){
		return server.getConsoleSender();
	}	

}
