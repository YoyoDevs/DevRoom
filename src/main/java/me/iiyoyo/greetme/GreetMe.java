package me.iiyoyo.greetme;

import me.clip.placeholderapi.PlaceholderAPI;
import me.iiyoyo.greetme.commands.commands;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import static me.iiyoyo.greetme.hexsupport.hex;

public class GreetMe extends JavaPlugin implements Listener {
    FileConfiguration config;
    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "GreetMe is enabled");
        getLogger().info(ChatColor.GREEN + "Free Palestine");
        getLogger().info(ChatColor.YELLOW + "Free ukraine");

        // Save default config values
        saveDefaultConfig();

        // Load the configuration file
        config = getConfig();

        // register the greetme command with the tabcompleter
        getCommand("greetme").setExecutor(new commands(this));
        getCommand("greetme").setTabCompleter(new TabCompleter());

        // Register event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the player
        Player player = event.getPlayer();

        // Create a firework
        Firework firework = (Firework)
        player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);

        // Getting the metadata of the firework (the infos of it to be able to customize it)
        FireworkMeta meta = firework.getFireworkMeta();

        // setting the firework meta effects
        meta.addEffect(FireworkEffect.builder()
                .flicker(true)
                .trail(true)
                .withColor(Color.ORANGE)
                .build());

        // Applying the meta to the firework
        firework.setFireworkMeta(meta);

        // Get the greeting-message config option as a string (not a broadcast)
        String greeting = hex(config.getString("greeting-message"));

        // revise it to support placeholderapi
        String reversedgreeting = PlaceholderAPI.setPlaceholders(player, greeting);

        // Send the greeting message to the player
        event.getPlayer().sendMessage(reversedgreeting);

        // creating a string for a greeting broadcast message
        String greetingbroadcast = hex(config.getString("greeting-broadcast"));

        // revised string of greetingbroadcast
         String revisedgreetingbroadcast = PlaceholderAPI.setPlaceholders(player, greetingbroadcast);

        // make the greetingbroadcast work as a real broadcast
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(player)) {
                onlinePlayer.sendMessage(revisedgreetingbroadcast);
            }
        }

        // disable the joining message
        event.setJoinMessage(null);
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        //get the player
        Player player = event.getPlayer();

        //creating a string for leaving message
        String leaving = hex(config.getString("leaving-message"));

        //resolving the leaving message to support placeholderAPI
        String resolvedleaving = PlaceholderAPI.setPlaceholders(player, leaving);

        //sending the leaving message string we made earlier
        Bukkit.broadcastMessage(resolvedleaving);


        // disable the leaving minecraft message
        event.setQuitMessage(null);
    }

    public void reload(){
       // reload the config of the plugin
        reloadConfig();

    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "GreetMe is disabled!");
        getLogger().info(ChatColor.GREEN + "Free Palestine");
        getLogger().info(ChatColor.YELLOW + "Free ukraine");

    }
}