package com.neusoft.planewar.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.PlaneWarObject;
import com.neusoft.planewar.util.GameUtil;

public class Background extends PlaneWarObject{

    private static Image img =GameUtil.getImage(Constant.IMG_PRE+"bj"+Constant.IMG_AFTER);
    
    private int x=0;
    private int y1=-img.getHeight(null)+860;
    private int y2=-2*img.getHeight(null)+860;
    private int speed=10;
    public Background() {
        // TODO Auto-generated method stub

    }  
  
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(img, x, y1, null);
        g.drawImage(img, x, y2, null);
        move();
    }

    @Override
    public void move() {
        
        if(y2>=860){
            y2=y1-2*img.getHeight(null)+860;
        }else if(y1>=860) {
            y1=y2-2*img.getHeight(null)+860;
        }
        y1+=speed;
        y2+=speed;
        
    }

    
    
}
