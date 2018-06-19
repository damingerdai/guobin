package org.aming.guobin.core;

import org.aming.guobin.logger.GuobinLogger;
import org.aming.guobin.logger.LoggerManager;
import org.aming.guobin.support.GuobinConnectionPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @athur aming
 * @date 2018-06-14 16:37
 */
public abstract class AbstractGuobinDataSource implements DataSource {

    protected final GuobinLogger logger = LoggerManager.getLogger(getClass());

    private GuobinConnectionPool pool;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return (T) this;
        }
        throw new SQLException("DataSource of type [" + getClass().getName() +
                "] cannot be unwrapped as [" + iface.getName() + "]");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException("getLogWriter");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("setLogWriter");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException("setLoginTimeout");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    protected GuobinConnectionPool getPool() {
        return pool;
    }

    public void setPool(GuobinConnectionPool pool) {
        this.pool = pool;
    }
}
