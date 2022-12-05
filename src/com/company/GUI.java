package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI  {



    JFrame jf = new JFrame();
    JButton thisButton = new JButton("check ur files");
    File f = new File("C:\\Users\\pc\\Documents\\Sprite Editor");
    JFileChooser jChoose = new JFileChooser("d:", FileSystemView.getFileSystemView());

    public GUI(){

    }
    public void show() {
        JFrame guiFrame = new JFrame("Sprite Editor");
        guiFrame.setSize(248, 312);
//red

        thisButton.setBounds(0,125,100,100);



        guiFrame.add(thisButton);
        //content.add(controls, BorderLayout.SOUTH);


        guiFrame.setLayout(null);
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setVisible(true);

    }


}
