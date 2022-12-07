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


    public void createHistory(int row, int col, Pixel pixelSheet[][]){
        try(
                PrintWriter printWriter = new PrintWriter("historySheet.txt", String.valueOf(true));
        ){
            printWriter.write(col + "," + row);
            printWriter.write(pixelSheet[row][col].getColVal());
        } catch (IOException v){
            v.printStackTrace();
        }
    }
}