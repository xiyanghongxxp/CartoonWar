package com.neusoft.planewar.core;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class PlaneWarObject implements Drawable,Moveable{
   /**
    * �����X����
    * 
    * */
    public int x;
    /**
     * �����Y����
     * 
     * */
    public int y;
    /**
     * �������ڵ�ͼƬ����
     * 
     * */
    public Image img;
  //��ȡ��ǰͼƬ����
    public Rectangle getReck() {
        return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
    }
}
