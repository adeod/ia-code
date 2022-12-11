package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// used to implement colour in the sheet class

    public class Pixel extends JButton {
        int colN;


        public Pixel(int colN) {
            super();
            colN =0; //initialised as null when no colour is assigned
        }

        public int getColVal(){
            return colN;
        }

        public int incColVal(){
            colN = colN+1;

            if(colN >= 6){
                colN = 0;
            }
            return colN;
        }

        public void setColN(int setNum){
            colN = setNum;
        }

    }
