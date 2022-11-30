package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI implements ActionListener {

    JButton red = new JButton("red");
    JButton green = new JButton("green");
    JButton black = new JButton("black");
    JButton clear = new JButton("clear");
    JButton saveAsPng = new JButton("Save as png");
    Sheet spriteSheet = new Sheet(31);

    JFrame jf = new JFrame();
    JButton thisButton = new JButton("check ur files");
    File f = new File("C:\\Users\\pc\\Documents\\Sprite Editor");
    JFileChooser jChoose = new JFileChooser("d:", FileSystemView.getFileSystemView());

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

        red.addActionListener(this);
        green.addActionListener(this);
        black.addActionListener(this);
        saveAsPng.addActionListener(this);


        guiFrame.setLayout(null);
        guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        guiFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        //change button background color
        red.setBackground(Color.RED);
        //change button text color
        red.setForeground(Color.RED);
        if(e.getSource() == thisButton){
            jChoose.showSaveDialog(null);
        }
    }

}
