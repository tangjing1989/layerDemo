package com.test;

import com.tangjing.web.pojo.MenuPojo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/26
 * Time:下午3:54
 */

public class Java8Test {

//    public static void main(String[] args) throws Exception {
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            System.out.println(result); return result;
//        } );
//    }




    public static void testFileRead() throws IOException {
        final Path     path  = new File("/Users/tangjing/devloper/ideaWorkSpace/layerDemo/logFile_IS_UNDEFINED").toPath();
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
    }


    public static void testInterfaceDefaultmethod() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {

                System.out.println(sqrt(a * 100));
                return sqrt(a * 100);
            }

            @Override
            public double sqrt(int a) {

                System.out.println(StrictMath.sqrt(a));
                return StrictMath.sqrt(a);
            }
        };
        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0
    }


    public static void testLambda() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });

//        Collections.sort(names, (String a, String b) -> b.compareTo(a));
//        Collections.sort(names, (a, b) -> b.compareTo(a));

//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> System.out.println(e1.compareTo( e2 ) ));
    }


    @FunctionalInterface
    interface Converter<F, T> {
        //必须仅包含一个抽象方法，用于lambda表达式给出具体实现。这里可以包含扩展方法
        T convert(F from);
    }
    // Integer.valueOf(from)是函数式接口里面抽象方法的实现。


    public static void testFunctionalInterface() {
        Converter<Integer, String> converter = from -> String.valueOf(from);
        String                     converted = converter.convert(123);
        System.out.println(converted);    // 123
    }

    interface Formula {
        double calculate(int a);

        //default修饰的扩展方法
        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }


    public static void testLambda1() {
        new Thread(() -> System.out.println("Hello World!")).start();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testLambda2() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + 0.10 * cost).forEach(System.out::println);

    }


    public static void testStream() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        List<String> strs=new ArrayList<>();

        strs.add("A");
        strs.add("B");
        strs.add("C");
        strs.add("D");

        strs.forEach(p -> System.out.println(p));

//        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
//
//        items.forEach((k, v) -> {
//            System.out.println("Item : " + k + " Count : " + v);
//            if ("E".equals(k)) {
//                System.out.println("Hello E");
//            }
//        });
    }
}
