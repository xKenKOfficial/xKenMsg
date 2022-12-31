package com.github.xKenKOfficial.Msg.Basic;

import com.github.xKenKOfficial.Msg.Commands.MsgCommand;
import com.github.xKenKOfficial.Msg.Commands.SocialSpyCommand;
import com.github.xKenKOfficial.Msg.Listeners.PlayerJoin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
    private static Main plugin;

    public void onEnable()
    {
        (plugin) = this;
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    public void onDisable()
    {
        this.saveDefaultConfig();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    private void registerCommands()
    {
        this.getLogger().info("Ladowanie komend z pluginu: " + this.getName());
        this.getCommand("msg").setExecutor(new MsgCommand());
        this.getCommand("socialspy").setExecutor(new SocialSpyCommand());
    }

    private void registerListeners()
    {
        this.getLogger().info("Ladowanie eventow z pluginu: " + this.getName());
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoin(), (Plugin)this);
    }

    public static Main getPlugin()
    {
        return plugin;
    }
}
