package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.util.Random;

//TODO: add randomiser
public class Sheet extends JPanel implements ActionListener {
    //width for sheet
    int width;
    Pixel pixelSheet[][];
    JButton save;
    JButton save1;
    JButton erase;
    JButton openEx;
    JButton randomiser, backBtn;
    Color colors[] = {Color.WHITE, Color.BLACK, Color.blue, Color.MAGENTA, Color.green, Color.orange};
    JFrame spriteFrame;
    String tempCol;
    String spriteName;
    Random randCol;
    LaunchPage launchBack;

    public Sheet(int width) {
        super();
        randCol = new Random();
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
        openEx = new JButton("open existing...");
        randomiser = new JButton("randomise");
        backBtn = new JButton("<--");
        backBtn.setBackground(Color.gray);
        backBtn.setForeground(Color.white);
        save.setBackground(Color.gray);
        save.setForeground(Color.white);
        save1.setBackground(Color.gray);
        save1.setForeground(Color.white);
        erase.setBackground(Color.gray);
        erase.setForeground(Color.white);
        openEx.setForeground(Color.white);
        openEx.setBackground(Color.gray);
        randomiser.setForeground(Color.white);
        randomiser.setBackground(Color.gray);
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

        randomiser.setBounds(527, 100, 150, 40);
        randomiser.addActionListener(this::actionPerformed1);
        spriteFrame.add(randomiser);
        save.setBounds(527, 200, 150, 80);
        save.addActionListener(this::actionPerformed1);
        spriteFrame.add(save);
        save1.setBounds(527, 300, 150, 80);
        save1.addActionListener(this::actionPerformed1);
        spriteFrame.add(save1);
        erase.setBounds(527,400,150,80);
        erase.addActionListener(this::actionPerformed1);
        spriteFrame.add(erase);
        openEx.setBounds(527,140,150,40);
        openEx.addActionListener(this::actionPerformed1);
        spriteFrame.add(openEx);
        backBtn.setBounds(527,50,150,30);
        backBtn.addActionListener(this::actionPerformed1);
        spriteFrame.add(backBtn);

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
            spriteName = JOptionPane.showInputDialog(null);
            saveSheet(spriteName);
        }
        if (b.getSource() == save1) {
            spriteName = JOptionPane.showInputDialog(null);
            saveAsPng(spriteName);
        } if (b.getSource() == erase) {
            for (int i = 0; i < pixelSheet.length; i++) {
                for (int j = 0; j < pixelSheet.length; j++) {
                    pixelSheet[i][j].setBackground(Color.WHITE);
                    pixelSheet[i][j].setForeground(Color.WHITE);
                    pixelSheet[i][j].setColN(0);
                }
            }
        } if(b.getSource() == openEx){
            spriteName = JOptionPane.showInputDialog(null);
            openSheetCoordinates(spriteName);
        } if(b.getSource() == randomiser){
            for (int i=0; i< pixelSheet.length; i++){
                for(int j=0; j< pixelSheet.length; j++){
                    Color randomcolour = generateRandCol();
                    pixelSheet[i][j].setForeground(randomcolour);
                    pixelSheet[i][j].setBackground(randomcolour);
                }
            }
        } if(b.getSource() == backBtn){
            spriteFrame.dispose();
            launchBack = new LaunchPage();
        }
    }


    public void saveSheet(String fileName) {

        try (
                PrintWriter pw = new PrintWriter(fileName);
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

    public void saveAsPng(String pathName){
        //client wants in a specific area --> develop to other
        try { 
            BufferedImage spriteImage = new BufferedImage(16*width, 17*width,BufferedImage.TYPE_INT_RGB);
            Graphics2D g1 = spriteImage.createGraphics();
            spriteFrame.paint(g1);
            ImageIO.write(spriteImage,"png", new File(pathName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openSheetCoordinates(String fileName) {
        try (
                RandomAccessFile rf = new RandomAccessFile(fileName, "rws")
        ) {
            int pos = 0;
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

    public Color generateRandCol(){
        int random = 0;
        while(true){
            random = randCol.nextInt(6);
            if(random != 0){
                break;
            }
        }
        return colors[random];
    }
}