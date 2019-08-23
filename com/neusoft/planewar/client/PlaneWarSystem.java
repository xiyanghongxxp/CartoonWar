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
    Background background = new Background();
    
    //创建飞机
    public Plane myPlane = new Plane (210,745,true,"me",this);
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
                Plane enemyPlane = new Plane (90+i*120,-600,false,"enemy",this);
                enemyPlanes.add(enemyPlane);
            }
            for(int i = 0;i<Constant.ENEMY_PLANE_NUM;i++) {
                Plane enemyPlane = new Plane (90+i*120,-150,false,"enemyPlane2",this);
                enemyPlanes.add(enemyPlane);
            }
            enemyPlanes.add(myPlane);
            
            
        }

    /**
     * 
     * 画方法
     * 
     * */ 
    @Override
    public void paint(Graphics g) {
        //画背景
        background.draw(g);
        for(int i = 0;i<enemyPlanes.size();i++) {
            Plane plane = enemyPlanes.get(i);
            plane.draw(g);
        } 
        //子弹击中
        for(int i = 0;i<bullets.size();i++) {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            bullet.hitPlane(enemyPlanes);
            bullet.hitPlane(myPlane);
            bullet.hitBoss(boss);
        }
        

        //画道具
        if(items.size()>0) {
            for(int i =0;i<items.size();i++) {
                Item item = items.get(i);
                item.draw(g);
            }
        }
        //敌机循环
        if(enemyPlanes.size()<=2&&myPlane.isLive()) {
            for(int i = 0;i<Constant.ENEMY_PLANE_NUM;i++) {
                Plane enemyPlane = new Plane (90+i*120,-600,false,"enemy",this);
                enemyPlanes.add(enemyPlane);
            }
            for(int i = 0;i<Constant.ENEMY_PLANE_NUM;i++) {
                Plane enemyPlane = new Plane (90+i*120,-150,false,"enemyPlane2",this);
                enemyPlanes.add(enemyPlane);
            }
        }
        //吃血
        myPlane.eatItemAddHp(items);
        //升级
        myPlane.eatItemLevelUp(items);
        //画boss
        if(boss.getBlood()>0) {            
            boss.draw(g);
        }
        //死亡爆炸
        for(int i = 0;i<explodes.size();i++) {
            Explode e = explodes.get(i);            
            e.draw(g);            
        }
        //g.drawString("子弹的数量："+bullets.size(), 50, 20);
        //g.drawString("敌人的数量："+enemyPlanes.size(), 50, 40);
        //g.drawString("爆炸的数量："+explodes.size(), 50, 60);
        //g.drawString("我方飞机血量："+myPlane.getBlood(), 50, 80);
        //g.drawString("道具容器大小："+items.size(), 50, 100);
        //g.drawString("我的等级："+myPlane.getLevel(), 50, 120);
        //g.drawString("boss的血量："+boss.getBlood(), 50, 140);
        //g.drawString("boss生存状况："+boss.isLive(), 50, 160);
    }
    
    
    
}
