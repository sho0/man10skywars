package red.man10.man10skywars;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Man10SkyWars extends JavaPlugin implements Listener {

    public String prefix = "§9[§6mskywars§9]§f";
    public ArrayList<Player> playerList = new ArrayList<>();

    Man10SkyWarsRunnable runnable = new Man10SkyWarsRunnable(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this,this);
        getCommand("msw").setExecutor(new Man10SkyWarsCommand(this));
        putPlayersInArrayList();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //==============================
    //=            権限            =
    //==============================



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("fpl")){
            Player p = (Player) sender;
            p.sendMessage("Plugins (0): ");
        }
        return true;
    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.SPECTATOR){
            p.setGameMode(GameMode.SURVIVAL);
        }
    }


    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        playerList.add(e.getPlayer());
    }
    @EventHandler
    public void onLogOut(PlayerQuitEvent e){
        playerList.remove(e.getPlayer());
    }
    public void putPlayersInArrayList(){
        playerList.clear();
        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            playerList.add(p);
        }
    }

}
