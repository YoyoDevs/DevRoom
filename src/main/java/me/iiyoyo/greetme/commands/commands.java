package me.iiyoyo.greetme.commands;

import me.iiyoyo.greetme.GreetMe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;

import static me.iiyoyo.greetme.hexsupport.hex;
public class commands implements CommandExecutor {
    private final GreetMe plugin;

    public commands(GreetMe plugin){
        this.plugin= plugin;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("greetme")) {
            if (args[0].equalsIgnoreCase("help")) {
                if (sender.hasPermission("greetme.help")) {

                    // creating a helpmessage string with hex support
                    String helpmessage = hex("&#40fb36T&#42fb37h&#44fb38e&#46fb39s&#48fb3ae &#4afb3ba&#4dfb3cr&#4ffb3de &#51fb3ea&#53fb3fl&#55fb40l &#57fc41t&#59fc42h&#5bfc43e &#5dfc44c&#5ffc45u&#62fc46r&#64fc47r&#66fc48e&#68fc49n&#6afc4at &#6cfc4cc&#6efc4do&#70fc4em&#72fc4fm&#74fc50a&#76fc51n&#79fc52d&#7bfc53s &#7dfc54t&#7ffc55h&#81fc56a&#83fd57t &#85fd58y&#87fd59o&#89fd5au &#8bfd5bc&#8efd5ca&#90fd5dn &#92fd5eu&#94fd5fs&#96fd60e&#98fd61!\n");

                    // creating a reloadmessage string with hex support
                    String reloadmessage = hex("&#fbd222/&#fbd323g&#fbd424r&#fbd525e&#fad526e&#fad627t&#fad728m&#fad829e &#fad92ar&#fada2be&#fadb2cl&#f9db2do&#f9dc2ea&#f9dd2ed &#f9de2f|&#f9df30| &#f9e031T&#f9e132h&#f8e133i&#f8e234s &#f8e335c&#f8e436o&#f8e537m&#f8e638m&#f8e739a&#f8e83an&#f7e83bd &#f7e93cw&#f7ea3di&#f7eb3el&#f7ec3fl &#f7ed40r&#f7ee41e&#f6ee42l&#f6ef43o&#f6f044a&#f6f145d &#f6f246G&#f6f346r&#f6f447e&#f5f448e&#f5f549t&#f5f64aM&#f5f74be &#f5f84cp&#f5f94dl&#f5fa4eu&#f4fa4fg&#f4fb50i&#f4fc51n&#f4fd52!\n");

                    sender.sendMessage(helpmessage);
                    sender.sendMessage(reloadmessage);
                    return true;
                } else {
                    //creat a permission message
                    String permissionmsg = hex("&#fb0000Y&#fb0303o&#fb0707u &#fb0a0ad&#fb0d0do &#fc1111n&#fc1414o&#fc1818t &#fc1b1bh&#fc1e1ea&#fc2222v&#fc2525e &#fc2828p&#fc2c2ce&#fc2f2fr&#fd3333m&#fd3636i&#fd3939s&#fd3d3ds&#fd4040i&#fd3f40o&#fd3d41n &#fd3c41t&#fd3a41o &#fe3941u&#fe3742s&#fe3642e &#fe3542t&#fe3342h&#fe3243i&#fe3043s &#fe2f43c&#fe2e43o&#fe2c44m&#ff2b44m&#ff2944a&#ff2844n&#ff2645d&#ff2545.\n");
                    sender.sendMessage(permissionmsg);
                    return true;
                }

            }
            if (command.getName().equalsIgnoreCase("greetme")) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("greetme.reload")) {

                        //calling a pluginmanager method that was added by bukkit (because method plugin.reload didnt work ): )
                        PluginManager pluginManager = Bukkit.getPluginManager();

                        //disabling the plugin
                        pluginManager.disablePlugin(plugin);

                        //reloading config
                        plugin.reloadConfig();

                        //enabling plugin
                        pluginManager.enablePlugin(plugin);

                        // create a string for the reload message
                        String reloadmessage = hex("&#33fb1aG&#33fb1dr&#34fb1fe&#34fb22e&#35fb24t&#35fb27m&#35fb29e &#36fb2ch&#36fb2ea&#36fc31s &#37fc33b&#37fc36e&#38fc38e&#38fc3bn &#38fc3dr&#39fc40e&#39fc42l&#3afc45o&#3afc47a&#3afc4ad&#3bfc4ce&#3bfc4fd &#3bfc51s&#3cfc54u&#3cfc56c&#3dfc59c&#3dfd5be&#3dfd5es&#3efd60s&#3efd63f&#3efd65u&#3ffd68l&#3ffd6al&#40fd6dy&#40fd6f!\n");

                        //send message for a successful reload
                        sender.sendMessage(reloadmessage);
                        return true;
                    } else {
                        //creat a permission message
                        String permissionmsg = hex("&#fb0000Y&#fb0303o&#fb0707u &#fb0a0ad&#fb0d0do &#fc1111n&#fc1414o&#fc1818t &#fc1b1bh&#fc1e1ea&#fc2222v&#fc2525e &#fc2828p&#fc2c2ce&#fc2f2fr&#fd3333m&#fd3636i&#fd3939s&#fd3d3ds&#fd4040i&#fd3f40o&#fd3d41n &#fd3c41t&#fd3a41o &#fe3941u&#fe3742s&#fe3642e &#fe3542t&#fe3342h&#fe3243i&#fe3043s &#fe2f43c&#fe2e43o&#fe2c44m&#ff2b44m&#ff2944a&#ff2844n&#ff2645d&#ff2545.\n");
                        sender.sendMessage(permissionmsg);
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
