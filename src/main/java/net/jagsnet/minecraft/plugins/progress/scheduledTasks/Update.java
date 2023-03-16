package net.jagsnet.minecraft.plugins.progress.scheduledTasks;

import net.jagsnet.minecraft.plugins.progress.otherStuff.Configs;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Update {
    public static void update(){
        Configs.loadGlobal();
        for (Player p : Bukkit.getOnlinePlayers()) {
            for (String s : Configs.getGlobal().getKeys(false)) {
                String worldName = p.getWorld().getName().toLowerCase();
                if (s.equalsIgnoreCase(worldName)) {
                    if (p.getLocation().getX() + p.getLocation().getZ() > Configs.getGlobal().getDouble(s + ".x") + Configs.getGlobal().getDouble(s + ".z")) {
                        Configs.getGlobal().set(s + ".x", p.getLocation().getX());
                        Configs.getGlobal().set(s + ".z", p.getLocation().getZ());
                        Configs.getGlobal().set(s + ".leader", p.getName());
                        if (p.getLocation().getX() + p.getLocation().getZ() > Configs.getGlobal().getDouble(s + ".end")) {
                            if (Configs.getGlobal().getString(s + ".winner") == null) {
                                Configs.getGlobal().set(s + ".winner", p.getName());
                                Configs.getGlobal().set(s + ".winTime", System.currentTimeMillis());
                            }
                        }
                        Configs.saveGlobal();
                    }
                }
            }
        }
        String winning = "";
        for (String s : Configs.getGlobal().getKeys(false)) {
             if (winning.equalsIgnoreCase("") || (Configs.getGlobal().getDouble(s + ".x") + Configs.getGlobal().getDouble(s + ".z")) > (Configs.getGlobal().getDouble(winning + ".x") + Configs.getGlobal().getDouble(winning + ".z"))) {
                 winning = s;
             }
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(winning.toUpperCase() + " IS WINNING"));
        }
    }
}
