package com.bill1993.NyanStone.Mechanics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config 
{
	public static List<Integer> allowedBridgeBlocks;
	public static boolean allowNetherack;
	public static boolean allowGates;
	public static boolean allowBridges;
	public static boolean allowLifts;
	public static boolean allowPumpkins;

	public static void loadConfig(Plugin plugin)
	{
		FileConfiguration config = plugin.getConfig();
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		allowNetherack = config.getBoolean("Toggle.Netherack");
		allowGates = config.getBoolean("Toggle.Gates");
		allowBridges = config.getBoolean("Toggle.Bridges");
		allowLifts = config.getBoolean("Toggle.Lifts");
		allowPumpkins = config.getBoolean("Toggle.Pumpkins");
		
		allowedBridgeBlocks = new ArrayList<Integer>();
		allowedBridgeBlocks = config.getIntegerList("Restrictions.Allowed-Bridge-Blocks");
		
		plugin.saveConfig();
	}
	
}
