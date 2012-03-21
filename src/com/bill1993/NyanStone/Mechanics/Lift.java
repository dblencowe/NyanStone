package com.bill1993.NyanStone.Mechanics;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class Lift 
{

	public static boolean isLiftSign(Sign sign) 
	{
		String line = sign.getLine(1);
		return ((line.equalsIgnoreCase("[Lift Up]") || line.equalsIgnoreCase("[Lift Down]")) && Config.allowLifts);
	}
	
	public static Location getTeleportLocation(Location loc, Player player)
	{
		if(loc == null) return null;
			else return new Location(player.getWorld(), player.getLocation().getX(), loc.getY(), player.getLocation().getZ());
	}
	
	public static boolean isLocationSafe(Location loc)
	{
		Block block = loc.getBlock();
		if(block.getType().equals(Material.AIR) || block.getState() instanceof Sign)
		{
			if(block.getRelative(BlockFace.UP, 1).getType().equals(Material.AIR) 
					|| block.getRelative(BlockFace.UP, 1).getState() instanceof Sign
					|| block.getRelative(BlockFace.DOWN, 1).getType().equals(Material.AIR) 
					|| block.getRelative(BlockFace.DOWN, 1).getState() instanceof Sign)
			{
				return true;
			}
		}
		return false;
	}

	public static void liftPlayer(Player player, Block block) 
	{
		Sign sign = (Sign) block.getState();
		String line = sign.getLine(1);
		
		if(line.equalsIgnoreCase("[Lift Up]"))
		{
			Location loc = getTeleportLocation(findLiftSign(BlockFace.UP, block), player);
			if(loc == null)
			{
				player.sendMessage(ChatColor.AQUA + "[Lift] " + ChatColor.WHITE + "No lift sign was found.");
				return;
			}
			else
			{
				if(isLocationSafe(loc)) player.teleport(loc);
				else player.sendMessage(ChatColor.AQUA + "[Lift] " + ChatColor.WHITE + "Object obstructing path.");
			}
		}
		else if(line.equalsIgnoreCase("[Lift Down]"))
		{
			Location loc = getTeleportLocation(findLiftSign(BlockFace.DOWN, block), player);
			if(loc == null)
			{
				player.sendMessage(ChatColor.AQUA + "[Lift] " + ChatColor.WHITE + "No lift sign was found.");
				return;
			}
			else
			{
				if(isLocationSafe(loc)) player.teleport(loc);
				else player.sendMessage(ChatColor.AQUA + "[Lift] " + ChatColor.WHITE + "Object obstructing path.");
			}
		}
	}

	private static Location findLiftSign(BlockFace direction, Block block)
	{
		int count = 0;
		Block relativeBlock = block.getRelative(direction, count);
		while(relativeBlock.getLocation().getY() < relativeBlock.getWorld().getMaxHeight() && relativeBlock.getLocation().getY() > 0)
		{
			count++;
			relativeBlock = block.getRelative(direction, count);
			if(relativeBlock.getState() instanceof Sign)
			{
				Sign sign = (Sign) relativeBlock.getState();
				if (isLiftSign(sign) || sign.getLine(1).equalsIgnoreCase("[Lift]")) return relativeBlock.getLocation();
			}
		}
		return null;
	}

}
