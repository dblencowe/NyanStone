package com.bill1993.NyanStone.Mechanics;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;

public class Bridge 
{
	public static final int UP = 1, DOWN = -1, BRIDGE_DOWN = 0, BRIDGE_UP = 1, BRIDGE_AUTO = 2;
	
	public static boolean isBridgeSign(Sign sign)
	{
		return sign.getLine(1).equalsIgnoreCase("[Bridge]") && Config.allowBridges;
	}
	
	public static boolean isValidMaterial(Material mat)
	{
		for(Integer i : Config.allowedBridgeBlocks)
		{
			if(mat.getId() == i) return true;
		}
		return false;
	}
	
	public static void toggleBridge(Block block, int state)
	{
		BlockFace direction;
		if(isValidMaterial(block.getRelative(0, 1, 0).getType()))
		{
			direction = getEndSignDirection(block);
			if(direction == null) return;
			if(isValidBridge(direction, block.getRelative(0, 1, 0)))
			{
				extendBridge(direction, block.getRelative(0, 1, 0), state);
			}
		}
		else if(isValidMaterial(block.getRelative(0, -1, 0).getType()))
		{
			direction = getEndSignDirection(block);
			if(direction == null) return;
			if(isValidBridge(direction, block.getRelative(0, -1, 0)))
			{
				extendBridge(direction, block.getRelative(0, -1, 0), state);
			}
		}
		else return;
	}

	private static void extendBridge(BlockFace direction, Block block, int state) 
	{
		int count = 0;
		Block left, mid = block.getRelative(direction, count), right;		
		
		while(count < 11)
		{
			count++;
			mid = block.getRelative(direction, count);
			if(direction == BlockFace.NORTH || direction == BlockFace.SOUTH)
			{
				left = mid.getRelative(BlockFace.EAST, 1);
				right = mid.getRelative(BlockFace.WEST, 1);
			}
			else
			{
				left = mid.getRelative(BlockFace.NORTH, 1);
				right = mid.getRelative(BlockFace.SOUTH, 1);
			}
			
			if(left.getType().equals(Material.AIR) && mid.getType().equals(Material.AIR) 
					&& right.getType().equals(Material.AIR) && (state == BRIDGE_AUTO || state == BRIDGE_DOWN))
			{
				left.setType(block.getType());
				mid.setType(block.getType());
				right.setType(block.getType());
			}
			else if(left.getType().equals(block.getType()) && mid.getType().equals(block.getType()) 
					&& right.getType().equals(block.getType()) && (state == BRIDGE_AUTO || state == BRIDGE_UP))
			{
				if(mid.getRelative(0, 1, 0).getState() instanceof Sign || mid.getRelative(0, -1, 0).getState() instanceof Sign) 
				{
					count = 12;
				}
				else
				{
					left.setType(Material.AIR);
					mid.setType(Material.AIR);
					right.setType(Material.AIR);
				}
			}
			else break;
		}
		
	}

	private static boolean isValidBridge(BlockFace direction, Block block) 
	{
		if(direction == BlockFace.NORTH || direction == BlockFace.SOUTH)
		{
			return (block.getRelative(BlockFace.EAST, 1).getType().equals(block.getType()) &&
					block.getRelative(BlockFace.WEST, 1).getType().equals(block.getType()));
		}
		else
		{
			return (block.getRelative(BlockFace.NORTH, 1).getType().equals(block.getType()) &&
					block.getRelative(BlockFace.SOUTH, 1).getType().equals(block.getType()));
		}
	}

	private static BlockFace getEndSignDirection(Block block) 
	{
		int count = 0;
		while(count < 11)
		{
			count++;
			if(block.getRelative(BlockFace.NORTH, count).getState() instanceof Sign)
			{
				return BlockFace.NORTH;
			}
			else if(block.getRelative(BlockFace.SOUTH, count).getState() instanceof Sign)
			{
				return BlockFace.SOUTH;
			}
			else if(block.getRelative(BlockFace.EAST, count).getState() instanceof Sign)
			{
				return BlockFace.EAST;
			}
			else if(block.getRelative(BlockFace.WEST, count).getState() instanceof Sign)
			{
				return BlockFace.WEST;
			}
		}
		return null;
	}

	/*private static boolean isEndSign(Block block)
	{
		if(block.getState() instanceof Sign)
		{
			Sign sign = (Sign) block.getState();
			return sign.getLine(1).equalsIgnoreCase("[Bridge End]");
		}
		return false;
	}*/
}
