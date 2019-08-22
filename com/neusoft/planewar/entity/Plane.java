package com.neusoft.planewar.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.neusoft.planewar.client.PlaneWarSystem;
import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.Images;
import com.neusoft.planewar.core.PlaneWarObject;
import com.neusoft.planewar.util.GameUtil;

/**
* @ClassName: Plane
* @Description: 飞机类
* @author neuedu_yjr
* @date 2019年8月20日 下午4:30:00
*
*/
public class Plane extends PlaneWarObject {
    
    private int speed;
    
    private boolean left,up,right,down;
    
    public Direction dir;
    private boolean good;
    private boolean live;
    PlaneWarSystem pws;
    
    private int blood=100;
    
    
    public int getBlood() {
        return blood;
    }
    public void setBlood(int blood) {
        this.blood = blood;
    }
    public boolean isGood() {
        return good;
    }
    public void setGood(boolean good) {
        this.good = good;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Plane() {
        
    }
    public Plane(int x , int y , String imgPath) {
        this.x = x;
        this.y = y;
        this.img = GameUtil.getImage(Constant.IMG_PRE+imgPath+Constant.IMG_AFTER);
        this.dir= Direction.STOP;
        this.speed = 20;
    }
    
    public Plane(int x , int y , String imgPath,int speed,Direction dir) {
        this(x ,y ,imgPath);
        this.speed=speed;
        this.dir= dir;
    }
    public Plane(int x,int y,boolean good ,PlaneWarSystem pws) {
        this.x = x;
        this.y = y;
        this.good = good;
        if(good) {
            this.img = Images.imgs.get("me");
            this.dir = Direction.STOP;
            this.speed = 20;
            this.blood=blood;
            
        }else {
            this.img = Images.imgs.get("enemy");
            this.dir = Direction.DOWN;
            this.speed = 5;
        }
        this.pws = pws;
        this.live = true;
    }   
    
    
    
    
    
    public boolean isLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }
    @Override
    public void draw(Graphics g) {
        if(!live) {
            this.pws.enemPlanes.remove(this);
        }
        if(good) {
            bloodBar.draw(g);
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
        outOfBounds();
        if(!good) {
            if(r.nextInt(100)>97) {
                fire();
            }
        }
    }
    static Random r = new Random();
    /**
     * 确定方向的方法*/
    private void confirmDirection() {
        if(left && !right && !up && !down) {
            dir = Direction.LEFT;
        }
        if(left && !right && up && !down) {
            dir = Direction.LEFT_UP;
        }
        if(!left && !right && up && !down) {
            dir = Direction.UP;
        }
        if(!left && right && up && !down) {
            dir = Direction.RIGHT_UP;
        }
        if(!left && right && !up && !down) {
            dir = Direction.RIGHT;
        }
        if(!left && right && !up && down) {
            dir = Direction.RIGHT_DOWN;
        }
        if(!left && !right && !up && down) {
            dir = Direction.DOWN;
        }
        if(left && !right && !up && down) {
            dir = Direction.LEFT_DOWN;
        }
        if(!left && !right && !up && !down) {
            dir = Direction.STOP;
        }
    }
    
    
    public void keyPressed(KeyEvent e) {
        //System.out.println("按下"+e.getKeyCode());
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT :
                left=true;
                break;
            case KeyEvent.VK_UP :
                up=true;
                break;
            case KeyEvent.VK_RIGHT :
                right=true;
                break;
            case KeyEvent.VK_DOWN :
                down=true;
                break;
            default:
                break;
        }
        confirmDirection();
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("按下"+e.getKeyCode());
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT :
                left=false;
                break;
            case KeyEvent.VK_UP :
                up=false;
                break;
            case KeyEvent.VK_RIGHT :
                right=false;
                break;
            case KeyEvent.VK_DOWN :
                down=false;
                break;
            case KeyEvent.VK_X :
                if(good&&live) {
                    fire();
                }
                break;
            
            default:
                break;
        }
        confirmDirection();
    }
    
    private void fire() {
        if(good) {
            Bullet bullet = new Bullet (this.x+this.img.getWidth(null)/2-34,this.y-110,"mybullet_up",Direction.UP,pws,good);
            pws.bullets.add(bullet);}
        else{
            Bullet bullet = new Bullet (this.x+this.img.getWidth(null)/2-7,this.y+70,"enemybullet_down",Direction.DOWN,pws,good);
            pws.bullets.add(bullet);
        }
        //System.out.println("添加成功");
    }
    //我方飞机出界问题
    private void outOfBounds() {
        if(x < 0 && this.good) {
            x = 0;
        }
        if(x > Constant.GAME_WIDTH - this.img.getWidth(null) && this.good) {
            x = Constant.GAME_WIDTH - this.img.getWidth(null);
        }
        if(y < 30 && this.good) {
            y = 30;
        }
        if(y > Constant.GAME_HEIGHT - this.img.getHeight(null) && this.good) {
            y = Constant.GAME_HEIGHT - this.img.getHeight(null);
        }   
        
    }
    private BloodBar bloodBar = new BloodBar();
    
    //画血条
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
            g.fillRect(x, y-15, img.getWidth(null)*blood/100, 10);
            
            
        }
    }

}
