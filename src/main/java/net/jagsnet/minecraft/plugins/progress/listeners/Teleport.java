package net.jagsnet.minecraft.plugins.progress.listeners;

import net.jagsnet.minecraft.plugins.progress.otherStuff.Configs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Teleport implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onTeleport(PlayerTeleportEvent e) {
        for (String s : Configs.getGlobal().getKeys(false)) {
            if (e.getPlayer().getWorld().getName().equalsIgnoreCase(s) && !e.getPlayer().isOp()) {
                e.setCancelled(true);
                return;
            }
        }
    }
}
