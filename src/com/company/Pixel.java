package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// used to implement colour in the sheet class

    public class Pixel extends JToggleButton implements ActionListener {


        // shows red, green and blue values in order to make
        int r;
        int g;
        int b;
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        int rectWidth = 20;

        public Pixel(int r, int g, int b) {
            super();
            this.r = r;
            this.g = g;
            this.b = b;

        }

        public void black(Pixel colPixel) {
            r= 0;
            g=0;
            b=0;
            Color black = new Color(r,g,b);
            colPixel.setContentAreaFilled(true);
        }

        public int getRValue(){
            return r;
        }
        public int getGValue(){
            return g;
        }
        public int getBValue(){
            return b;
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
        @Override
        public void actionPerformed(ActionEvent e) {

        }

        public void addActionListener(Pixel pixObj){
            pixObj.addActionListener(this::actionPerformed);
        }
    }
