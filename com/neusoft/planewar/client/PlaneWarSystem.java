package com.neusoft.planewar.client;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.core.Direction;
import com.neusoft.planewar.core.MyFrame;
import com.neusoft.planewar.entity.Background;
import com.neusoft.planewar.entity.Bullet;
import com.neusoft.planewar.entity.Explode;
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
    public ArrayList<Plane>enemPlanes = new ArrayList<>();
    //创建子弹的容器
    public ArrayList<Bullet>bullets = new ArrayList<>();
    //爆炸容器
    public ArrayList<Explode> explodes = new ArrayList<>();
    //测试爆炸
    //Explode explode = new Explode(200,500);
    //画出一枚子弹
    //Bullet bullet = new Bullet(100,745,Direction.UP);
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
                Plane enemyPlane1 = new Plane (90+i*120,-1000,false,this);
                Plane enemyPlane2 = new Plane (90+i*120,-1800,false,this);
                enemPlanes.add(enemyPlane);
                enemPlanes.add(enemyPlane1);
                enemPlanes.add(enemyPlane2);
            }
            enemPlanes.add(myPlane);
        }

    /**
     * 
     * 画方法
     * 
     * */ 
    @Override
    public void paint(Graphics g) {
        
        background.draw(g);
        for(int i = 0;i<enemPlanes.size();i++) {
            Plane plane = enemPlanes.get(i);
            plane.draw(g);
        }  
        for(int i = 0;i<bullets.size();i++) {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            bullet.hitPlane(enemPlanes);
            bullet.hitPlane(myPlane);
        }
        for(int i = 0;i<explodes.size();i++) {
            Explode e = explodes.get(i);            
            e.draw(g);
            
        }
        g.drawString("子弹的数量："+bullets.size(), 50, 40);
        g.drawString("敌人的数量："+enemPlanes.size(), 50, 80);
        g.drawString("爆炸的数量："+explodes.size(), 50, 120);
        g.drawString("我方飞机血量："+myPlane.getBlood(), 50, 160);
            
    }
    
    
    
}
