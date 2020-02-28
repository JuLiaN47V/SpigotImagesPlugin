package de.rrze.mcplugin.rrzerundgang;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;



import java.util.List;


public class MyListener implements Listener {
    @EventHandler
    public void onClick(SignChangeEvent event) {
        if (event.getLine(0).equals("<RRZE>")){
            event.getPlayer().sendMessage("Ok, cool");
        }

    }
}

