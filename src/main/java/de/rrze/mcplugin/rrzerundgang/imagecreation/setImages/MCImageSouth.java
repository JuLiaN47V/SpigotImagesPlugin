package de.rrze.mcplugin.rrzerundgang.imagecreation.setImages;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MCImageSouth extends MCImage {
    public static void setFrames(World world, List<ItemStack> list, SimpleArea area, BlockFace blockFace, Player player) throws InvalidBlockArea {
        int startBlockX;
        int startBlockZ;
        int startBlockY;

        startBlockZ = area.getFirstblock().getZ();
        startBlockZ++;

        startBlockX = getStartBlockXSouth(area);

        startBlockY = getStartBlockY(area);

        setFramesSouth(world, list ,startBlockZ, startBlockY, startBlockX, area, blockFace);


    }
}
