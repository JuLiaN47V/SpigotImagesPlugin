package de.rrze.mcplugin.rrzerundgang.createimagemap;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.*;
import java.util.List;

public class MyRenderer extends MapRenderer {
    Object test;

    public MyRenderer(Object object){

        if (object instanceof Image) {
            test = object;
        }
    }

    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {
        canvas.drawImage(10, 10, (Image) test);
    }
}
