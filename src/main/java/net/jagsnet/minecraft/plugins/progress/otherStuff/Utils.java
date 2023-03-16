package net.jagsnet.minecraft.plugins.progress.otherStuff;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
    public static void sendMessage(Player p, String m) {
        String bold = ChatColor.BOLD + "";
        p.sendMessage(ChatColor.AQUA + bold + "PROGRESS" + ChatColor.DARK_GRAY + bold + " > " + ChatColor.WHITE + m);
    }
}
