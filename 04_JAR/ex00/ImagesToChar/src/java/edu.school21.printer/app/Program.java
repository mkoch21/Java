package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        char whiteSymbol = 0;

        char blackSymbol = 0;

        String pathToImage = null;
        if (args.length != 3 || args[0].length()!= 1 || args[1].length() != 1) {
            System.err.println("Invalid input. Try [black symbol] [white symbol] [path to image]");
            System.exit(-1);
        } else {
            whiteSymbol = args[0].charAt(0);
            blackSymbol = args[1].charAt(0);
            pathToImage = args[2];
        }

        BufferedImage image = null;

        File file = new File(pathToImage);

        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("File error");
            System.exit(-1);
        }

        Logic.drawPicture(image, whiteSymbol, blackSymbol);
    }

}
