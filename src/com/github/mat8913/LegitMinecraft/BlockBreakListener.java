package com.github.mat8913.LegitMinecraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
  //What tool you need to destroy these blocks
  private final int[] pick = {1, 4, 15, 16, 21, 22, 23, 24, 41, 42, 43, 44, 45, 48, 49, 52, 56, 57, 61, 62, 67, 69, 70, 71, 73, 74, 77, 82, 87, 89, 97, 98, 101, 108, 109, 112, 113, 114, 121, 129, 133};
  private final int[] axe = {5, 17, 25, 29, 33, 35, 47, 50, 53, 54, 58, 63};
  //private final int[] shovel = {46,  55, 59, 60};
  //private final int[] shears = {32, 37, 38, 39, 40};
  //special 18 cobweb:30
  //pumpkin and watermelon hoe

  private final int[] pick_tool = {270, 274, 257, 285, 278};

  /**
   * @param  blockIds  an array of blocks which require a tools to break
   * @param  toolIds   an array of tools which can successfully break the block
   * @param  block     the block which has been broken 
   * @param  tool      the tool which was used to break the block
   * @return           0 if the correct tool was used for the block, 1 if the incorrect tool was used for the block, 2 if the block broken doesn't apply to this tool.
   */
  public int correctTool(int[] blockIds, int[] toolIds, int block, int tool) {
    for (int i = 0; i < blockIds.length; i++) {
      if (block == blockIds[i]) {
        for (int x = 0; x < toolIds.length; x++) {
          if (tool == toolIds[x]) {
            x = pick_tool.length;
            return 0;
          }
        }
      return 1;
      }
    } 
    return 2;
  }

  @EventHandler(priority = EventPriority.HIGH)
  public void blockBreak(BlockBreakEvent event) {
    //FIXME: Not very efficient I would assume (but then again, Minecraft isn't very efficient)
    if (correctTool(pick, pick_tool, event.getBlock().getTypeId(), event.getPlayer().getItemInHand().getTypeId()) == 0)
      return;
    if (correctTool(pick, pick_tool, event.getBlock().getTypeId(), event.getPlayer().getItemInHand().getTypeId()) == 1) {
      event.setCancelled(true);
      event.getPlayer().sendMessage("You need a pickaxe to break this block.");
      return;
    }
    
   /* for (int i = 0; i < this.pick.length; i++) {
      if (event.getBlock().getTypeId() == pick[i]) {
        for (int x = 0; x < this.pick_tool.length; x++) {
          if (event.getPlayer().getItemInHand().getTypeId() == this.pick_tool[x]) {
            correctTool = true;
            x = this.pick_tool.length;
          }
        }
        if (!correctTool) {
          event.setCancelled(true);
          event.getPlayer().sendMessage("You need a pickaxe to break this block");
        }
      }
    }  */
/*
    for (int i = 0; i < this.axe.length; i++) {
      if (event.getBlock().getTypeId() == axe[i]) {
        //Cancel event
        event.getPlayer().sendMessage("You need an axe to break this block.");
      }
    }

     for (int i = 0; i < this.axe.length; i++) {
      if (event.getBlock().getTypeId() == shovel[i]) {
        //Cancel event
        event.getPlayer().sendMessage("You need a shovel to break this block.");
      }
    }

    for (int i = 0; i < this.axe.length; i++) {
      if (event.getBlock().getTypeId() == shears[i]) {
        //Cancel event
        event.getPlayer().sendMessage("You need shears to break this block.");
      }
    }
*/
  }

}
