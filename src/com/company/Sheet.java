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
    FileHandler fH = new FileHandler();
    JButton history;
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

        /*red.setBounds(527,700,50,50);
        red.addActionListener(this::actionPerformed);
        red.setBackground(Color.red);
        red.setVisible(true);
        green.setBounds(527,50,50,50);
        green.setBackground(Color.green);
        green.addActionListener(this::actionPerformed);
        green.setVisible(true);
        blue.setBounds(527,100,50,50);
        blue.setBackground(Color.BLUE);
        blue.addActionListener(this::actionPerformed);
        blue.setVisible(true);
        black.setBounds(527,150,50,50);
        black.setBackground(Color.BLACK);
        black.addActionListener(this::actionPerformed);
        black.setVisible(true);
        save.setBounds(527,200,50,50);
        save.addActionListener(this::actionPerformed);
        f.add(red);
        f.add(green);
        f.add(blue);
        f.add(black);
        f.add(save); */


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        int btnNum = Integer.parseInt(e.getActionCommand());
        int col = btnNum % 16;
        int row = btnNum / 16;
        System.out.println(col + ", " + row);
        if (e.getSource() == pixelSheet[row][col]) {
            pixelSheet[row][col].incColVal();
            pixelSheet[row][col].setBackground(colors[pixelSheet[row][col].getColVal()]);
            pixelSheet[row][col].setForeground(colors[pixelSheet[row][col].getColVal()]);
        } else {
            System.out.print("not");
        }


    }

    public void saveSheet () {

        try (
                RandomAccessFile rf = new RandomAccessFile("sprite.txt", "rws");
        ) {
            for( int i =0; i < pixelSheet.length;i++){
                for(int j =0; j< pixelSheet.length; j++){
                    rf.writeChars(colorName[pixelSheet[i][j].getColVal()]);
                    rf.writeChars(" , ");
                    System.out.print(colorName[pixelSheet[i][j].getColVal()]);
                }
            }

        } catch (IOException b) {
            b.printStackTrace();
        }
    }
}

