package com.tangjing.util;


import com.alibaba.druid.util.StringUtils;

import java.util.*;

/**
 * Describe:静态常量
 * User:tangjing
 * Date:17/1/16
 * Time:上午10:57
 */

public final class SysConstants {

    public static Map constants = new HashMap();

    static {
        List list      = null;

        //菜单级别
        Map  MenuLevel = new HashMap();
        MenuLevel.put("description", "菜单级别");
        MenuLevel.put("name", "MenuLevel");
        list = new ArrayList();
        list.add(addValue(MenuLevel, "4", "MenuLeve1", "一级菜单"));
        list.add(addValue(MenuLevel, "6", "MenuLeve2", "二级菜单"));
        MenuLevel.put("values", list);
        constants.put("MenuLevel", MenuLevel);

        //数据库字段类型
        Map  DataType = new HashMap();
        DataType.put("description", "数据库字段类型");
        DataType.put("name", "DataType");
        list = new ArrayList();
        list.add(addValue(DataType, "CHAR","String",""));
        list.add(addValue(DataType, "VARCHAR","String",""));
        list.add(addValue(DataType, "DECIMAL","java.math.BigDecimal",""));
        list.add(addValue(DataType, "BOOLEAN","boolean",""));
        list.add(addValue(DataType, "INTEGER","int",""));
        list.add(addValue(DataType, "BIGINT","long",""));
        list.add(addValue(DataType, "FLOAT","double",""));
        list.add(addValue(DataType, "DOUBLE","double",""));
        list.add(addValue(DataType, "DATE","java.sql.Date",""));
        list.add(addValue(DataType, "TIME","java.sql.Time",""));
        list.add(addValue(DataType, "TIMESTAMP","java.sql.Timestamp",""));
        list.add(addValue(DataType, "BLOB","Blob",""));
        list.add(addValue(DataType, "ARRAY","Array",""));
        DataType.put("values", list);
        constants.put("DataType", DataType);
    }

    //将值设置进入Map constans中
    private static Map addValue(Map map, String value, String name, String label) {
        Map constant = new HashMap();
        constant.put("value", value);
        constant.put("name", name);
        constant.put("label", label);
        map.put(value, constant);
        map.put(name, constant);
        map.put(label, constant);
        return constant;
    }

    /**
     * 根据字典名取map
     * @param dictName
     * @return
     */
    public static Map getMapByDictName(String dictName) {
        if (constants == null) return null;
        if (StringUtils.isEmpty(dictName)) return null;
        return (Map) SysConstants.constants.get(dictName);
    }


    /**
     * 根据字典名取map下的list
     * @param dictName
     * @return
     */
    public static List getListByName(String dictName) {
        Map map = SysConstants.getMapByDictName(dictName);
        if (map == null) return null;
        return (List) map.get("values");
    }


    /**
     * @param dictName
     * @param name
     * @param type
     * @return
     */
    public static Map getConstantMapWithType(String dictName, String name, String type) {
        if (StringUtils.isEmpty(name)) return null;
        List list = SysConstants.getListByName(dictName);
        if (list == null) return null;
        for (int num = 0; num < list.size(); num++) {
            Map map = (Map) list.get(num);
            if (map.get(type).equals(name)) {
                return map;
            }
        }
        return null;
    }

    /**
     * 根据字典名和数据name取Map
     * @param dictName
     * @param name
     * @return
     */
    public static Map getConstantMap(String dictName, String name) {
        return SysConstants.getConstantMapWithType(dictName, name, "name");
    }


    public static String getValueWithType(String dictName, String name, String type) {
        if (StringUtils.isEmpty(type)) return null;
        Map map = SysConstants.getConstantMap(dictName, name);
        if (map == null) return null;
        return (String) map.get(type);
    }


    public static String getValue(String dictName, String name) {
        return getValueWithType(dictName, name, "value");
    }

    /**
     * 根据字典常量名获取下拉框列表的Map 转换成linklist 便于查找
     * @param dictName
     * @return
     */
    public static Map<String, String> getDictListMap(String dictName) {
        //改成有序的Map
        Map<String, String> map  = new LinkedHashMap<String, String>();
        Map                 m    = new HashMap();
        List<Map>           list = SysConstants.getListByName(dictName);
        for (Map<String, Object> val : list) {
            m = SysConstants.getConstantMap(dictName, (String) val.get("value"));
            map.put(m.get("value").toString().trim(), m.get("label").toString().trim());
        }
        return map;

    }
}