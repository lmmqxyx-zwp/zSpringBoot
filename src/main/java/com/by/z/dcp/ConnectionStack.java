package com.by.z.dcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 数据库连接池的实现 栈容器 用java中的双向链表实现
 *
 * @author zwp
 */
public class ConnectionStack {

    private final int timeout;//单位 秒

    private final int capacity;//连接数

    private LinkedList<ConnWithTime> list = new LinkedList<>();

    //内部类，用来记录Connection的上次使用时间
    private class ConnWithTime {
        private final long time = new Date().getTime();//实例化的时间即为上次归还的时间
        private Connection conn;

        public ConnWithTime(Connection conn) {
            this.conn = conn;
        }

        //当前连接是否已经超时
        boolean isTimeout() {
            return new Date().getTime() - time > timeout * 1000;
        }
    }

    public ConnectionStack(int capacity, int timeout) {
        this.capacity = capacity;
        this.timeout = timeout;
    }

    public synchronized void push(Connection conn) throws SQLException {
        clearTimeoutConnection();
        if (list.size() < capacity) {
            list.addFirst(new ConnWithTime(conn));
        } else {
            conn.close();
        }
    }

    private void clearTimeoutConnection() throws SQLException {
        //接下来从栈底部开始遍历，把所有超时的连接关闭并且丢弃，直到未超时的连接为止
        //ps:在正常情况下，栈底部最后一个也是活跃的，所以直接break了，平常调用应该是常数时间
        Iterator<ConnWithTime> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            ConnWithTime connWithTime = iterator.next();
            if (connWithTime.isTimeout()) {
                connWithTime.conn.close();
                iterator.remove();
            } else {
                break;
            }
        }
    }

    public synchronized Connection pop() {
        if (list.isEmpty()) return null;
        return list.removeFirst().conn;
    }

    public synchronized void close() throws SQLException {
        Iterator<ConnWithTime> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            ConnWithTime connWithTime = iterator.next();
            connWithTime.conn.close();
            iterator.remove();
        }
    }

}
