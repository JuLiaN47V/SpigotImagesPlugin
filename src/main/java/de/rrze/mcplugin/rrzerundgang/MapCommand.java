package de.rrze.mcplugin.rrzerundgang;


import de.rrze.mcplugin.rrzerundgang.createimagemap.CreateURLMap;
import org.bukkit.Location;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.List;


public class MapCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //Create Item


            String url2 = "https://media.giphy.com/media/ZYWsYjcMCaYFB6IXqu/giphy.gif";
            List<ItemStack> map2 = null;
            try {
                map2 = new CreateURLMap(url2, player).getItemList();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //Set Frame

            Location location  = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
            ItemFrame frame = (ItemFrame) player.getWorld().spawn(location, ItemFrame.class);


            frame.setItem(map2.get(0));






            }
        return false;
    }
}

