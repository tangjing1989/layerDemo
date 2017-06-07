package com.tangjing.esper;

import java.sql.*;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/7
 * Time:下午3:18
 */

public class MysqlDemo {

//    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
//        String     sql;
//        String url = "jdbc:mysql://localhost:3306/test?" +
//                "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("成功加载MySQL驱动程序");
//            connection = DriverManager.getConnection(url);
//            Statement stmt = connection.createStatement();
//            sql = "select * from userlog";
//            //int result = stmt.executeUpdate(sql);
//            ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空
//            while (rs.next()) {
//                System.out.println(rs.getString(1)
//                        + "\t" + rs.getString(2)
//                        + "\t" + rs.getString(3)
//                        + "\t" + rs.getString(4)
//                        + "\t" + rs.getString(5)
//                        + "\t" + rs.getString(6)
//                        + "\t" + rs.getString(7)
//                        + "\t" + rs.getString(8)
//                        + "\t" + rs.getString(9)
//                        + "\t" + rs.getString(10)
//                        + "\t" + rs.getString(11));// 入如果返回的是int类型可以用getInt()
//            }
//        } catch (SQLException e) {
//            System.out.println("MySQL操作错误");
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connection.close();
//        }
//    }
}
