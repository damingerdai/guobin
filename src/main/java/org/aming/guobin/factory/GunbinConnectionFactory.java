package org.aming.guobin.factory;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author aming
 * @date 2018-06-14 16:44
 */
public class GunbinConnectionFactory extends BasePooledObjectFactory<Connection> implements PooledObjectFactory<Connection> {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Override
    public Connection create() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<>(connection);
    }

    public GunbinConnectionFactory(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
