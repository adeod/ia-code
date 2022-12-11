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
    JButton save;
    JButton save1;
    JButton erase;
    JButton openEx;
    Color colors[] = {Color.WHITE, Color.BLACK, Color.blue, Color.MAGENTA, Color.green, Color.orange};
    //String colorName[] = {"wht","blc","blu","mag","grn", "org"};
    JFrame spriteFrame;
    String tempCol;
    int pos;

    public Sheet(int width) {
        super();
        pos = 0;
        this.width = width;
        //sheet constructor is initialised as a 2d array with width and length that can be altered
        pixelSheet = new Pixel[16][16];
        //creating JFrame
        spriteFrame = new JFrame("Sprite Sheet");
        //add sheet object to GUI
        spriteFrame.setSize(800, 578);
        spriteFrame.setLayout(null);
        save = new JButton("save");
        save1 = new JButton("save as PNG");
        erase = new JButton("erase");
        openEx = new JButton("Open Existing...");
        save.setBackground(Color.gray);
        save.setForeground(Color.white);
        save1.setBackground(Color.gray);
        save1.setForeground(Color.white);
        erase.setBackground(Color.gray);
        erase.setForeground(Color.white);
        openEx.setForeground(Color.white);
        openEx.setBackground(Color.gray);
        spriteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spriteFrame.getContentPane().setBackground(Color.lightGray);


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


        save.setBounds(527, 200, 150, 80);
        save.addActionListener(this::actionPerformed1);
        spriteFrame.add(save);
        save1.setBounds(527, 300, 150, 80);
        save1.addActionListener(this::actionPerformed1);
        spriteFrame.add(save1);
        erase.setBounds(527,400,150,80);
        erase.addActionListener(this::actionPerformed1);
        spriteFrame.add(erase);
        openEx.setBounds(527,100,150,80);
        openEx.addActionListener(this::actionPerformed1);
        spriteFrame.add(openEx);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int btnNum = Integer.parseInt(e.getActionCommand());
        int col = btnNum % 16;
        int row = btnNum / 16;
            pixelSheet[row][col].incColVal();
            pixelSheet[row][col].setBackground(colors[pixelSheet[row][col].getColVal()]);
            pixelSheet[row][col].setForeground(colors[pixelSheet[row][col].getColVal()]);
    }

    public void actionPerformed1(ActionEvent b) {
        if (b.getSource() == save) {
            saveSheet();
        }
        if (b.getSource() == save1) {
            saveAsPng();
        } if (b.getSource() == erase) {
            for (int i = 0; i < pixelSheet.length; i++) {
                for (int j = 0; j < pixelSheet.length; j++) {
                    pixelSheet[i][j].setBackground(Color.WHITE);
                    pixelSheet[i][j].setForeground(Color.WHITE);
                    pixelSheet[i][j].setColN(0);
                }
            }
        } if(b.getSource() == openEx){
            openSheetCoordinates("sprite.txt");
        }
    }


    public void saveSheet() {

        try (
                PrintWriter pw = new PrintWriter("sprite.txt");
        ) {
            for (int i = 0; i < pixelSheet.length; i++) {
                for (int j = 0; j < pixelSheet.length; j++) {
                   String tempColl = Integer.toString(pixelSheet[i][j].getColVal());
                   pw.write(tempColl);
                   pw.write("\n");
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

    public void openSheetCoordinates(String fileName) {
        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ) {
            for(int i = 0; i <pixelSheet.length; i++){
                for(int j=0; j<pixelSheet.length;j++){
                    rf.seek(pos);
                        tempCol = rf.readLine();
                        int newCol = Integer.parseInt(tempCol);
                        pixelSheet[i][j].setBackground(colors[newCol]);
                        pixelSheet[i][j].setForeground(colors[newCol]);
                        pixelSheet[i][j].setColN(newCol);
                        pos = pos +2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}