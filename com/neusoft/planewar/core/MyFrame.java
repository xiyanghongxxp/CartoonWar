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
    //自定义线程
    class MyThread extends Thread{
        @Override
        public void run() {
            while(true) {
                // java.awt包提供了一个办法 无线调用paint(g)的方法
                repaint();
                // 让线程睡眠一段时间。
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
     * 重写update()方法，在窗口的里层添加一个虚拟的图片
     * 避免闪烁
     * 
     * */
    @Override
    public void update(Graphics g) {
        // backImg.getGraphics();
        if (backImg == null) {
            backImg = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        }
        // 获取到虚拟图片的画笔
        Graphics backg = backImg.getGraphics();
        Color c = backg.getColor();
        backg.setColor(Color.WHITE);
        backg.fillRect(0, 0, Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        backg.setColor(c);
        // 调用虚拟图片的paint（）放大，每50ms刷新一次
        paint(backg);
        g.drawImage(backImg,0,0,null);
    }
    
}
