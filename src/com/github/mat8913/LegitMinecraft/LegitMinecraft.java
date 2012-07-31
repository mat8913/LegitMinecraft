package com.github.mat8913.LegitMinecraft;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.mat8913.LegitMinecraft.BlockBreakListener;

public class LegitMinecraft extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("LegitMinecraft enabled. Time to be a man!");
    getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
  }

  @Override
  public void onDisable() {
    getLogger().info("LegitMinecraft disabled.");
  }

}
