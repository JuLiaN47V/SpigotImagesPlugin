package de.rrze.mcplugin.rrzerundgang.imagecreation;

import de.rrze.mcplugin.rrzerundgang.createimagemap.MyRenderer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapItems {
    public static List<ItemStack> getMaps(List<BufferedImage> list, Player player){
        List<ItemStack> itemList = new ArrayList<>();
        ItemStack item;

        Iterator listiterator = list.iterator();

        while (listiterator.hasNext()){

            MapView map = Bukkit.createMap(player.getWorld());
            map.getRenderers().clear();
            map.setScale(MapView.Scale.FARTHEST);

            MapRenderer renderTest = new MyRenderer(listiterator.next());

            map.addRenderer(renderTest);

            item = new ItemStack(Material.FILLED_MAP, 1);
            MapMeta meta = (MapMeta) item.getItemMeta();
            meta.setMapView(map);
            item.setItemMeta(meta);
            itemList.add(item);
        }

        return itemList;
    }
}
