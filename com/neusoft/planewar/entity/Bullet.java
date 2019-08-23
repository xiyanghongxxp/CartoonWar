package com.neusoft.planewar.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.PlaneWarObject;
import com.neusoft.planewar.util.GameUtil;

public class Bullet extends PlaneWarObject{

    private int speed;
    
    private Direction dir;
    
    private boolean live;
    
    PlaneWarSystem pws;
    
    private boolean good;
    private boolean isBig;
    
    
    static Random r = new Random();
    
    public boolean isGood() {
        return good;
    }
    public void setGood(boolean good) {
        this.good = good;
    }
    public Bullet() {
        
    }
    
    public Bullet(int x , int y ,String img,Direction dir,PlaneWarSystem pws,boolean good, boolean big) {
        this.x = x;
        this.y = y;
        this.img = Images.imgs.get(img);
        this.dir= dir;
        this.speed = 20;
        this.live = true;
        this.pws = pws;
        this.good = good;
        this.dir = dir;
        this.isBig=big;
    }
    @Override
    public void draw(Graphics g) {
        if(!live) {
            this.pws.bullets.remove(this);
        }
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
        if(outOfBounds()) {
            this.live = false;
        }
           
    }
    
    //判断子弹出界
    private boolean outOfBounds() {
        if(x < 0 || x>Constant.GAME_WIDTH - this.img.getWidth(null)|| y<30 ||
                y > Constant.GAME_HEIGHT - this.img.getHeight(null)) {
            return true;
        }
        return false;
        
        
        
    }
    //子弹击打飞机
    public boolean hitPlane(Plane plane) {
        //判断子弹打到飞机的逻辑
        if(live&&plane.isLive()&&this.getReck().intersects(plane.getReck())&&this.good!=plane.isGood()) {
            //System.out.println("打到了");
            if(plane.isGood()&&this.isBig) {
                plane.setBlood(plane.getBlood()-10);
                this.live = false;
                if(plane.getBlood()<=0) {
                    plane.setLive(false);
                    Explode e = new Explode(plane.x,plane.y,pws);
                    this.pws.explodes.add(e);
                    
                }
            }else if(plane.isGood()&&!this.isBig) {
                plane.setBlood(plane.getBlood()-5);
                this.live = false;
                if(plane.getBlood()<=0) {
                    plane.setLive(false);
                    Explode e = new Explode(plane.x,plane.y,pws);
                    this.pws.explodes.add(e);
                    
                }
                
                return true;
            }else {
                Explode e = new Explode(plane.x,plane.y,pws);
                this.pws.explodes.add(e);
                this.live=false;
                plane.setLive(false);
                //生成血块
                if(r.nextInt(100)>30) {
                    Item item1 = new Item(pws, plane.x, plane.y,1);
                    pws.items.add(item1);
                    //Item item2 = new Item(pws, plane.x, plane.y,2);
                    //pws.items.add(item2);
                }
               // if(r.nextInt(100)>30) {
                //    Item item2 = new Item(pws, plane.x, plane.y,2);
               //     pws.items.add(item2);
               // }
                
                
                return true;
            }
            
        }
        return false;
        
    }
    public boolean hitPlane(List<Plane> planes) {
        //判断子弹打到飞机的逻辑
        for(int i =0;i<planes.size();i++) {
            Plane plane = planes.get(i);
            if(this.hitPlane(plane)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
  //子弹打Boss
    public boolean hitBoss(Boss boss) {
        //判断子弹打到boss的逻辑
        if(this.live&&boss.isLive()&&this.getReck().intersects(boss.getReck())&&this.good!=boss.isGood()) {
            
            
            if((!boss.isGood())&&this.isBig) {
                
                boss.setBlood(boss.getBlood()-30);
                this.live = false;
                Explode a = new Explode(boss.x,boss.y,pws);
                this.pws.explodes.add(a);
                if(boss.getBlood()<=0) {
                    boss.setLive(false);
                    
                    Explode e = new Explode(boss.x,boss.y,pws);
                    this.pws.explodes.add(e);
                    
                }
                    
                
            }else if(!this.isBig) {
                boss.setBlood(boss.getBlood()-5);
                this.live = false;
                Explode a = new Explode(boss.x,boss.y,pws);
                this.pws.explodes.add(a);
                if(boss.getBlood()<=0) {
                    boss.setLive(false);
                    Explode e = new Explode(boss.x,boss.y,pws);
                    this.pws.explodes.add(e);
                    
                }
                return true;
            }          
        }
        return false;   
    }    
    
}
