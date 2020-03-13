package de.rrze.mcplugin.rrzerundgang;

import org.bukkit.entity.Player;

import java.io.*;


public class ImageLinkFromFile {
    public static String getLink() throws IOException {
        RRZERundgang.getPlugin(RRZERundgang.class).reloadImageConfig();
        String link = RRZERundgang.getPlugin(RRZERundgang.class).getImageConfig().getString("link");

        return link;
    }
}
