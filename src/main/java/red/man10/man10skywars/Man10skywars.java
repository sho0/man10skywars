package red.man10.man10skywars;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Vector;

public final class Man10skywars extends JavaPlugin implements Listener {

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
    
}
