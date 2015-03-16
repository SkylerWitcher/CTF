package me.skyGeneral.ctf.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.skyGeneral.ctf.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

public class Utils {
	
	//Variables.
	private static Main plugin;
	private static Map<String, Arena> arenas = new HashMap<String, Arena>();
	private static Map<String, Location> signs = new HashMap<String, Location>();
	private static File file = new File("plugins/CTF/Arenas.yml");
	private static YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
	
	//Initialize the Utils. (Save Main class, and shit)
	public static void init(Main p){
		setPlugin(p);
		
	}
	public static Main getPlugin() {
		return plugin;
	}


	public static void setPlugin(Main plugin) {
		Utils.plugin = plugin;
	}
	
	
	//YAML and FILE stuff.
	public static YamlConfiguration getArenas(){
		return yml;
	}
	public static void saveArenas(){
		try {
			yml.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Arena getArena(String arena) {
		if(!arenas.containsKey(arena)){
			Arena a = new Arena(arena);
			arenas.put(arena, a);
			return a;
		}
		return arenas.get(arena);
	}
	
	
	//Color and chat related stuff.
	public static String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	
	
	//Functionality.

	public static void saveAll() {
		// TODO Auto-generated method stub
		
	}


	public static String getArenaMaxSize(Arena arena) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void addArenaSign(String name, Location loc) {
		signs.put(name, loc);
	}
	public static void updateArenaSign(Arena arena){
		Sign sign = (Sign) ((World) arena.getRedSpawn().getWorld()).getBlockAt(signs.get(arena.getName())).getState();
		if(arena.isPlaying()) sign.setLine(2, Utils.colorize("&1In Game"));
		if(arena.isStarting()) sign.setLine(2, Utils.colorize("&1Starting..."));
		if(!arena.isPlaying() && !arena.isStarting()) sign.setLine(2, Utils.colorize("&1Empty"));
		sign.setLine(1, Utils.colorize("&c" + arena.getRedTeamINT() + "&7/&9" + arena.getBlueTeamINT()));
		sign.update();
	}
	public static Arena createArena(String name){
		Arena arena = new Arena(name);
		arenas.put(name, arena);
		return arena;
	}

}
