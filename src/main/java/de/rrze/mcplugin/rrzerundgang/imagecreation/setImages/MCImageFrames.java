package de.rrze.mcplugin.rrzerundgang.imagecreation.setImages;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MCImageFrames{
    public static void setMaps(World world, List<ItemStack> list, SimpleArea area, BlockFace blockFace, Player player) throws InvalidBlockArea {

        if (blockFace.equals(BlockFace.EAST)) {
            MCImageEast.setFrames(world, list, area, blockFace, player);
        } else if (blockFace.equals(BlockFace.WEST)){
            MCImageWest.setFrames(world, list, area, blockFace, player);
        } else if (blockFace.equals(BlockFace.NORTH)){
            MCImageNorth.setFrames(world, list, area, blockFace, player);
        } else if (blockFace.equals(blockFace.SOUTH)){
            MCImageSouth.setFrames(world, list, area, blockFace, player);
        }

    }
}
