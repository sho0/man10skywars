package red.man10.man10skywars;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by sho-pc on 2017/04/05.
 */
public class Man10SkyWarsRunnable {

    private final Man10SkyWars plugin;

    public Man10SkyWarsRunnable(Man10SkyWars  plugin) {
        this.plugin = plugin;
    }

    public void messageRunnable(){
        new BukkitRunnable(){
            @Override
            public void run(){
            }
        }.runTaskTimer(plugin,0,10);
    }


}
