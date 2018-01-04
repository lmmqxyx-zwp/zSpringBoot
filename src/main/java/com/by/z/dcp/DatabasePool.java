package com.by.z.dcp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接池的实现 数据库连接池的主体部分
 *
 * @author zwp
 */
public class DatabasePool {
    //数据库连接池的数据结构 栈
    private ConnectionStack stack;
    //数据库连接、用户名、密码
    private final String url, username, password;

    private volatile boolean isRun = true;

    //初始化数据库连接池
    public DatabasePool(String url, String username, String password, int capacity, int timeout) {
        this.url = url;
        this.username = username;
        this.password = password;
        stack = new ConnectionStack(capacity, timeout);
    }

    //取得一个数据库连接
    public Connection getConnection() throws SQLException {
        if (!isRun) throw new SQLException("pool closed");
        Connection conn = stack.pop();
        if (conn == null) conn = DriverManager.getConnection(url, username, password);
        final Connection myConn = conn;
        //使用动态代理，当调用Connection.close()的时候自动将连接放回连接池中
        return (Connection) Proxy.newProxyInstance(
                DatabasePool.class.getClassLoader(),
                conn.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("close") && isRun) {
                            //当为调用close函数并且连接池正在运行，则将连接放入stack中，否则直接调用相关函数
                            stack.push(myConn);
                        } else {
                            return method.invoke(myConn, args);
                        }
                        return null;
                    }
                });
    }

    //关闭数据库连接
    public void close() throws SQLException{
        isRun = false;
        stack.close();
    }
}
