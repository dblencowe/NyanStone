package com.bill1993.NyanStone.Mechanics;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class Gates 
{
	public static final int GATE_AUTO = 0, GATE_OPEN = 1, GATE_CLOSE = 2;
	
	
	public static boolean isGateSign(Sign sign)
	{
		return sign.getLine(1).equalsIgnoreCase("[Gate]") && Config.allowGates;
	}
	
	public static void toggleGate(Block block, int state)
	{
		Block gateBlock;
		Material gateBlockType;
		
		for(int x = -9; x <= 9; x++)
		{
			for(int z = -3; z <= 3; z++)
			{
				for(int y = -9; y <= 9; y++)
				{
					gateBlock = block.getRelative(x, y, z);
					
					if(gateBlock.getType().equals(Material.IRON_FENCE) || gateBlock.getType().equals(Material.FENCE))
					{
						gateBlockType = gateBlock.getType();
						
						if(!gateBlock.getRelative(0, 1, 0).getType().equals(Material.AIR))
						{
							gateBlock = gateBlock.getRelative(0, -1, 0);
							if(gateBlock.getType().equals(Material.AIR))
							{
								if(state == GATE_CLOSE || state == GATE_AUTO)
								{
									while(gateBlock.getType().equals(Material.AIR))
									{
										gateBlock.setType(gateBlockType);
										gateBlock = gateBlock.getRelative(0, -1, 0);
									}
								}
						
							}
							else
							{
								if(state == GATE_OPEN || state == GATE_AUTO)
								{
									while(gateBlock.getType().equals(Material.IRON_FENCE) || gateBlock.getType().equals(Material.FENCE))
									{
										gateBlock.setType(Material.AIR);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
