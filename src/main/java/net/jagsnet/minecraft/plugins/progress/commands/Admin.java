package net.jagsnet.minecraft.plugins.progress.commands;

import net.jagsnet.minecraft.plugins.progress.otherStuff.Configs;
import net.jagsnet.minecraft.plugins.progress.otherStuff.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;
            if (!p.hasPermission("progress.admin")) {
                Utils.sendMessage(p, "You are missing admin permissions. Speak to Melon for more info");
                return true;
            }

            if (args.length < 1) {
                Utils.sendMessage(p, "/progress get");
                return true;
            }

            if (args[0].equalsIgnoreCase("get")) {
                for (String s : Configs.getGlobal().getKeys(false)) {
                    if (Configs.getGlobal().getString(s + ".winner") == null && Configs.getGlobal().getString(s + ".leader") != null) {
                        Utils.sendMessage(p, s + ": x=" + Configs.getGlobal().getDouble(s + ".x") + " y=" + Configs.getGlobal().getDouble(s + ".x") + " leader=" + Configs.getGlobal().getString(s + ".leader"));
                    } else if (Configs.getGlobal().getString(s + ".winner") != null) {
                        Utils.sendMessage(p, s + ": winner=" + Configs.getGlobal().getString(s + ".winner") + " winTime=" + Configs.getGlobal().getDouble(s + ".winTime"));
                    } else {
                        Utils.sendMessage(p, s + ": No progress");
                    }
                }
            }
        }
        return true;
    }
}