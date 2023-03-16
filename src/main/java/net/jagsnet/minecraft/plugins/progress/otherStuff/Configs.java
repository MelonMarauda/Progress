package net.jagsnet.minecraft.plugins.progress.otherStuff;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configs {
    // ------------- Config file functions -----------------------------
    public static void setup(String configName){
        File file;
        FileConfiguration customFile;
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Progress ").getDataFolder(), configName + ".yml");
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }
    private static File file2;
    private static FileConfiguration customFile2;
    public static FileConfiguration get(){
        return customFile2;
    }
    public static void load(String name){
        file2 = new File(Bukkit.getServer().getPluginManager().getPlugin("Progress").getDataFolder(), name + ".yml");
        customFile2 = YamlConfiguration.loadConfiguration(file2);
    }
    public static void save(){
        try{
            customFile2.save(file2);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    // ----------------- Config file functions for global --------------------
    private static File global;
    private static FileConfiguration customGlobal;
    public static void setupGlobal(){
        global = new File(Bukkit.getServer().getPluginManager().getPlugin("Progress").getDataFolder(),"Global.yml");
        if (!global.exists()){
            try{
                global.createNewFile();
            }catch (IOException e){
            }
        }
        customGlobal = YamlConfiguration.loadConfiguration(global);
        try{
            customGlobal.save(global);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }
    public static FileConfiguration getGlobal(){
        return customGlobal;
    }
    public static void loadGlobal(){
        global = new File(Bukkit.getServer().getPluginManager().getPlugin("Progress").getDataFolder(), "Global.yml");
        customGlobal = YamlConfiguration.loadConfiguration(global);
    }
    public static void saveGlobal(){
        try{
            customGlobal.save(global);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }
}
