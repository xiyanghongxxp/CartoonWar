package com.neusoft.planewar.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.PlaneWarObject;
import com.neusoft.planewar.entity.Plane.BloodBar;
import com.neusoft.planewar.util.GameUtil;

public class Boss extends PlaneWarObject {

    static Random r = new Random();
    PlaneWarSystem pws;
    private int speed;
    private boolean good;
    private boolean live;
    private int blood;
    private boolean right;
    private boolean boss;
    private Direction dir;
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
    
    public int getBlood() {
        return blood;
    }
    public void setBlood(int blood) {
        this.blood = blood;
    }
    public boolean isLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }
    public Boss() {
        
    }
    
    public Boss(PlaneWarSystem pws) {
        this.pws = pws;
        this.x = 0;
        this.y = -1000;
        this.img = GameUtil.getImage(Constant.IMG_PRE+"boss"+Constant.IMG_AFTER);
        this.dir= Direction.DOWN;
        this.speed = 15;
        this.good = false;
        this.live = true;
        this.blood = Constant.BOSS_BLOOD;
        this.right = true;
        this.boss = true;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        if(boss) {
            bloodBar.draw(g);
        }
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
        if(r.nextInt(100)>90) {
            fire();
        }else if(r.nextInt(100)>97){
            fire1();
        }
    }
    private void fire() {         
                Bullet bullet1 = new Bullet (this.x,this.y+img.getHeight(null),"BossBullet2",Direction.DOWN,pws,good,false);
                Bullet bullet3 = new Bullet (this.x+this.img.getWidth(null)-bullet1.img.getWidth(null),this.y+img.getHeight(null),"BossBullet2",Direction.DOWN,pws,good,false);

                pws.bullets.add(bullet1);
                pws.bullets.add(bullet3);
        
    }
    private void fire1() {         
        Bullet bullet2 = new Bullet (this.x+this.img.getWidth(null)/2-50,this.y+img.getHeight(null),"BossBullet",Direction.DOWN,pws,good,true);

        pws.bullets.add(bullet2);

    }
    private BloodBar bloodBar = new BloodBar();
class BloodBar{
        
        public void draw(Graphics g) {
            Color c = g.getColor();
            if(blood>75) {
                g.setColor(Color.GREEN);
            }else if(blood<75&&blood>30){
                g.setColor(Color.ORANGE);
            }else {
                g.setColor(Color.RED);
            }
            g.drawRect(x, y-15, img.getWidth(null), 10);
            g.fillRect(x, y-15, img.getWidth(null)*blood/5000, 10);
            
            
        }
    }
}
