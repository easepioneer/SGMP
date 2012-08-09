package org.sgmp.webapp;

/**
 * 
 * @author Nick
 *
 */
public class ServiceException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6278836975713382949L;

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
