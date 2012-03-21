package com.bill1993.NyanStone.Mechanics;

import org.bukkit.Material;
import org.bukkit.block.Block;
import com.bill1993.NyanStone.Mechanics.Gates;

public class Redstone
{
	public static void ToggleNetherrack(Block block, int current) 
	{
		Block ablock = block.getRelative(0, 1, 0);
		if(current > 0)
		{
			if(ablock.getType().equals(Material.AIR)) ablock.setType(Material.FIRE);
		}
		else
		{
			if(ablock.getType().equals(Material.FIRE)) ablock.setType(Material.AIR);
		}
	}

	public static void toggleGate(Block block, int current) 
	{
		if(current > 0)
		{
			Gates.toggleGate(block, Gates.GATE_OPEN);
		}
		else
		{
			Gates.toggleGate(block, Gates.GATE_CLOSE);
		}
	}

	public static void toggleBridge(Block block, int current) 
	{
		if(current > 0)
		{
			Bridge.toggleBridge(block, Bridge.BRIDGE_DOWN);
		}
		else
		{
			Bridge.toggleBridge(block, Bridge.BRIDGE_UP);
		}
	}

	public static void TogglePumpkin(Block block, int current) 
	{
		if(current > 0)
		{
			block.setType(Material.JACK_O_LANTERN);
		}
		else
		{
			block.setType(Material.PUMPKIN);
		}
	}
}
