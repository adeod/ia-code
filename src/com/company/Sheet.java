package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Random;

public class Sheet extends JPanel implements ActionListener {
    //width for sheet
    int width;
    Pixel pixelSheet[][];
    String pixelFile;
    JButton save;
    Color colors[] = {Color.WHITE, Color.BLACK, Color.blue, Color.red, Color.green};
    String colorName[]= {"white", "black", "blue", "red", "green"};
    int colorCount;

    public Sheet(int width) {
        super();
        colorCount = 0;
        this.width = width;
        //sheet constructor is initialised as a 2d array with width and length that can be altered
        pixelSheet = new Pixel[16][16];
        //creating JFrame
        JFrame f = new JFrame("Sprite Sheet");
        //add sheet object to GUI
        f.setSize(578, 578);
        f.setLayout(null);
        JButton save = new JButton("save");

        //make frame visible by setting to true
        f.setVisible(true);
        int k = 0;
        for (int i = 0; i < pixelSheet.length; i++) {
            for (int j = 0; j < pixelSheet.length; j++) {
                Pixel pBtn = new Pixel(0);
                pBtn.setBounds(i * width, j * width, width, width);
                pBtn.addActionListener(this::actionPerformed);
                pBtn.setText(Integer.toString(k));
                pBtn.setBackground(Color.WHITE);
                pBtn.setForeground(Color.WHITE);
                pixelSheet[i][j] = pBtn;
                f.add(pBtn);
                k++;
            }
        }


        save.setBounds(527,200,100,100);
        save.addActionListener(this::actionPerformed);
        f.add(save);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        while(e.getSource() != save){
        int btnNum = Integer.parseInt(e.getActionCommand());
        int col = btnNum % 16;
        int row = btnNum / 16;
        System.out.println(col + ", " + row);
        if (e.getSource() == pixelSheet[row][col]) {
            pixelSheet[row][col].incColVal();
            pixelSheet[row][col].setBackground(colors[pixelSheet[row][col].getColVal()]);
            pixelSheet[row][col].setForeground(colors[pixelSheet[row][col].getColVal()]);
        }  else {
                System.out.print("not");
            }
        }
        if(e.getSource() == save){
            saveSheet();
        }
    }


    public void saveSheet () {

        try (
                RandomAccessFile rf = new RandomAccessFile("sprite.txt", "rws");
        ) {
            for( int i =0; i < pixelSheet.length;i++){
                for(int j =0; j< pixelSheet.length; j++){
                    rf.writeBytes(colorName[pixelSheet[i][j].getColVal()]);
                    rf.writeBytes(" , ");
                    System.out.print(colorName[pixelSheet[i][j].getColVal()] +" , ");
                }
            }

        } catch (IOException b) {
            JWindow suggestBox = new JWindow();
            suggestBox.setBounds(100, 100, 300, 300);
            JTextField suggestText = new JTextField("Would you like to make a new sprite sheet?");
        }
    }
}

