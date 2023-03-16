package net.jagsnet.minecraft.plugins.progress;

import net.jagsnet.minecraft.plugins.progress.commands.Admin;
import net.jagsnet.minecraft.plugins.progress.listeners.Respawn;
import net.jagsnet.minecraft.plugins.progress.listeners.Teleport;
import net.jagsnet.minecraft.plugins.progress.otherStuff.Configs;
import net.jagsnet.minecraft.plugins.progress.scheduledTasks.Update;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Progress extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Configs.setupGlobal();
        Configs.loadGlobal();

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                Update.update();
            }
        }, 0L, 100L);

        this.getCommand("progress").setExecutor(new Admin());

        getServer().getPluginManager().registerEvents(new Respawn(), this);
        getServer().getPluginManager().registerEvents(new Teleport(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
