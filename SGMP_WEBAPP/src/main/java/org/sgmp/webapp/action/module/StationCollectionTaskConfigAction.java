package org.sgmp.webapp.action.module;

import org.sgmp.webapp.ActionException;
import org.springframework.stereotype.Component;

/**
 * 主站任务配置
 * @author Nick
 *
 */
@Component
public class StationCollectionTaskConfigAction extends AbstractSimpleInteractionAction {

    /**
     * 
     */
    private static final long serialVersionUID = -3095776939950182057L;

    /**
     * 
     * @return
     * @throws ActionException
     */
    public String init() throws ActionException {
        return SUCCESS;
    }

}
