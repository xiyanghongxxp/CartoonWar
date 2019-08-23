package com.neusoft.planewar.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

/**
* @ClassName: GameUtil
* @Description: 工具类
* @author neuedu_yjr
* @date 2019年8月20日 下午4:49:43
*
*/
public class GameUtil {
    public static Properties prop = new Properties();
    static {
        try {
            prop.load(GameUtil.class.getClassLoader().getResourceAsStream("planewar.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    
    

    //获取图片的方法
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
