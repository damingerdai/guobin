package org.aming.guobin.support;

import org.aming.guobin.factory.GunbinConnectionFactory;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.sql.Connection;

/**
 * @athur aming
 * @date 2018-06-14 16:48
 */
public class GuobinConnectionPool extends GenericObjectPool<Connection> implements ObjectPool<Connection> {

    public GuobinConnectionPool(GunbinConnectionFactory factory) {
        super(factory);
    }

    public GuobinConnectionPool(GunbinConnectionFactory factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public GuobinConnectionPool(GunbinConnectionFactory factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
