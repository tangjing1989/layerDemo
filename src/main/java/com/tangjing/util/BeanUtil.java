package com.tangjing.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * Copyright (c) 2011 sxgkwei
 * Author:sxgkwei
 * Email:sxgkwei@gmail.com
 * Date: 2012-03-30 12:58:21
 * JDK : 1.6.2
 */
public class BeanUtil {


    private static Logger log = Logger.getLogger(BeanUtil.class); // 日志
    /**
     * 转换时对map中的key里的字符串会做忽略处理的正则串
     */
    private static final String OMIT_REG = "_";

    /**
     * 将map集合转换成Bean集合，Bean的属性名与map的key值对应时不区分大小写，并对map中key做忽略OMIT_REG正则处理
     *
     * @param <E>
     * @param cla
     * @param mapList
     * @return
     */
    public static <E> List<E> toBeanList(Class<E> cla,
                                         List<Map<String, Object>> mapList) {

        List<E> list = new ArrayList<E>(mapList.size());

        for (Map<String, Object> map : mapList) {
            E obj = toBean(cla, map);
            list.add(obj);
        }

        return list;
    }

    /**
     * 将map转换成Bean，Bean的属性名与map的key值对应时不区分大小写，并对map中key做忽略OMIT_REG正则处理
     *
     * @param <E>
     * @param cla
     * @param map
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public static <E> E toBean(Class<E> cla, Map<String, Object> map) {

        // 创建对象
        E obj = null;
        try {
            obj = cla.newInstance();
            if (obj == null) {
                throw new Exception("对象不能为空");
            }
        } catch (Exception e) {
            log.error("类型实例化对象失败,类型:" + cla);
            return null;
        }

        // 处理map的key
        Map<String, Object> newmap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> en : map.entrySet()) {
            newmap.put(
                    "set"
                            + en.getKey().trim().replaceAll(OMIT_REG, "")
                            .toLowerCase(), en.getValue());
        }

        // 进行值装入
        Method[] ms = cla.getMethods();
        for (Method method : ms) {
            String mname = method.getName().toLowerCase();
            if (mname.startsWith("set")) {

                Class[] clas = method.getParameterTypes();
                Object v = newmap.get(mname);

                if (v != null && clas.length == 1) {
                    try {
                        method.invoke(obj, v);
                    } catch (Exception e) {
                        log.error("属性值装入失败,装入方法：" + cla + "."
                                + method.getName() + ".可装入类型" + clas[0]
                                + ";欲装入值的类型:" + v.getClass());
                    }
                }
            }
        }

        return obj;
    }
}