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
* @Description: �ͻ���
* @author neuedu_yjr
* @date 2019��8��20�� ����3:58:43
* @version 1.0
*/
public class PlaneWarSystem extends MyFrame{
    /**
     * 
     */
    //����
    Background background = new Background(0,-27000,"bj");
    
    //�����ɻ�
    public Plane myPlane = new Plane (210,745,true,this);
    //�����з��ɻ�������
    public ArrayList<Plane>enemPlanes = new ArrayList<>();
    //�����ӵ�������
    public ArrayList<Bullet>bullets = new ArrayList<>();
    //��ը����
    public ArrayList<Explode> explodes = new ArrayList<>();
    //���Ա�ը
    //Explode explode = new Explode(200,500);
    //����һö�ӵ�
    //Bullet bullet = new Bullet(100,745,Direction.UP);
    @Override
        public void launchFrame() {
            
            super.launchFrame();
            //��Ӽ��̼���
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
     * ������
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
        g.drawString("�ӵ���������"+bullets.size(), 50, 40);
        g.drawString("���˵�������"+enemPlanes.size(), 50, 80);
        g.drawString("��ը��������"+explodes.size(), 50, 120);
        g.drawString("�ҷ��ɻ�Ѫ����"+myPlane.getBlood(), 50, 160);
            
    }
    
    
    
}
