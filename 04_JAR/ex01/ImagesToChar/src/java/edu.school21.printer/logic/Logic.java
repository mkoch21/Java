package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Logic {

    public static void drawPicture (BufferedImage image, char whiteSymbol, char blackSymbol ) {

        char[][] charImage = new char[image.getHeight()][image.getWidth()];

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int color = image.getRGB(j, i);
                if (color == Color.BLACK.getRGB()) {
                    charImage[i][j] = blackSymbol;
                } else if (color == Color.WHITE.getRGB()) {
                    charImage[i][j] = whiteSymbol;
                } else {
                    System.err.println("Image is not black and white!");
                    System.exit(-1);
                }
            }
        }

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                System.out.print(charImage[i][j]);

            }
            System.out.println();
        }
    }

}
