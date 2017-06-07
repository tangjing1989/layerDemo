package com.tangjing.web.service.impl;


import com.tangjing.web.dao.SysMapper;
import com.tangjing.web.pojo.MenuListPojo;
import com.tangjing.web.pojo.MenuPojo;
import com.tangjing.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/16
 * Time:上午10:42
 */
@Service
public class SysImpl implements ISysImpl {

    @Autowired
    private SysMapper sysMapper;

   // @Cacheable(value = "menuListcache",keyGenerator = "wiselyKeyGenerator")
    public List<MenuListPojo> queryLev1Menu() {
        System.out.println("-----------------------------无缓存的时候调用这里--------------------");
        List<MenuListPojo> MenuList     = new ArrayList<MenuListPojo>();

        List<MenuPojo>     menuLev1Lsit = sysMapper.queryMenuByLev(SysConstants.getValue("MenuLevel","MenuLeve1"));
        List<MenuPojo>     menuLev2Lsit = sysMapper.queryMenuByLev(SysConstants.getValue("MenuLevel","MenuLeve2"));
        //耗时 24262 性能高
        for (MenuPojo pojo : menuLev1Lsit) {
            List<MenuPojo> nodes        = new ArrayList<MenuPojo>();
            MenuListPojo   menuListPojo = new MenuListPojo();
            for (MenuPojo nodePojo : menuLev2Lsit) {
                if (nodePojo.getParentCode().equals(pojo.getMenuCode())) {
                    nodes.add(nodePojo);
                }
            }
            menuListPojo.setMenuId(pojo.getMenuId());
            menuListPojo.setMenuCode(pojo.getMenuCode());
            menuListPojo.setMenuName(pojo.getMenuName());
            menuListPojo.setMenuHref(pojo.getMenuHref());
            menuListPojo.setParentCode(pojo.getParentCode());
            menuListPojo.setImgText(pojo.getImgText());
            menuListPojo.setNodes(nodes);
            MenuList.add(menuListPojo);
        }

//        耗时 17106855 性能低不建议使用
//        sysMapper.queryMenuByLev(SysConstants.getValue("MenuLevel", "MenuLeve1")).forEach((MenuPojo pojo) -> {
//            List<MenuPojo> nodes        = new ArrayList<MenuPojo>();
//            MenuListPojo   menuListPojo = new MenuListPojo();
//            sysMapper.queryMenuByLev(SysConstants.getValue("MenuLevel", "MenuLeve2")).stream().
//                    filter(p -> p.getParentCode().equals(pojo.getMenuCode())).forEach(node -> {nodes.add(node);});
//            menuListPojo.setMenuId(pojo.getMenuId());
//            menuListPojo.setMenuCode(pojo.getMenuCode());
//            menuListPojo.setMenuName(pojo.getMenuName());
//            menuListPojo.setMenuHref(pojo.getMenuHref());
//            menuListPojo.setParentCode(pojo.getParentCode());
//            menuListPojo.setImgText(pojo.getImgText());
//            menuListPojo.setNodes(nodes);
//            MenuList.add(menuListPojo);
//            });

            return MenuList;
    }


}
