package se.peacehult.oskyedz.noticeboard;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BoardCommand extends BoardGUI implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String noticeboard, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            openInventory(player);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}