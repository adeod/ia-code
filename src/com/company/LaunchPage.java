package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener {

    JFrame startFrame = new JFrame();
    JButton startButton1 = new JButton("Open New...");
    JButton startButton2 = new JButton("Open Existing Sprite Sheet");
    Sheet mySheet;
    FileHandler fH = new FileHandler();

    public LaunchPage() {
        this.mySheet = mySheet;
        startButton1.setBounds(100, 160, 200, 40);
        startButton1.setFocusable(false);
        startButton1.addActionListener(this);
        startButton1.setVisible(true);
        startButton1.setBackground(Color.gray);
        startButton1.setForeground(Color.white);
        startFrame.add(startButton1);

        startButton2.setBounds(100, 240, 200, 40);
        startButton2.setFocusable(false);
        startButton2.addActionListener(this);
        startButton2.setVisible(true);
        startButton2.setBackground(Color.gray);
        startButton2.setForeground(Color.white);

        startFrame.add(startButton2);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setSize(420, 420);
        startFrame.setLayout(null);
        startFrame.setVisible(true);
        startFrame.getContentPane().setBackground(Color.lightGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== startButton1) {
            startFrame.dispose();
            mySheet = new Sheet(31);
        } else if (e.getSource() == startButton2) {
            mySheet.openSheetCoordinates("sprite.txt");
        }
    }
}
