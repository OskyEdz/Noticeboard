package se.peacehult.oskyedz.noticeboard;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BoardCommand extends BoardGUI implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String noticeboard, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            openInventory(player);
        }
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("This command is a GUI, run in-game.");
        }
        return true;
    }
}