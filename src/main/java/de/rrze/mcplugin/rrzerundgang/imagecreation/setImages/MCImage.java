package de.rrze.mcplugin.rrzerundgang.imagecreation.setImages;

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

    protected static int getStartBlockY(SimpleArea area){
        int startBlockY;
        if (area.getFirstblock().getY() < area.getSecondblock().getY()){
            startBlockY = area.getSecondblock().getY();
        } else {
            startBlockY = area.getFirstblock().getY();
        }
        return startBlockY;
    }

    protected static int getStartBlockZEast(SimpleArea area){
        int startBlockZ;

        if (area.getFirstblock().getZ() > area.getSecondblock().getZ()) {
            startBlockZ = area.getFirstblock().getZ();
        } else {
            startBlockZ = area.getSecondblock().getZ();
        }
        return startBlockZ;
    }

    protected static int getStartBlockZWest(SimpleArea area){
        int startBlockZ;

        if (area.getFirstblock().getZ() > area.getSecondblock().getZ()) {
            startBlockZ = area.getSecondblock().getZ();
        } else {
            startBlockZ = area.getFirstblock().getZ();
        }
        return startBlockZ;
    }

    protected static int getStartBlockXNorth(SimpleArea area){
        int startBlockX;


        if (area.getFirstblock().getX() > area.getSecondblock().getX()) {
            startBlockX = area.getFirstblock().getX();
        } else {
            startBlockX = area.getSecondblock().getX();
        }
        return startBlockX;
    }

    protected static int getStartBlockXSouth(SimpleArea area){
        int startBlockX;


        if (area.getFirstblock().getX() > area.getSecondblock().getX()) {
            startBlockX = area.getSecondblock().getX();
        } else {
            startBlockX = area.getFirstblock().getX();
        }
        return startBlockX;
    }

    protected static void setFramesEast(World world, List<ItemStack> list, int startBlockZ, int startBlockY, int startBlockX, SimpleArea area, BlockFace blockFace) throws InvalidBlockArea {
        int countery = 0;
        int counterx;
        int n = 0;
        int defaultStartBlockZ;
        int x = area.getArea().get(0);
        int y = area.getArea().get(1);


        defaultStartBlockZ = startBlockZ;


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
    }

    protected static void setFramesWest(World world, List<ItemStack> list, int startBlockZ, int startBlockY, int startBlockX, SimpleArea area, BlockFace blockFace) throws InvalidBlockArea {
        int countery = 0;
        int counterx;
        int n = 0;
        int defaultStartBlockZ;
        int x = area.getArea().get(0);
        int y = area.getArea().get(1);


        defaultStartBlockZ = startBlockZ;


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
                startBlockZ++;
            }
            startBlockY--;
            countery++;

        }
    }


}
