package com.neusoft.planewar.core;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.neusoft.planewar.constant.Constant;
import com.neusoft.planewar.util.GameUtil;

public class Images {
    public static Map<String,Image> imgs = new HashMap<>();
    static {
        imgs.put("me",GameUtil.getImage(Constant.IMG_PRE+"me"+Constant.IMG_AFTER));
        imgs.put("enemy",GameUtil.getImage(Constant.IMG_PRE+"enemy"+Constant.IMG_AFTER));
        imgs.put("mybullet_up",GameUtil.getImage(Constant.IMG_PRE+"mybullet_up"+Constant.IMG_AFTER));
        imgs.put("enemybullet_down",GameUtil.getImage(Constant.IMG_PRE+"enemybullet_down"+Constant.IMG_AFTER));
        imgs.put("a",GameUtil.getImage(Constant.IMG_PRE+"a"+Constant.IMG_AFTER));
        imgs.put("b",GameUtil.getImage(Constant.IMG_PRE+"b"+Constant.IMG_AFTER));
        imgs.put("c",GameUtil.getImage(Constant.IMG_PRE+"c"+Constant.IMG_AFTER));
        imgs.put("d",GameUtil.getImage(Constant.IMG_PRE+"d"+Constant.IMG_AFTER));
        imgs.put("e",GameUtil.getImage(Constant.IMG_PRE+"e"+Constant.IMG_AFTER));
        imgs.put("g",GameUtil.getImage(Constant.IMG_PRE+"g"+Constant.IMG_AFTER));
        imgs.put("h",GameUtil.getImage(Constant.IMG_PRE+"h"+Constant.IMG_AFTER));
        imgs.put("i",GameUtil.getImage(Constant.IMG_PRE+"i"+Constant.IMG_AFTER));
        imgs.put("1",GameUtil.getImage(Constant.IMG_PRE+"1"+Constant.IMG_AFTER));
        imgs.put("2",GameUtil.getImage(Constant.IMG_PRE+"2"+Constant.IMG_AFTER));
        imgs.put("3",GameUtil.getImage(Constant.IMG_PRE+"3"+Constant.IMG_AFTER));
        imgs.put("4",GameUtil.getImage(Constant.IMG_PRE+"4"+Constant.IMG_AFTER));
        imgs.put("5",GameUtil.getImage(Constant.IMG_PRE+"5"+Constant.IMG_AFTER));
        imgs.put("6",GameUtil.getImage(Constant.IMG_PRE+"6"+Constant.IMG_AFTER));
        imgs.put("7",GameUtil.getImage(Constant.IMG_PRE+"7"+Constant.IMG_AFTER));
        imgs.put("8",GameUtil.getImage(Constant.IMG_PRE+"8"+Constant.IMG_AFTER));
        imgs.put("9",GameUtil.getImage(Constant.IMG_PRE+"9"+Constant.IMG_AFTER));
       
    
    
    }
}
