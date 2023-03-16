package net.jagsnet.minecraft.plugins.progress.listeners;

import net.jagsnet.minecraft.plugins.progress.otherStuff.Configs;
import net.jagsnet.minecraft.plugins.progress.otherStuff.Utils;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Respawn implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onSpawn(PlayerRespawnEvent e) {

        String w = e.getPlayer().getWorld().getName();
        if (Configs.getGlobal().get(w+".respawn") != null) {
            e.setRespawnLocation(new Location(e.getPlayer().getWorld(), Configs.getGlobal().getDouble(w + ".respawn.x"), Configs.getGlobal().getDouble(w + ".respawn.y"), Configs.getGlobal().getDouble(w + ".respawn.z")));
        }
    }
}
