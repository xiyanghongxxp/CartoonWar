package com.neusoft.planewar.entity;

import java.awt.Graphics;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.util.GameUtil;

public class Boss extends Plane {

    
    
    private int speed;
    private boolean good;
    private boolean live;
    private int blood;
    private boolean right;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean isGood() {
        return good;
    }
    public void setGood(boolean good) {
        this.good = good;
    }
    public Boss() {
        
    }
    public Boss(PlaneWarSystem pws) {
        this.x = 0;
        this.y = 0;
        this.img = GameUtil.getImage(Constant.IMG_PRE+"boss"+Constant.IMG_AFTER);
        this.dir= Direction.DOWN;
        this.speed = 15;
        this.good = false;
        this.live = true;
        this.blood = Constant.BOSS_A_BLOOD;
        this.right = true;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }
    

    @Override
    public void move() {
        switch(dir) {
            case LEFT:
                x-=speed;
                break;
            case LEFT_UP:
                y-=speed;
                x-=speed;
                break;
            case UP:
                y-=speed;
                break;
            case RIGHT_UP:
                x+=speed;
                y-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
            case RIGHT_DOWN:
                y+=speed;
                x+=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT_DOWN:
                y+=speed;
                x-=speed;
                break;
            default:
                dir=Direction.STOP;
                break;
        }
        if(y>120) {
            y=120;
            if(right) {
                x+=10;
            }else {
                x-=10;
            }
            if(x>Constant.GAME_WIDTH-img.getWidth(null)) {
                
                right = false;
            }else if(x<=0) {
                right = true;
            }
        }
        
    }
    
}
