package de.rrze.mcplugin.rrzerundgang.createimagemap;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageReaderSpi;
import org.bukkit.entity.Player;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
        List<Image> imagelist = null;
        player.sendMessage("Convert1");

        URLConnection openConnection = new URL("https://www.123gif.de/gifs/geburtstag/geburtstag-herzkerze-0249.gif").openConnection();

        player.sendMessage("Convert3");

        openConnection.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");

        player.sendMessage("Convert4");

        InputStream input = openConnection.getInputStream();
        player.sendMessage("Convert5");
        BufferedInputStream in = new BufferedInputStream(input);
        player.sendMessage("Convert6");
        ImageInputStream stream = ImageIO.createImageInputStream(in);
        player.sendMessage("Convert7");
        Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
        player.sendMessage("Convert8");

        while (readers.hasNext()){
            player.sendMessage("Convert9");
            ImageReader reader = (ImageReader) readers.next();
            player.sendMessage("Convert10");
            reader.setInput(stream);
            player.sendMessage("Convert11");
            BufferedImage bufferedimage = reader.read(0);
            player.sendMessage("Convert12");
            imagelist.add((Image) bufferedimage);
            player.sendMessage("Convert13");
        }

        player.sendMessage("Convert33");





            return imagelist;
    }

    public ArrayList<BufferedImage> getFrames(Player player) throws IOException {
            File gif = new File("gif.gif");
            ArrayList<BufferedImage> frames = new ArrayList<>();
            player.sendMessage("31");
            BufferedImage master = new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB);
            player.sendMessage("32");

            ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
            player.sendMessage("33");
            ir.setInput(ImageIO.createImageInputStream(gif));
            player.sendMessage("34");
            for (int i = 0; i < ir.getNumImages(true); i++) {
                player.sendMessage("35");
                frames.add(new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB));
                player.sendMessage("36");
                master.getGraphics().drawImage(ir.read(i), 0, 0, null);
                player.sendMessage("37");
                frames.get(i).setData(master.getData());
                player.sendMessage("38");
            }
            return frames;
    }
}
