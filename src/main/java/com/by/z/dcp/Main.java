package com.by.z.dcp;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池的实现 使用
 *
 * @author zwp
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";

        //Class.forName(driver);

        DatabasePool pool = new DatabasePool(url, username, password, 10, 60 * 60);
        //多个线程下可以同时如下使用
        Connection conn = null;
        try {
            conn = pool.getConnection();
            if (conn != null) {
                System.out.println("---");
            }
            //执行数据库操作
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

}
