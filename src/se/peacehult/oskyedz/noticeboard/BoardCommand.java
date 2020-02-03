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
        if (args.length == 0) { // Command issue with no arguments
            if (!(sender instanceof ConsoleCommandSender)) { // Define that it's the player sending the command
                Player player = (Player) sender;

                openInventory(player); // Open the noticeboard
                return true;
            } else {
                // If console tries to run command
                System.out.println("This command is a GUI, run in-game.");
            }
        } else {
            if (args[0].equalsIgnoreCase("new")) { // Command issue with argument "new"
                if (args.length > 3) { // Even more arguments

                    for (String str: args) {  // Merge all arguments to one string.
                        createGuiItem(args[2], str);
                        return true;
                    }
                } else { return false; }
            }
        } return false;
    }
}