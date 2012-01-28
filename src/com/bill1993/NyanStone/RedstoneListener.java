package com.bill1993.NyanStone;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import com.bill1993.NyanStone.Mechanics.Redstone;

public class RedstoneListener implements Listener
{
	public RedstoneListener(NyanStone plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void OnBlockRedstoneChange(BlockRedstoneEvent event)
	{
		
		Material mat = event.getBlock().getType(); 
		if (!Redstone.isRedstoneCustomBlock(mat)) return;
			else
			{
				Block block = event.getBlock();
				if(mat == Material.NETHERRACK) Redstone.ToggleNetherrack(block, event.getNewCurrent());
			}
	}
	
}
