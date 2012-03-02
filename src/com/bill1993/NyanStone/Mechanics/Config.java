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

	public static void loadConfig(Plugin plugin)
	{
		FileConfiguration config = plugin.getConfig();
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		allowNetherack = config.getBoolean("Toggle.Netherack");
		allowGates = config.getBoolean("Toggle.Gates");
		allowBridges = config.getBoolean("Toggle.Bridges");
		
		allowedBridgeBlocks = new ArrayList<Integer>();
		allowedBridgeBlocks = config.getIntegerList("Restrictions.Allowed-Bridge-Blocks");
		
		plugin.saveConfig();
	}
	
}


/*Integer[] derp = {1, 2, 3, 4, 5, 43, 98};

config.addDefault("Toggle.Netherack", true);
config.addDefault("Toggle.Gates", true);
config.addDefault("Toggle.Bridges", true);
config.addDefault("Restrictions.Allowed-Bridge-Blocks", Arrays.asList(derp));

config.options().copyDefaults(true);
plugin.saveConfig();
*/
