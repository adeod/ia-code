package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI  {

    JButton red;
    JButton green;
    JButton black;
    JButton clear;
    JButton saveAsPng;
    Sheet spriteSheet;

    JFrame jf = new JFrame();
    JButton thisButton = new JButton("check ur files");
    File f = new File("C:\\Users\\pc\\Documents\\Sprite Editor");
    JFileChooser jChoose = new JFileChooser("d:", FileSystemView.getFileSystemView());

    public GUI(){
         red = new JButton("red");
         green = new JButton("green");
         black = new JButton("black");
         clear = new JButton("clear");
         saveAsPng = new JButton("Save as png");
    }
    public void show() {
        JFrame guiFrame = new JFrame("Sprite Editor");
        guiFrame.setSize(248, 312);
//red
        red.setBounds(0, 0, 200, 25);
        green.setBounds(0, 25, 200, 25);
        black.setBounds(0, 50, 200, 25);
        clear.setBounds(0, 75, 200, 25);
        saveAsPng.setBounds(0, 100, 200, 25);
        thisButton.setBounds(0,125,100,100);


        guiFrame.add(red);
        guiFrame.add(black);
        guiFrame.add(green);
        guiFrame.add(clear);
        guiFrame.add(saveAsPng);
        guiFrame.add(spriteSheet);
        guiFrame.add(thisButton);
        //content.add(controls, BorderLayout.SOUTH);


        guiFrame.setLayout(null);
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setVisible(true);

    }


}
