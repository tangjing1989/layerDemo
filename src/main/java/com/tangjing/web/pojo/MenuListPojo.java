package com.tangjing.web.pojo;


import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/16
 * Time:下午2:06
 */

public class MenuListPojo {
    private int            menuId;
    private String         menuCode;
    private String         menuName;
    private String         menuHref;
    private String         parentCode;
    private String         imgText;
    private List<MenuPojo> nodes;

    public List<MenuPojo> getNodes() {
        return nodes;
    }

    public void setNodes(List<MenuPojo> nodes) {
        this.nodes = nodes;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getImgText() {
        return imgText;
    }

    public void setImgText(String imgText) {
        this.imgText = imgText;
    }
}
