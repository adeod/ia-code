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
    JButton tem1, tem2, tem3;
    public LaunchPage() {
        startButton1.setBounds(100, 160, 200, 40);
        startButton1.setFocusable(false);
        startButton1.addActionListener(this);
        startButton1.setVisible(true);
        startButton1.setBackground(Color.gray);
        startButton1.setForeground(Color.white);
        startFrame.add(startButton1);

        tem1 = new JButton("1");
        tem1.setBounds(100, 240, 40, 40);
        tem1.setFocusable(false);
        tem1.addActionListener(this);
        tem1.setVisible(true);
        tem1.setBackground(Color.gray);
        tem1.setForeground(Color.white);
        startFrame.add(tem1);

        tem2 = new JButton("2");
        tem2.setBounds(180, 240, 40, 40);
        tem2.setFocusable(false);
        tem2.addActionListener(this);
        tem2.setVisible(true);
        tem2.setBackground(Color.gray);
        tem2.setForeground(Color.white);
        startFrame.add(tem2);

        tem3 = new JButton("3");
        tem3.setBounds(260, 240, 40, 40);
        tem3.setFocusable(false);
        tem3.addActionListener(this);
        tem3.setVisible(true);
        tem3.setBackground(Color.gray);
        tem3.setForeground(Color.white);
        startFrame.add(tem3);

        /*
        startButton2.setBounds(200, 240, 200, 40);
        startButton2.setFocusable(false);
        startButton2.addActionListener(this);
        startButton2.setVisible(true);
        startButton2.setBackground(Color.gray);
        startButton2.setForeground(Color.white);
        startFrame.add(startButton2);
        */
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
        } if (e.getSource() == tem1) {
            startFrame.dispose();
            mySheet = new Sheet(31);
            mySheet.openSheetCoordinates("spriteTemplate1.txt");
        } if (e.getSource() == tem2) {
            startFrame.dispose();
            mySheet = new Sheet(31);
            mySheet.openSheetCoordinates("spriteTemplate2.txt");
        } if (e.getSource() == tem3) {
            startFrame.dispose();
            mySheet = new Sheet(31);
            mySheet.openSheetCoordinates("spriteTemplate3.txt");
        }
    }
}
