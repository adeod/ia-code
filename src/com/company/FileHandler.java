package com.company;

import jdk.jshell.tool.JavaShellToolBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
//import java.util.Collections;

public class FileHandler {

    Sheet spriteSheet = new Sheet(31);

    //read one character out of file
    public static ArrayList<String> SimpleWholeFileRead() {
        ArrayList<String> listOfStrings = new ArrayList<>();
        try {
            FileReader fr = new FileReader("details.txt");
            // load data from file
            BufferedReader br = new BufferedReader(fr);
            // list that holds strings of a file

            //reading whole line
            String header = br.readLine();
            String line = br.readLine();//to read the first line

            //checks for the end of file and reads the whole file
            while (line != null) {
                listOfStrings.add(line);
                line = br.readLine();//reads line as string
            }

            br.close();//closes the buffer reader
            //return listOfStrings;

        } catch (IOException e) {  //catch exception and stored in e
            e.printStackTrace(); //print error message
            System.out.println(e);
        }

        //returns it so we can pass it as arguments to other methods
        return listOfStrings;

    }

    public static void printFile(ArrayList<String> listOfStrings) {
        //prints each item one each line after its sorted
        for (String item : listOfStrings) {
            System.out.println(item);
        }
    }

    //TODO: take sheet and save as png or save coordinates so it can be altercated

    public void saveCoordinates(Sheet someSheet, String fileName) {
        try (
                RandomAccessFile rs = new RandomAccessFile(fileName, "rws");
        ) {
            for (int i = 0; i < someSheet.width; i++) {
                for (int j = 0; j < someSheet.width; j++) {
                    rs.writeBytes("(");
                    rs.write(someSheet.pixelSheet[i][j].getRValue());
                    rs.writeBytes(",");
                    rs.write(someSheet.pixelSheet[i][j].getGValue());
                    rs.writeBytes(",");
                    rs.write(someSheet.pixelSheet[i][j].getBValue());
                    rs.writeBytes(");");
                }
            }
        } catch (IOException e) {
            //suggest to make a new pixel sheet
            JWindow suggestBox = new JWindow();
            suggestBox.setBounds(100, 100, 300, 300);
            JTextField suggestText = new JTextField("Would you like to make a new sprite sheet?");

        }
    }

    public void saveAsPng(String fileName) {
        try {

            BufferedImage image = new BufferedImage(31, 31, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            spriteSheet.paint(graphics2D);
            ImageIO.write(image, "jpeg", new File("/home/deniz/Desktop/jmemPractice.jpeg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

      /* public void openSheetCoordinates(String filename){
        try(
                RandomAccessFile rf = new RandomAccessFile(filename, "rws")
                ) {
            rf.seek(0) ;
         } catch(IOException e) {
         e.printStackTrace();
        }*/
}   