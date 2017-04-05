package red.man10.man10skywars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by sho-pc on 2017/04/05.
 */
public class Man10SkyWarsCommand implements CommandExecutor {
    private final Man10skywars plugin;

    public Man10SkyWarsCommand(Man10skywars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
