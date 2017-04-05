package red.man10.man10skywars;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Man10skywars extends JavaPlugin implements Listener {

    public String prefix = "§9[§6mskywars§9]§f";

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.SPECTATOR){
            p.setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e){
        if(e.getBlock().getWorld().getName().equalsIgnoreCase("world")){
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage(prefix + "ここではブロックの破壊はできません");
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e){
        if(e.getBlock().getWorld().getName().equalsIgnoreCase("world")){
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage(prefix + "ここではぷろっくの設置はできません");
        }
    }

}
