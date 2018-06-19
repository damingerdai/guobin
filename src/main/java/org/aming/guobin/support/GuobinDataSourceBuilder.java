package org.aming.guobin.support;

import org.aming.guobin.core.GuobinDataSource;
import org.aming.guobin.factory.GunbinConnectionFactory;

/**
 * @author aming
 * @date 2018-06-19 15:09
 */
public class GuobinDataSourceBuilder {

    public static GuobinDataSource buildSimpleDataSource(String driver, String url, String username, String password) {
        GuobinConnectionPool pool = new GuobinConnectionPool(new GunbinConnectionFactory(driver, url, username, password));
        return new GuobinDataSource(pool);
    }
}
