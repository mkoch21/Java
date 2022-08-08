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

        if (args.length != 2 || args[0].length()!= 1 || args[1].length() != 1) {
            System.err.println("Invalid input. Try [black symbol] [white symbol]");
            System.exit(-1);
        } else {
            whiteSymbol = args[0].charAt(0);
            blackSymbol = args[1].charAt(0);
        }

        BufferedImage image = null;

        try {
            image = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));
        } catch (IOException e) {
            System.out.println("File error");
            System.exit(-1);
        }

        Logic.drawPicture(image, whiteSymbol, blackSymbol);
    }

}
