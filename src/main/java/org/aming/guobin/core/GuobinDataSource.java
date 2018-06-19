package org.aming.guobin.core;

import org.aming.guobin.exceptions.Exceptions;
import org.aming.guobin.support.GuobinConnectionInvocationHandler;
import org.aming.guobin.support.GuobinConnectionPool;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @athur aming
 * @date 2018-06-14 16:37
 */
public class GuobinDataSource extends AbstractGuobinDataSource implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Connection connection = getPool().borrowObject();
            return (Connection)Proxy.newProxyInstance(connection.getClass().getClassLoader(), new Class<?>[] {Connection.class}, new GuobinConnectionInvocationHandler(connection));
        } catch (Exception ex) {
            logger.error("fail to get connection", ex);
            throw Exceptions.getSQLException(ex);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    public GuobinDataSource() {
        super();
    }

    public GuobinDataSource(GuobinConnectionPool pool) {
        super();
        this.setPool(pool);
    }
}
