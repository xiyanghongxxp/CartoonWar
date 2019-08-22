package com.neusoft.planewar.entity;

import java.awt.Graphics;
import java.util.Random;
import com.neusoft.planewar.core.PlaneWarObject;

public class Item extends PlaneWarObject{

    
    PlaneWarObject pws;
    
    static Random r = new Random();
    
    public Item() {}
    
    public Item(PlaneWarObject pws, int x, int y) {
        this.pws = pws;
        this.x = x;
        this.y = y;
        
    }
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }

}
