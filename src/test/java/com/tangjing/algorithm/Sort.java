package com.tangjing.algorithm;

import com.tangjing.util.JsonUtil;

/**
 * Describe:
 * User:tangjing
 * Date:2017/6/5
 * Time:上午10:40
 */

public class Sort {



    private static final int[] arrays = {4, 4, 4, 4, 4};

    static int num=0;

    public static void sort1() {
        int temp=0;
        for (int i = 1; i <arrays.length; i++) {
            for (int l = i - 1; l >= 0; l--) {
                if ( arrays[l + 1]<arrays[l] ) {
                    temp = arrays[l + 1];
                    arrays[l + 1] = arrays[l];
                    arrays[l] = temp;
                }
                System.out.println(++num+"|i:--"+i+"|l:--"+l+"-当前比较数:"+arrays[l+1]+"和"+arrays[l]);
            }
        }
    }


    public static void main(String args[])
    {
      int a=128;
        int b=128;
        System.out.println(a==b);
    }
}
