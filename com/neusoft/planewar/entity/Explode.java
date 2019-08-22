package com.neusoft.planewar.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.PlaneWarObject;


/**
* @ClassName: Explode
* @Description: TODO(这里用一句话描述这个类的作用)
* @author neuedu_yjr
* @date 2019年8月20日 下午4:40:19
*
*/
public  class Explode extends PlaneWarObject {
    PlaneWarSystem pws;
    
    
    static Image[] imgs= {
            Images.imgs.get("a"),
            Images.imgs.get("b"),
            Images.imgs.get("c"),
            Images.imgs.get("d"),
            Images.imgs.get("e"),
            
            Images.imgs.get("g"),
            Images.imgs.get("h"),
            Images.imgs.get("i")
    };
    public Explode() {}
    public Explode(int x,int y,PlaneWarSystem pws) {
        this.x = x;
        this.y = y;
        this.live = true;
        this.pws = pws;
    }
    
    public boolean isLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }

    int step = 0;
    private boolean live;
    @Override
    public void draw(Graphics g) {
        /*for(int i = 0;i<imgs.length;i++) {
        g.drawImage(imgs[i],x,y,null);
        }*/
        if(!live) {
            this.pws.explodes.remove(this);
            return;
        }
        if(step>imgs.length-1) {
            this.live=false;
            step = 0;
            return;
        }
        g.drawImage(imgs[step],x,y,null);
        step++;
        
    }

    @Override
    public void move() {
        
        
    }

    
    
}
