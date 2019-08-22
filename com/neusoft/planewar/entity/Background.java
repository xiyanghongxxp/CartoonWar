package com.neusoft.planewar.entity;

import java.awt.Graphics;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.PlaneWarObject;
import com.neusoft.planewar.util.GameUtil;

public class Background extends PlaneWarObject{

    private int speed;
    private Direction dir;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Background() {
        
    }
    public Background(int x , int y , String imgPath ) {
        this.x = x;
        this.y = y;
        this.img = GameUtil.getImage(Constant.IMG_PRE+imgPath+Constant.IMG_AFTER);
        this.dir= Direction.DOWN;
        this.speed = 10;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }
    @Override
    public void move() {
        y+=speed;
        
    }
}
