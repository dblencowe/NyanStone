package com.bill1993.NyanStone;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

import com.bill1993.NyanStone.Mechanics.Bridge;
import com.bill1993.NyanStone.Mechanics.Config;
import com.bill1993.NyanStone.Mechanics.Gates;
import com.bill1993.NyanStone.Mechanics.Redstone;

public class RedstoneListener implements Listener
{
	public RedstoneListener(NyanStone plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	//--- Check for Redstone Powerd Netherack/signs ---//
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void OnBlockRedstoneChange(BlockRedstoneEvent event)
	{	
		Block block = event.getBlock();
		
		if(block.getType().equals(Material.NETHERRACK) && Config.allowNetherack)
		{
			Redstone.ToggleNetherrack(block, event.getNewCurrent());
		}
		else if(block.getState() instanceof Sign)
		{
			if(Gates.isGateSign((Sign) block.getState()))
			{
				Redstone.toggleGate(block, event.getNewCurrent());
			}
			if(Bridge.isBridgeSign((Sign) block.getState()))
			{
				Redstone.toggleBridge(block, event.getNewCurrent());
			}
		}
		else return;
	}
	
}
