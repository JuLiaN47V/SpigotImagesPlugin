package de.rrze.mcplugin.rrzerundgang;

import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SimpleArea {
    private SimpleBlock firstblock;
    private SimpleBlock secondblock;
    private Player player;


    public SimpleArea(SimpleBlock firstblock, SimpleBlock secondblock, Player player){
        this.firstblock = firstblock;
        this.secondblock = secondblock;
        this.player = player;
    }

    public List<Integer> getArea() throws InvalidBlockArea {
        int x = 0;
        int y = 0;

        player.sendMessage(firstblock.getBlockFace().toString());
        player.sendMessage(secondblock.getBlockFace().toString());

        if (firstblock.getBlockFace().equals(secondblock.getBlockFace())) {
            if (firstblock.getCoordinates().get(0) == secondblock.getCoordinates().get(0)) {
                if (firstblock.getCoordinates().get(2) > secondblock.getCoordinates().get(2)) {
                    x = firstblock.getCoordinates().get(2) - secondblock.getCoordinates().get(2);
                } else {
                    x = secondblock.getCoordinates().get(2) - firstblock.getCoordinates().get(2);
                }
            } else if (firstblock.getCoordinates().get(2) == secondblock.getCoordinates().get(2)) {
                if (firstblock.getCoordinates().get(0) > secondblock.getCoordinates().get(0)) {
                    x = firstblock.getCoordinates().get(0) - secondblock.getCoordinates().get(0);
                } else {
                    x = secondblock.getCoordinates().get(0) - firstblock.getCoordinates().get(0);
                }
            } else {
                throw new InvalidBlockArea("Not on same level");
            }

            if (firstblock.getCoordinates().get(1) > secondblock.getCoordinates().get(1)) {
                y = firstblock.getCoordinates().get(1) - secondblock.getCoordinates().get(1) + 1;
            } else if (secondblock.getCoordinates().get(1) > firstblock.getCoordinates().get(1)) {
                y = secondblock.getCoordinates().get(1) - firstblock.getCoordinates().get(1) + 1;
            } else {
                y = 1;
            }
        } else {
            throw new InvalidBlockArea("Not the same side");
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(x);
        list.add(y);

        return list;
    }
}
