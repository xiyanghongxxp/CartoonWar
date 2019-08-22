package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
* @ClassName: GameUtil
* @Description: ������
* @author neuedu_yjr
* @date 2019��8��20�� ����4:49:43
*
*/
public class GameUtil {

    //��ȡͼƬ�ķ���
    public static Image getImage(String imgpath) {
        
        URL u = GameUtil.class.getClassLoader().getResource(imgpath);
        BufferedImage img = null ;
        try {
            img = ImageIO.read(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}
