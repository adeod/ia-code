package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sheet extends JPanel {
    //width for sheet
    int width;
    Pixel pixelSheet[][];
    // is an array of pixel objects where the user can
    // change
    Pixel pBtn;
    public Sheet(int width){
        super();
        this.width = width;
        //sheet constructor is initialised as a 2d array with width and length that can be altered
        pixelSheet = new Pixel[16][16];
        //creating JFrame
        JFrame f = new JFrame("New Sprite Sheet");
        //add sheet object to GUI
        f.setSize(width*pixelSheet.length, width*(pixelSheet.length+1));
        f.setLayout(null);
        //make frame visible by setting to true
        f.setVisible(true);


        for(int i=0; i < pixelSheet.length; i++){
            for(int j=0; j< pixelSheet.length; j++){
                pixelSheet[i][j] = pBtn;
                Pixel pBtn = new Pixel(0,0,0);
                pBtn.setBounds(i*width , j*width, width, width);
                //  pBtn.addActionListener(this::actionPerformed);
                f.add(pBtn);
            }
        }

    }



    public void clear(){
        for(int i=0; i < width; i++){
            for(int j=0; j < width; j++){
                pixelSheet[i][j].r = 0;
                pixelSheet[i][j].g = 0;
                pixelSheet[i][j].b = 0;
            }
        }
    }

    public void red(int x, int y){
        pixelSheet[x][y].r =255;
        pixelSheet[x][y].g =0;
        pixelSheet[x][y].b =0;

    }
    public void blue(int x, int y){
        Pixel blueCol = new Pixel(0,0,255);
        pixelSheet[x][y] = blueCol;
    }

    public void white(int x, int y){
        Pixel whiteCol = new Pixel(255,255,255);
        pixelSheet[x][y] = whiteCol;
    }
    public void black(int x, int y){
        Pixel blackCol = new Pixel(0,0,0);
        pixelSheet[x][y] = blackCol;
    }


    // displays the sheet object as initialised
    public void displaySheet(Sheet newSheet){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                System.out.print(pixelSheet[i][j]);
            }
            System.out.println();
        }
    }

}
