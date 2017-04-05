package red.man10.man10skywars;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
}
