package org.sgmp.webapp;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Nick
 *
 */
public class DaoException extends DataAccessException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4674279969176818794L;

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
