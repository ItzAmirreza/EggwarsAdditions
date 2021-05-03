package ir.deadlight.ea2;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pluginCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {

            sender.sendMessage(Utils.color("&bEggwars Additions By &eDead_Light"));
            sender.sendMessage(Utils.color("&7- &c/ea reload"));


        } else {

            if (args[0].equalsIgnoreCase("reload")) {

                Utils.reloadConfig();
                sender.sendMessage(Utils.color("&aReloaded!"));

            } else {

                sender.sendMessage(Utils.color("&bEggwars Additions By &eDead_Light"));
                sender.sendMessage(Utils.color("&7- &c/ea reload"));

            }

        }

        return false;
    }
}
