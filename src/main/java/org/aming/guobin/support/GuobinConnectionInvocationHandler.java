package org.aming.guobin.support;

import org.aming.guobin.logger.GuobinLogger;
import org.aming.guobin.logger.LoggerManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * @author aming
 * @date 2018-06-19 22:30
 */
public class GuobinConnectionInvocationHandler implements InvocationHandler {

    private final GuobinLogger logger = LoggerManager.getLogger(getClass());

    private final Connection target;

    private boolean closed = false;

    public GuobinConnectionInvocationHandler(Connection target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("close".equals(method.getName())) {
            logger.debug("connection does not close in fact");
            this.closed = true;
            return null;
        } else if ("isClosed".equals(method.getName())) {
            return this.closed;
        } else {
            return method.invoke(target, args);
        }
    }
}
