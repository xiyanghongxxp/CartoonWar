package com.neusoft.planewar.core;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.GameUtil;

public class Images {
    public static Map<String,Image> imgs = new HashMap<>();
    static {
        //我的飞机
        imgs.put("me",GameUtil.getImage(Constant.IMG_PRE+"me"+Constant.IMG_AFTER));
        //敌机1
        imgs.put("enemy",GameUtil.getImage(Constant.IMG_PRE+"enemy"+Constant.IMG_AFTER));
        //我的向上子弹1
        imgs.put("mybullet_up",GameUtil.getImage(Constant.IMG_PRE+"mybullet_up"+Constant.IMG_AFTER));
        //敌机向下子弹1
        imgs.put("enemybullet_down",GameUtil.getImage(Constant.IMG_PRE+"enemybullet_down"+Constant.IMG_AFTER));
        //爆炸
        imgs.put("a",GameUtil.getImage(Constant.IMG_PRE+"a"+Constant.IMG_AFTER));
       
        imgs.put("b",GameUtil.getImage(Constant.IMG_PRE+"b"+Constant.IMG_AFTER));
       
        imgs.put("c",GameUtil.getImage(Constant.IMG_PRE+"c"+Constant.IMG_AFTER));
        
        imgs.put("d",GameUtil.getImage(Constant.IMG_PRE+"d"+Constant.IMG_AFTER));
        
        imgs.put("e",GameUtil.getImage(Constant.IMG_PRE+"e"+Constant.IMG_AFTER));
        
        imgs.put("g",GameUtil.getImage(Constant.IMG_PRE+"g"+Constant.IMG_AFTER));
        
        imgs.put("h",GameUtil.getImage(Constant.IMG_PRE+"h"+Constant.IMG_AFTER));
        
        imgs.put("i",GameUtil.getImage(Constant.IMG_PRE+"i"+Constant.IMG_AFTER));
        //加血道具
        imgs.put("addBlood",GameUtil.getImage(Constant.IMG_PRE+"addBlood"+Constant.IMG_AFTER));
        //boss
        imgs.put("boss",GameUtil.getImage(Constant.IMG_PRE+"boss"+Constant.IMG_AFTER));
        //boss的子弹1
        imgs.put("BossBullet",GameUtil.getImage(Constant.IMG_PRE+"BossBullet"+Constant.IMG_AFTER));
        //boss的子弹2
        imgs.put("BossBullet2",GameUtil.getImage(Constant.IMG_PRE+"BossBullet2"+Constant.IMG_AFTER));
        //我的轨迹子弹
        imgs.put("bullet0",GameUtil.getImage(Constant.IMG_PRE+"bullet0"+Constant.IMG_AFTER));
        //子弹升级道具
        imgs.put("bulletLevelUp",GameUtil.getImage(Constant.IMG_PRE+"bulletLevelUp"+Constant.IMG_AFTER));
        
        imgs.put("myBulletLevel2",GameUtil.getImage(Constant.IMG_PRE+"myBulletLevel2"+Constant.IMG_AFTER));
        
        imgs.put("enemyPlane2",GameUtil.getImage(Constant.IMG_PRE+"enemyPlane2"+Constant.IMG_AFTER));

        
    }
    
}
