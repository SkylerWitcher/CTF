package me.skyGeneral.ctf.utils;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {
	
	
	//Basic info.
	private String name;
	private boolean started;
	private boolean starting;
	private Location rspawn;
	private Location bspawn;
	private Set<String> players = new HashSet<String>();
	private Set<String> red = new HashSet<String>();
	private Set<String> blue = new HashSet<String>();
	
	//Identify each Arena with a String name.
	public Arena(String name) {
		this.name = name;
	}
	public Object getName() {
		return name;
	}

	public boolean isPlaying() {
		return started;
	}
	public boolean isStarting() {
		return starting;
	}

	public int getRedTeamINT() {
		return red.size();
	}
	public int getBlueTeamINT() {
		return blue.size();
	}
	public int getSizeINT() {
		return blue.size() + red.size();
	}

	public Location getRedSpawn() {
		return rspawn;
	}

	public void setRedSpawn(Location rspawn) {
		this.rspawn = rspawn;
	}

	public Location getBlueSpawn() {
		return bspawn;
	}

	public void setBlueSpawn(Location bspawn) {
		this.bspawn = bspawn;
	}
	public ArrayList<Player> getPlayers__PLAYER__(){
		ArrayList<Player> p = new ArrayList<Player>();
		for(String ps : players) p.add(Bukkit.getPlayer(ps));
		return p;
	}
	public void addPlayer(Player player){
		String team= "";
		if(getRedTeamINT() > getBlueTeamINT()){
			blue.add(player.getName());
			players.add(player.getName());
			player.teleport(getBlueSpawn());
			player.setDisplayName(Utils.colorize("&9" + player.getName()));
			player.setPlayerListName(player.getDisplayName());
			team = "&9BLUE";
		}
		if(getBlueTeamINT() > getRedTeamINT()){
			red.add(player.getName());
			players.add(player.getName());
			player.teleport(getRedSpawn());
			player.setDisplayName(Utils.colorize("&c" + player.getName()));
			player.setPlayerListName(player.getDisplayName());
			team = "&cRED";
		}
		for(Player p : getPlayers__PLAYER__()){
			p.sendMessage(Utils.colorize("&8[&3CTF&8]&7 " + player.getName() + "&7 has joined the " + team + "&1 team."));
		}
	}

}
