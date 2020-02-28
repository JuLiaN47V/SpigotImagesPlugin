package de.rrze.mcplugin.rrzerundgang.createimagemap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class CreateURLMap {
    ItemStack item;
    List<ItemStack> itemlist;

    public CreateURLMap(String url, Player player) throws IOException {
        player.sendMessage(url);
        player.sendMessage("Switch2");
        if (url.contains(".gif")){
            player.sendMessage("Switch3");
            getMapItemList(url, player);
        }
        player.sendMessage("No gif");
        getMapItem(url, player);
    }

    private List<ItemStack> getMapItemList(String url, Player player) throws IOException {
        player.sendMessage("Switch4");
        List<Image> image = new ImageConv().GifUrlConvert(url, player);
        Iterator iterator = image.iterator();
        player.sendMessage("getMapItemList");
        MapView map = Bukkit.createMap(player.getWorld());
        map.setScale(MapView.Scale.FARTHEST);
        item = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta meta = (MapMeta) item.getItemMeta();

        while (iterator.hasNext()){
            map.getRenderers().clear();
            MapRenderer renderTest = new MyRenderer(iterator.next());
            map.addRenderer(renderTest);
            meta.setMapView(map);
            item.setItemMeta(meta);

            itemlist.add(item);
        }
        return itemlist;
    }



    private ItemStack getMapItem(String url, Player player) {
        MapView map = Bukkit.createMap(player.getWorld());
        map.getRenderers().clear();
        map.setScale(MapView.Scale.FARTHEST);
        MapRenderer renderTest = new MyRenderer(url);
        map.addRenderer(renderTest);

        item = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta meta = (MapMeta) item.getItemMeta();
        meta.setDisplayName("Wendler it yn");
        meta.setMapView(map);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getItem(){
        return item;
    }

    public List<ItemStack> getItemList(){
        return itemlist;
    }

}
