package com.neusoft.planewar.client;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.MyFrame;
import com.neusoft.planewar.entity.Background;
import com.neusoft.planewar.entity.Boss;
import com.neusoft.planewar.entity.Bullet;
import com.neusoft.planewar.entity.Explode;
import com.neusoft.planewar.entity.Item;
import com.neusoft.planewar.entity.Plane;

/**
* @ClassName: PlaneWarSystem
* @Description: 客户端
* @author neuedu_yjr
* @date 2019年8月20日 下午3:58:43
* @version 1.0
*/
public class PlaneWarSystem extends MyFrame{
    /**
     * 
     */
    //背景
    Background background = new Background(0,-27000,"bj");
    
    //创建飞机
    public Plane myPlane = new Plane (210,745,true,this);
    //创建敌方飞机的容器
    public ArrayList<Plane>enemyPlanes = new ArrayList<>();
    //创建子弹的容器
    public ArrayList<Bullet>bullets = new ArrayList<>();
    //爆炸容器
    public ArrayList<Explode> explodes = new ArrayList<>();
    //道具
    //public Item i = new Item(this);
    
    //
    Boss boss = new Boss(this);
    
    public ArrayList<Item>items = new ArrayList<Item>();
    @Override
        public void launchFrame() {
            
            super.launchFrame();
            //添加键盘监听
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    
                    myPlane.keyPressed(e);
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    myPlane.keyReleased(e);
                    
                }
            });
            for(int i = 0;i<Constant.ENEMY_PLANE_NUM;i++) {
                Plane enemyPlane = new Plane (90+i*120,-200,false,this);
                enemyPlanes.add(enemyPlane);
            }
            enemyPlanes.add(myPlane);
            Item o = new Item(this);
            items.add(o);
        }

    /**
     * 
     * 画方法
     * 
     * */ 
    @Override
    public void paint(Graphics g) {
        
        background.draw(g);
        for(int i = 0;i<enemyPlanes.size();i++) {
            Plane plane = enemyPlanes.get(i);
            plane.draw(g);
        }  
        for(int i = 0;i<bullets.size();i++) {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            bullet.hitPlane(enemyPlanes);
            bullet.hitPlane(myPlane);
        }
        for(int i = 0;i<explodes.size();i++) {
            Explode e = explodes.get(i);            
            e.draw(g);
            
        }
        //for(int i =0;i<items.size();i++) {
         //   Item item = items.get(i);
         //   myPlane.eatItem(items);
         //   if(myPlane.isLive()&&myPlane.getBlood()<=40) {
        //        item.draw(g);
         //   }
            
        //}
        if(items.size()>0) {
            for(int i =0;i<items.size();i++) {
                Item item = items.get(i);
                item.draw(g);
            }
        }
        if(enemyPlanes.size()<=1&&myPlane.isLive()) {
            for(int i = 0;i<Constant.ENEMY_PLANE_NUM;i++) {
                Plane enemyPlane = new Plane (90+i*120,-200,false,this);
                enemyPlanes.add(enemyPlane);
            }
        }
        myPlane.eatItem(items);
        boss.draw(g);
        g.drawString("子弹的数量："+bullets.size(), 50, 40);
        g.drawString("敌人的数量："+enemyPlanes.size(), 50, 80);
        g.drawString("爆炸的数量："+explodes.size(), 50, 120);
        g.drawString("我方飞机血量："+myPlane.getBlood(), 50, 160);
        g.drawString("道具容器大小："+items.size(), 50, 200);
        g.drawString("Boss存活状态："+boss.isLive(), 50, 220);

    }
    
    
    
}
