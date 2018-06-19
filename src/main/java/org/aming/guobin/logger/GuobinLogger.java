package org.aming.guobin.logger;


import org.slf4j.Logger;

import java.util.function.Supplier;

/**
 * @athur aming
 * @date 2018-06-14 16:14
 */
public class GuobinLogger {

    private final Logger logger;

    public GuobinLogger(final Logger logger) {
        this.logger = logger;
    }

    public void trace(String msg) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }

    public void trace(String format, Object...arguments) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, arguments);
        }
    }

    public void trace(String msg, Throwable t) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg, t);
        }
    }

    public void trace(Supplier<String> supplier) {
        if (logger.isTraceEnabled()) {
            logger.trace(supplier.get());
        }
    }

    public void trace(Supplier<String> messageSupplier, Supplier<Throwable> throwableSupplier) {
        if (logger.isTraceEnabled()) {
            logger.trace(messageSupplier.get(), throwableSupplier.get());
        }
    }

    public void debug(String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public void debug(String format, Object...arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, arguments);
        }
    }

    public void debug(String msg, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, t);
        }
    }

    public void debug(Supplier<String> supplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(supplier.get());
        }
    }

    public void debug(Supplier<String> messageSupplier, Supplier<Throwable> throwableSupplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(messageSupplier.get(), throwableSupplier.get());
        }
    }

    public void info(String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    public void info(String format, Object...arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(format, arguments);
        }
    }

    public void info(String msg, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }

    public void info(Supplier<String> supplier) {
        if (logger.isInfoEnabled()) {
            logger.info(supplier.get());
        }
    }

    public void info(Supplier<String> messageSupplier, Supplier<Throwable> throwableSupplier) {
        if (logger.isDebugEnabled()) {
            logger.info(messageSupplier.get(), throwableSupplier.get());
        }
    }

    public void warn(String msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    public void warn(String format, Object...arguments) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, arguments);
        }
    }

    public void warn(String msg, Throwable t) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, t);
        }
    }

    public void warn(Supplier<String> supplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(supplier.get());
        }
    }

    public void warn(Supplier<String> messageSupplier, Supplier<Throwable> throwableSupplier) {
        if (logger.isWarnEnabled()) {
            logger.warn(messageSupplier.get(), throwableSupplier.get());
        }
    }

    public void error(String msg) {
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    public void error(String format, Object...arguments) {
        if (logger.isErrorEnabled()) {
            logger.error(format, arguments);
        }
    }

    public void error(String msg, Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, t);
        }
    }

    public void error(Supplier<String> supplier) {
        if (logger.isErrorEnabled()) {
            logger.error(supplier.get());
        }
    }

    public void error(Supplier<String> messageSupplier, Supplier<Throwable> throwableSupplier) {
        if (logger.isErrorEnabled()) {
            logger.error(messageSupplier.get(), throwableSupplier.get());
        }
    }


}
