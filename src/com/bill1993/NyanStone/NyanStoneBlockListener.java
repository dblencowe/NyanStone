package com.bill1993.NyanStone;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;


public class NyanStoneBlockListener implements Listener
{	
	public NyanStoneBlockListener(NyanStone plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockRedstoneChange(BlockRedstoneEvent event)
	{      
        Material block = event.getBlock().getType();
        if(block == Material.NETHERRACK)
        {
        	Block aboveBlock = event.getBlock().getRelative(0, 1, 0);
        	if(event.getNewCurrent() > 0)
        	{
        		if(aboveBlock.getType().getId() == 0)
        		{
        			aboveBlock.setType(Material.FIRE);
        		}
        		return;
        	}
        	else
        	{
        		if(aboveBlock.getType() == Material.FIRE)
        		{
        			aboveBlock.setType(Material.AIR);
        		}
        		return;
        	}
        }
        return;
	}
}
