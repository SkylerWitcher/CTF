package me.skyGeneral.ctf.listeners;

import me.skyGeneral.ctf.Main;
import me.skyGeneral.ctf.utils.Arena;
import me.skyGeneral.ctf.utils.Utils;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ListenerClass implements Listener {
	
	
	Main plugin;
	public ListenerClass(Main plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onSignEdit(SignChangeEvent e){
		if(ChatColor.stripColor(e.getLine(0)).equalsIgnoreCase("[ARENA]")){
			if(e.getPlayer().hasPermission("ctf.createsign")){
				Arena arena = Utils.getArena(e.getLine(1).toLowerCase());
				Utils.addArenaSign(e.getLine(1).toLowerCase(), e.getBlock().getLocation());
				e.setLine(0, Utils.colorize("&8[&3" + e.getLine(1) + "&8]"));
				e.setLine(1, Utils.colorize("&c" + arena.getRedTeamINT() + "&7/&9" + arena.getBlueTeamINT()));
				
			}
		}
		if(ChatColor.stripColor(e.getLine(0)).equalsIgnoreCase("[STATS]")){
			e.setLine(0, Utils.colorize("&8[&3Stats&8]"));
			e.setLine(1, Utils.colorize("&61&8. &6SkyTheDev"));
			e.setLine(2, Utils.colorize("&61&8. &6SkyTheDev"));
			e.setLine(3, Utils.colorize("&61&8. &6SkyTheDev"));
		}
	}
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		if(e.getClickedBlock().getState() instanceof Sign){
			Sign sign = (Sign) e.getClickedBlock().getState();
			if(ChatColor.stripColor(sign.getLine(0)).equalsIgnoreCase("[Stats]")){
				e.getPlayer().sendMessage(Utils.colorize("&8[&3CTF&8]&9 Sorry; stats don't work yet."));
			}
		}
	}

}
