package org.sgmp.webapp.action.mainframe;

import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.action.AbstractSimpleAction;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Nick
 *
 */
@Component
public class HomePageAction extends AbstractSimpleAction {

    /**
     * 
     */
    private static final long serialVersionUID = -1026911135635259545L;

    /**
     * 
     * @return
     * @throws ActionException
     */
    public String init() throws ActionException {
        return SUCCESS;
    }

}
