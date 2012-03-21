package com.bill1993.NyanStone;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.bill1993.NyanStone.Mechanics.Bridge;
import com.bill1993.NyanStone.Mechanics.Gates;
import com.bill1993.NyanStone.Mechanics.Lift;

public class BlockListener implements Listener
{
	public BlockListener(NyanStone plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	//--- Check For Gates/Lifts/Bridges -- //
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.isCancelled()) return;
		
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			Block block = event.getClickedBlock();
			if(block.getState() instanceof Sign)
			{
				if(Lift.isLiftSign((Sign) block.getState()))
				{
					Lift.liftPlayer(event.getPlayer(), block);
				}
				else if(Gates.isGateSign((Sign) block.getState()))
				{
					Gates.toggleGate(block, Gates.GATE_AUTO);
				}
				else if( Bridge.isBridgeSign((Sign) block.getState()))
				{
					Bridge.toggleBridge(block, Bridge.BRIDGE_AUTO);
				}
			}
			else return;
		}
		else return;
	}
}
