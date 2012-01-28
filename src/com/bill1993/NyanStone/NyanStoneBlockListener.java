package com.bill1993.NyanStone;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;


public class NyanStoneBlockListener extends BlockListener
{
	public NyanStone plugin;
	
	public NyanStoneBlockListener(NyanStone instance)
	{
		plugin = instance;
	}
	
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
