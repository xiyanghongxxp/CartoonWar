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
    Background background = new Background();
    
    //�����ɻ�
    public Plane myPlane = new Plane (210,745,true,"me",this);
    //�����з��ɻ�������
    public ArrayList<Plane>enemyPlanes = new ArrayList<>();
    //�����ӵ�������
    public ArrayList<Bullet>bullets = new ArrayList<>();
    //��ը����
    public ArrayList<Explode> explodes = new ArrayList<>();
    //����
    //public Item i = new Item(this);
    
    //
    Boss boss = new Boss(this);
    
    public ArrayList<Item>items = new ArrayList<Item>();
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
     * ������
     * 
     * */ 
    @Override
    public void paint(Graphics g) {
        //������
        background.draw(g);
        for(int i = 0;i<enemyPlanes.size();i++) {
            Plane plane = enemyPlanes.get(i);
            plane.draw(g);
        } 
        //�ӵ�����
        for(int i = 0;i<bullets.size();i++) {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            bullet.hitPlane(enemyPlanes);
            bullet.hitPlane(myPlane);
            bullet.hitBoss(boss);
        }
        

        //������
        if(items.size()>0) {
            for(int i =0;i<items.size();i++) {
                Item item = items.get(i);
                item.draw(g);
            }
        }
        //�л�ѭ��
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
        //��Ѫ
        myPlane.eatItemAddHp(items);
        //����
        myPlane.eatItemLevelUp(items);
        //��boss
        if(boss.getBlood()>0) {            
            boss.draw(g);
        }
        //������ը
        for(int i = 0;i<explodes.size();i++) {
            Explode e = explodes.get(i);            
            e.draw(g);            
        }
        //g.drawString("�ӵ���������"+bullets.size(), 50, 20);
        //g.drawString("���˵�������"+enemyPlanes.size(), 50, 40);
        //g.drawString("��ը��������"+explodes.size(), 50, 60);
        //g.drawString("�ҷ��ɻ�Ѫ����"+myPlane.getBlood(), 50, 80);
        //g.drawString("����������С��"+items.size(), 50, 100);
        //g.drawString("�ҵĵȼ���"+myPlane.getLevel(), 50, 120);
        //g.drawString("boss��Ѫ����"+boss.getBlood(), 50, 140);
        //g.drawString("boss����״����"+boss.isLive(), 50, 160);
    }
    
    
    
}
