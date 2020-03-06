package de.rrze.mcplugin.rrzerundgang.imagecreation;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MCImage {


    public static void setMaps(World world, List<ItemStack> list, SimpleArea area, BlockFace blockFace, Player player) throws InvalidBlockArea {

        int x = area.getArea().get(0);
        int y = area.getArea().get(1);
        int startBlockX = area.getFirstblock().getX();
        int startBlockY = area.getFirstblock().getY();
        int startBlockZ = area.getFirstblock().getZ();
        int defaultStartBlockZ = 0;

        if (blockFace.equals(BlockFace.WEST)){
            startBlockX--;
        } else if (blockFace.equals(BlockFace.EAST)){
            startBlockX++;
            if (area.getFirstblock().getZ() > area.getSecondblock().getZ()){
                startBlockZ = area.getFirstblock().getZ();
                defaultStartBlockZ = startBlockZ;
            } else {
                startBlockZ = area.getSecondblock().getZ();
                defaultStartBlockZ = startBlockZ;
            }

            if (area.getFirstblock().getY() < area.getSecondblock().getY()){
                startBlockY = area.getSecondblock().getY();
            } else {
                startBlockY = area.getFirstblock().getY();
            }
        } else if (blockFace.equals(BlockFace.SOUTH)){
            startBlockZ++;
        }else if (blockFace.equals(BlockFace.NORTH)){
            startBlockZ--;
        }


        int countery = 0;
        int counterx = 0;
        int n = 0;

        if (blockFace.equals(BlockFace.EAST) || blockFace.equals(BlockFace.WEST)) {
            while (countery < y) {
                counterx = 0;
                startBlockZ = defaultStartBlockZ;
                while (counterx < x) {


                    Location location = new Location(world, startBlockX, startBlockY, startBlockZ);

                    ItemFrame frame = world.spawn(location, ItemFrame.class);

                    frame.setFacingDirection(blockFace);

                    frame.setItem(list.get(n));
                    n++;

                    counterx++;
                    startBlockZ--;
                }
                startBlockY--;
                countery++;
            }
        } else {
            while (countery < y) {
                counterx = 0;
                while (counterx < x) {
                    Location location = new Location(world, startBlockX, startBlockY, startBlockZ);
                    ItemFrame frame = world.spawn(location, ItemFrame.class);
                    frame.setFacingDirection(blockFace);
                    frame.setItem(list.get(n));
                    n++;

                    startBlockX++;
                }

                startBlockY++;
                countery++;
            }


        }
            player.sendMessage("list:" + list.size());
    }
}
