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
    Color colors[] = {Color.BLACK, Color.blue, Color.red, Color.green };

    public Sheet(int width){
        super();
        this.width = width;
        //sheet constructor is initialised as a 2d array with width and length that can be altered
        pixelSheet = new Pixel[16][16];
        //creating JFrame
        JFrame f = new JFrame( "Sprite Sheet");
        //add sheet object to GUI
        f.setSize(578, 578);
       f.setLayout(null);
        //make frame visible by setting to true
        f.setVisible(true);
        int k = 0 ;
        for(int i=0; i < pixelSheet.length; i++){
            for(int j=0; j< pixelSheet.length; j++){
                Pixel pBtn = new Pixel('n');
                pBtn.setBounds(i*width , j*width, width, width);
                pBtn.addActionListener(this::actionPerformed);
                pBtn.setText(Integer.toString(k));
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
        int count =0;
        int btnNum = Integer.parseInt(e.getActionCommand());
        int col = btnNum % 16;
        int row = btnNum/ 16;
        System.out.println(col + ", " + row);
        if(e.getSource() == pixelSheet[row][col]){
            pixelSheet[row][col].setBackground(colors[count]);
            count++;
            if(count == 3 ){
                //reset count value to 0
                count = 0;
            }
        }


        /* if(e.getSource() == black){
        } else if(e.getSource() == green){
            pixelSheet[row][col].setBackground(Color.GREEN);
        }else if(e.getSource() == blue){
            pixelSheet[row][col].setBackground(Color.BLUE);
        }else if(e.getSource() == red){
            pixelSheet[row][col].setBackground(Color.RED);
        } else if (e.getSource() == save){
        fH.saveAsPng("pixelSheet");
        }
*/
        fH.createHistory(row,col,pixelSheet);
    }




}
