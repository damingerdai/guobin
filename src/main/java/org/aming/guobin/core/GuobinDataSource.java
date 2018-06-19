package org.aming.guobin.core;

import org.aming.guobin.exceptions.Exceptions;
import org.aming.guobin.support.GuobinConnectionPool;

import javax.sql.DataSource;
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
            return getPool().borrowObject();
        } catch (Exception ex) {
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
