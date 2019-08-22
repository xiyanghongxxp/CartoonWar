package com.neusoft.planewar.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.PlaneWarObject;

/**
* @ClassName: Item
* @Description: 道具类
* @author neuedu_yjr
* @date 2019年8月22日 下午4:12:43
*
*/
public class Item extends PlaneWarObject{

    
    PlaneWarSystem pws;


    private boolean live;

    private int speed;



    private double degree;
    
    
    
    static Random r = new Random();
    
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Item() {}
    
    public Item(PlaneWarSystem pws) {
        this.pws = pws;
        this.img = Images.imgs.get("addBlood");
        this.x = r.nextInt(Constant.GAME_WIDTH-2*img.getWidth(null))+img.getWidth(null);
        this.y = r.nextInt(Constant.GAME_HEIGHT-2*img.getHeight(null)+30)+img.getHeight(null);
        this.speed = 10;
        this.live=true;
        this.degree = r.nextInt((int)(Math.PI*2));
    }
    public Item(PlaneWarSystem pws, int x ,int y) {
        this.pws = pws;
        this.img=Images.imgs.get("addBlood");
        this.x = x;
        this.y = y;
        this.speed = 10;
        this.live = true;
        this.degree = r.nextInt((int)(Math.PI*2));

    }
    
    
    
    @Override
    public void draw(Graphics g) {
        if(!live) {
            pws.items.remove(this);
            return;
        }
        g.drawImage(img,x,y,null);
        move();
    }

    @Override
    public void move() {
        x+=(int)(speed*Math.cos(degree));
        y+=(int)(speed*Math.sin(degree));
        if(x<0 || x>Constant.GAME_WIDTH-img.getWidth(null)) {
            degree = Math.PI-degree;
        }
        if(y<30 || y>Constant.GAME_HEIGHT-img.getHeight(null)) {
            degree = -degree;
        }

    }


    

}
