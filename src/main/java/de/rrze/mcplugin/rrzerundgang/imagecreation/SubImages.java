package de.rrze.mcplugin.rrzerundgang.imagecreation;

import de.rrze.mcplugin.rrzerundgang.SimpleArea;
import de.rrze.mcplugin.rrzerundgang.createimagemap.InvalidBlockArea;
import org.bukkit.entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SubImages {
    public static List<BufferedImage> getList(URL link, SimpleArea area, Player player) throws InvalidBlockArea {
        List<BufferedImage> list = new ArrayList<>();
        BufferedImage image = null;
        BufferedImage subimage = null;
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


        xsubimage = imageWidth / area.getArea().get(0);
        ysubimage = imageHeight / area.getArea().get(1);



        int counterx;
        int countery = 0;
        int counterxstart;
        int counterystart = 0;
        boolean preserveAlpha = false;

        while (countery < area.getArea().get(1)){
            player.sendMessage("Ha");
            counterx = 0;
            counterxstart = 0;
            while (counterx < area.getArea().get(0)){
                player.sendMessage("x");
                subimage = image.getSubimage(counterxstart, counterystart, xsubimage, ysubimage);
                int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
                BufferedImage scaledBI = new BufferedImage(128,128, imageType);
                Graphics2D g = scaledBI.createGraphics();
                if (preserveAlpha) {
                    g.setComposite(AlphaComposite.Src);
                }
                g.drawImage(subimage, 0, 0, 128, 128, null);
                g.dispose();

                list.add(scaledBI);
                counterxstart = counterxstart + xsubimage;
                counterx++;
            }
            counterystart = counterystart + ysubimage;
            countery++;
        }


        return list;
    }
}
