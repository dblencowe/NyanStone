package com.bill1993.NyanStone.Mechanics;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Redstone {

	public static boolean isRedstoneCustomBlock(Material mat)
	{
		if(mat == Material.NETHERRACK) return true;
		return false;
	}

	public static void ToggleNetherrack(Block block, int current) 
	{
		Block ablock = block.getRelative(0, 1, 0);
		if(current > 0)
		{
			if(ablock.getType() == Material.AIR) ablock.setType(Material.FIRE);
		}
		else
		{
			if(ablock.getType() == Material.FIRE) ablock.setType(Material.AIR);
		}
	}
}
