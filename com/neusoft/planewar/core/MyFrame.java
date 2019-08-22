package com.neusoft.planewar.core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.neusoft.planewar.constant.Constant;

public class MyFrame extends Frame {
    public void launchFrame() {
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setTitle(Constant.GAME_TITLE);
        this.setResizable(false);
        new MyThread().start();
    }
    //�Զ����߳�
    class MyThread extends Thread{
        @Override
        public void run() {
            while(true) {
                // java.awt���ṩ��һ���취 ���ߵ���paint(g)�ķ���
                repaint();
                // ���߳�˯��һ��ʱ�䡣
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    Image backImg = null;
    /**
     * ��дupdate()�������ڴ��ڵ�������һ�������ͼƬ
     * ������˸
     * 
     * */
    @Override
    public void update(Graphics g) {
        // backImg.getGraphics();
        if (backImg == null) {
            backImg = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        }
        // ��ȡ������ͼƬ�Ļ���
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.WHITE);
        backg.fillRect(0, 0, Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        backg.setColor(c);
        // ��������ͼƬ��paint�����Ŵ�ÿ50msˢ��һ��
        paint(backg);
        g.drawImage(backImg,0,0,null);
    }
    
}
