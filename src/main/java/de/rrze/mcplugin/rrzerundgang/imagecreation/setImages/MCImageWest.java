package de.rrze.mcplugin.rrzerundgang.imagecreation.setImages;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MCImageWest extends MCImage {
    public static void setFrames(World world, List<ItemStack> list, SimpleArea area, BlockFace blockFace, Player player) throws InvalidBlockArea {
        int startBlockX;
        int startBlockZ;
        int startBlockY;

        startBlockX = area.getFirstblock().getX();
        startBlockX--;

        startBlockZ = getStartBlockZWest(area);

        startBlockY = getStartBlockY(area);

        setFramesWest(world, list ,startBlockZ, startBlockY, startBlockX, area, blockFace);


    }
}
