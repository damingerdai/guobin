package org.aming.guobin.test;

import org.aming.guobin.support.GuobinDataSourceBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author aming
 * @date 2018-06-19 19:03
 */
public class TestGuobinDataSource {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL  =  "jdbc:mysql://127.0.0.1:3306/world?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "267552";

    private static DataSource ds;

    @BeforeClass
    public static void initDataSource() {
        ds = GuobinDataSourceBuilder.buildSimpleDataSource(DRIVER, URL, USERNAME, PASSWORD);
    }

    @Test
    public void testGetConnection() throws SQLException {
        Assert.assertNotNull(ds.getConnection());
    }
}
