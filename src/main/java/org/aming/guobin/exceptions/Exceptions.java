package org.aming.guobin.exceptions;

import java.sql.SQLException;

/**
 * @author aming
 * @date 2018-06-19 15:04
 */
public class Exceptions {

    public static SQLException getSQLException(Throwable cause) {
        return cause instanceof SQLException ? (SQLException)cause : new SQLException(cause);
    }
}
