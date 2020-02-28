package de.rrze.mcplugin.rrzerundgang.createimagemap;
import org.bukkit.entity.Player;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;


public class ImageConv {
        Image ImageURLConvert(String surl) {
            URL url = null;

            try {
            url = new URL(surl);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
            BufferedImage image = null;

            try {
                image = ImageIO.read(url);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return (Image) image.getScaledInstance(128,128, Image.SCALE_SMOOTH);
    }

    List<Image> GifUrlConvert(String gurl, Player player) throws IOException {
        player.sendMessage("Convert0");


        player.sendMessage("Convert1");


        ImageInputStream in = ImageIO.createImageInputStream(new File("gif.gif"));

        Iterator<ImageReader> reader = ImageIO.getImageReaders(in);

        player.sendMessage("Convert2");

        while (reader.hasNext()){
            Image test = reader.next().;
        }

        player.sendMessage("Convert3");

        List<Image> imagelist = null;

        player.sendMessage("Convert4");



            return imagelist;
    }
}
