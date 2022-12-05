package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// used to implement colour in the sheet class

    public class Pixel extends JButton {
        char col;


        public Pixel(char col) {
            super();
            this.col = 'n'; //initialised as null when no colour is assigned
        }

        public char getColVal(Pixel thisP){
            return thisP.col;
        }

       /* public int getX(){
            if(x <= 31 && x > 0){
                // set x coordinates of rectangle to 0
                x=0;

            }  if(x > 31 && x <=62){
                // set x coordinates of rectangle to 20
                x=31;
            }  if(x > 62 && x <= 93){
                // set x coordinates of rectangle to 40
                x=40;
            }  if(x > 93 && x <=124){
                // set x coordinates of rectangle to 0
            } if(x > 124 && x <=185){
                // set x coordinates of rectangle to 0
            } if(x > 185 && x <= 276){
                // set x coordinates of rectangle to 0
            }if(x > 276 && x <= 307){
                // set x coordinates of rectangle to 0
            }if(x > 307 && x <= 338){
                // set x coordinates of rectangle to 0
            }else{
                x=0;
            }
            return x;
        }
 */
    }
