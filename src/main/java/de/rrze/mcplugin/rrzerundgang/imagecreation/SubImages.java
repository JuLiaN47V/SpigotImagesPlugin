package de.rrze.mcplugin.rrzerundgang.imagecreation;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SubImages {
    public static List<BufferedImage> getList(URL link, SimpleArea area) throws InvalidBlockArea {
        List<BufferedImage> list = new ArrayList<BufferedImage>();
        BufferedImage image = null;
        int imageHeight = 0;
        int imageWidth = 0;
        int xsubimage = 0;
        int ysubimage = 0;

        try {
            image = ImageIO.read(link);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        imageHeight = image.getHeight();
        imageWidth = image.getWidth();

        xsubimage = imageHeight / area.getArea().get(0);
        ysubimage = imageWidth / area.getArea().get(1);

        int counterx = 0;
        int countery = 0;
        int counterxstart = 0;
        int counterystart = 0;

        while (counterx < area.getArea().get(1)){
            while (countery < area.getArea().get(0)){
                list.add(image.getSubimage(counterxstart, counterystart, ysubimage, xsubimage));
                counterxstart = counterxstart + xsubimage;
                countery++;
            }
            counterystart = counterystart + ysubimage;
            counterx++;
        }



        return list;
    }
}
