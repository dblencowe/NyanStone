package com.bill1993.NyanStone;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.bill1993.NyanStone.Mechanics.Config;

public class NyanStone extends JavaPlugin
{
	/* -- NyanStone Decelerations -- */
	public static final String PLUGIN_NAME = "NyanStone";
	public static final String PLUGIN_AUTHOR = "bill1993";
	public static final String PLUGIN_AUTHOR_REAL = "William B. Hastings";
	public static final String PLUGIN_DESCRIPTION = "Nyancrafts Redstone Plugin!";
	public static final String PLUGIN_VERSION = "1.2.1";
	
	Logger log = Logger.getLogger("Minecraft");
	
	public static RedstoneListener redstonelistener = null;
	public static BlockListener blocklistener = null;
	
	public void onEnable()
	{
		Config.loadConfig(this);
		
		redstonelistener = new RedstoneListener(this);
		blocklistener = new BlockListener(this);
		log.info(PLUGIN_NAME + " " + PLUGIN_VERSION + " Loaded!");
	}
	
	public void onDisable() 
	{
		log.info(PLUGIN_NAME + " " + PLUGIN_VERSION + " Un-Loaded");
	}
}
