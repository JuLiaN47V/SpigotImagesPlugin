package de.rrze.mcplugin.rrzerundgang;

import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import de.rrze.mcplugin.rrzerundgang.imagecreation.setImages.MCImageFrames;
import de.rrze.mcplugin.rrzerundgang.imagecreation.MapItems;
import de.rrze.mcplugin.rrzerundgang.imagecreation.SubImages;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class MyListener implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent event) throws InvalidBlockArea, IOException {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();

        SimpleBlock firstSimpleBlock = new SimpleBlock();
        SimpleBlock secondSimpleBlock = new SimpleBlock();


        if (player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_AXE) && event.getHand() == EquipmentSlot.HAND) {

            if (!player.hasMetadata("firstBlock")){
                player.setMetadata("firstBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), firstSimpleBlock));
            } else {
                firstSimpleBlock = (SimpleBlock) player.getMetadata("firstBlock").get(0).value();
            }

            if (!player.hasMetadata("secondBlock")) {
                player.setMetadata("secondBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), secondSimpleBlock));
            } else {
                secondSimpleBlock = (SimpleBlock) player.getMetadata("secondBlock").get(0).value();
            }


            if (!firstSimpleBlock.getStatus() && !secondSimpleBlock.getStatus()){
                firstSimpleBlock.setCoordinates(block.getX(),block.getY(),block.getZ());
                firstSimpleBlock.setBlockFace(event.getBlockFace());
                player.setMetadata("firstBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), firstSimpleBlock));
                player.sendMessage("1th block set");

            } else if (firstSimpleBlock.getStatus() && !secondSimpleBlock.getStatus()){
                secondSimpleBlock.setCoordinates(block.getX(),block.getY(),block.getZ());
                secondSimpleBlock.setBlockFace(event.getBlockFace());
                player.setMetadata("secondBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), secondSimpleBlock));
                player.sendMessage("2th block set");
                SimpleArea area = new SimpleArea (firstSimpleBlock, secondSimpleBlock, player);

                String url = ImageLinkFromFile.getLink();

                player.sendMessage(RRZERundgang.getPlugin(RRZERundgang.class).getDataFolder().toString());

                URL link = new URL (url);

                List<BufferedImage> imagelist = SubImages.getList(link, area, player);

                List<ItemStack> maplist = MapItems.getMaps(imagelist, player);
                World world = player.getWorld();

                MCImageFrames.setMaps(world, maplist, area, event.getBlockFace(), player);

                try {
                    player.sendMessage(area.getArea().get(0) + "x" + area.getArea().get(1));
                } catch (InvalidBlockArea invalidBlockArea) {

                    firstSimpleBlock.clear();
                    player.setMetadata("firstBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), firstSimpleBlock));
                    secondSimpleBlock.clear();
                    player.setMetadata("secondBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), secondSimpleBlock));

                    player.sendMessage("Invalid Area");
                }

            } else if ( firstSimpleBlock.getStatus() && secondSimpleBlock.getStatus()){
                firstSimpleBlock.setCoordinates(block.getX(),block.getY(),block.getZ());
                firstSimpleBlock.setBlockFace(event.getBlockFace());

                player.setMetadata("firstBlock", new FixedMetadataValue(RRZERundgang.getPlugin(RRZERundgang.class), firstSimpleBlock));
                secondSimpleBlock.clear();
                player.sendMessage("1th block set");
            }
        }
    }

}
