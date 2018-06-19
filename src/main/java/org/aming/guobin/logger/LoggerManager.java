package org.aming.guobin.logger;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @athur aming
 * @date 2018-06-14 16:26
 */
public class LoggerManager {
    private LoggerManager() {

    }

    private static Map<String, GuobinLogger> loggerMap;

    static {
        loggerMap = new HashMap<>();
    }

    public static GuobinLogger getLogger(Class<?> className) {
        return doGetLogger(className.getName());
    }

    public static GuobinLogger getLogger(String loggerName) {
        return doGetLogger(loggerName);
    }

    private static GuobinLogger doGetLogger(String loggerName) {
        return loggerMap.computeIfAbsent(loggerName, LoggerManager::buildLogger);
    }


    private static GuobinLogger buildLogger(String loggerName) {
        return new GuobinLogger(LoggerFactory.getLogger(loggerName));
    }
}
