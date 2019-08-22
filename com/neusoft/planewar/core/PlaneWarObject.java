package com.neusoft.planewar.core;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class PlaneWarObject implements Drawable,Moveable{
   /**
    * 物体的X坐标
    * 
    * */
    public int x;
    /**
     * 物体的Y坐标
     * 
     * */
    public int y;
    /**
     * 物体所在的图片对象
     * 
     * */
    public Image img;
  //获取当前图片矩形
    public Rectangle getReck() {
        return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
    }
}
