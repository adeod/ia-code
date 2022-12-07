package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class Sheet extends JPanel implements ActionListener {
    //width for sheet
    int width;
    Pixel pixelSheet[][];
    String pixelFile;
    JButton save;
    JButton save1;
    Color colors[] = {Color.WHITE, Color.BLACK, Color.blue, Color.red, Color.green};
    String colorName[] = {"white", "black", "blue", "red", "green"};
    int colorCount;
    JFileChooser fileChoice;
    JFrame spriteFrame;


    public Sheet(int width) {
        super();
        colorCount = 0;
        this.width = width;
        //sheet constructor is initialised as a 2d array with width and length that can be altered
        pixelSheet = new Pixel[16][16];
        //creating JFrame
        spriteFrame = new JFrame("Sprite Sheet");
        //add sheet object to GUI
        spriteFrame.setSize(578, 578);
        spriteFrame.setLayout(null);
        save = new JButton("save");
        save1 = new JButton("save as PNG");
        spriteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //make frame visible by setting to true
        spriteFrame.setVisible(true);
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
                spriteFrame.add(pBtn);
                k++;
            }
        }


        save.setBounds(527, 200, 100, 100);
        save.addActionListener(this::actionPerformed1);
        spriteFrame.add(save);
        save1.setBounds(527, 300, 100, 100);
        save1.addActionListener(this::actionPerformed1);
        spriteFrame.add(save1);


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

    public void actionPerformed1(ActionEvent b) {
        if (b.getSource() == save) {
            saveSheet();
        }
        if (b.getSource() == save1) {
            saveAsPng();
        }
    }


    public void saveSheet() {

        try (
                RandomAccessFile rf = new RandomAccessFile("sprite.txt", "rws");
        ) {
            for (int i = 0; i < pixelSheet.length; i++) {
                for (int j = 0; j < pixelSheet.length; j++) {
                    rf.writeBytes(colorName[pixelSheet[i][j].getColVal()]);
                    rf.writeBytes(",");
                    System.out.print(colorName[pixelSheet[i][j].getColVal()] + ",");
                }
            }

        } catch (IOException b) {
            JWindow suggestBox = new JWindow();
            suggestBox.setBounds(100, 100, 300, 300);
            JTextField suggestText = new JTextField("Would you like to make a new sprite sheet?");
        }
    }

    public void saveAsPng(){
        //client wants in a specific area --> develop to other
        try { 
            BufferedImage spriteImage = new BufferedImage(16*width, 17*width,BufferedImage.TYPE_INT_RGB);
            Graphics2D g1 = spriteImage.createGraphics();
            spriteFrame.paint(g1);
            ImageIO.write(spriteImage,"png", new File("sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openSheetCoordinates(String filename) {
        try (
                RandomAccessFile rf = new RandomAccessFile(filename, "rws")
        ) {
            for(int i = 0; i < 16; i++){
                if(i==0){

                }
                rf.seek(i);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}