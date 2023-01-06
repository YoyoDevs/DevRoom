package me.iiyoyo.greetme;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Check the command name and return the appropriate tab completion suggestions
        if (command.getName().equals("greetme")) {
            return Arrays.asList("reload","help");
        } else {
            return Collections.emptyList();
        }
    }
}
