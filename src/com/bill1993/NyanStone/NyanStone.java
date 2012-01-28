package com.bill1993.NyanStone;

import java.util.logging.Logger;


import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NyanStone extends JavaPlugin
{
	/* -- NyanStone Decelerations -- */
	public static final String PLUGIN_NAME = "NyanStone";
	public static final String PLUGIN_AUTHOR = "bill1993";
	public static final String PLUGIN_AUTHOR_REAL = "William B. Hastings";
	public static final String PLUGIN_DESCRIPTION = "Nyancrafts Redstone Plugin!";
	public static final String PLUGIN_VERSION = "1.0";
	
	Logger log = Logger.getLogger("Minecraft");
	
	public NyanStoneBlockListener blockListener = new NyanStoneBlockListener(this);
	
	public void onEnable()
	{
		PluginManager pm = this.getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.REDSTONE_CHANGE, blockListener, Event.Priority.Normal, this);
		
		log.info(PLUGIN_NAME + " " + PLUGIN_VERSION + " Loaded!");
	}
	
	public void onDisable() 
	{
		log.info(PLUGIN_NAME + " " + PLUGIN_VERSION + " Un-Loaded");
	}
}
