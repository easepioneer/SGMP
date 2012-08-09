package org.sgmp.webapp;

/**
 * 
 * @author Nick
 *
 */
public class ActionException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8407497331067119954L;

    public ActionException(String msg) {
        super(msg);
    }

    public ActionException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
