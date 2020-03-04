package de.rrze.mcplugin.rrzerundgang;

import org.bukkit.block.BlockFace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SimpleBlock implements Callable {

    public int x = 0;
    private int y = -2;
    private int z = 0;
    private boolean stauts = false;
    private BlockFace blockFace;

    public void setBlockFace(BlockFace blockFace){
        this.blockFace = blockFace;
    }

    public BlockFace getBlockFace(){
        return this.blockFace;
    }

    public void clear(){
        this.x = 0;
        this.y = -2;
        this.z = 0;
        this.stauts = false;
        return;
    }

    public void setCoordinates(int xc, int yc, int zc){
        this.x = xc;
        this.y = yc;
        this.z = zc;
        this.stauts=true;
    }

    public List<Integer> getCoordinates(){
        List <Integer> list = new ArrayList<Integer>();
        list.add(this.x);
        list.add(this.y);
        list.add(this.z);
        return list;
    }

    public boolean getStatus(){
        return this.stauts;
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
