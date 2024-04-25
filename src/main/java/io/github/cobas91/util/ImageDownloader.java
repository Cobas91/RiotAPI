package io.github.cobas91.util;

import io.github.cobas91.lol.LeagueOfLegendsUrl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class ImageDownloader {

    private static byte[] getByteArrayForImage(BufferedImage image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] downloadImage(URL url) {
        try {
            BufferedImage bufferedImage = ImageIO.read(url);
            return getByteArrayForImage(bufferedImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
