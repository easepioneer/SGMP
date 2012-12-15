package org.sgmp.webapp.action.module;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 集中器参数设置
 * 
 * @author Nick
 *
 */
@Component
public class TerminalParameterSetupAction extends AbstractSimpleInteractionAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5227015749661420465L;

    private static final Logger logger = LoggerFactory.getLogger(TerminalParameterSetupAction.class);

    /**
     * 
     * @throws ActionException
     */
    public void send() throws ActionException {
        String action = request.getParameter("action");
        String logicalAddr = request.getParameter("logicalAddr");
        String paramsAndValues = request.getParameter("paramsAndValues");
        logger.debug("action          : " + action);
        logger.debug("logicalAddr     : " + logicalAddr);
        logger.debug("paramsAndValues : " + paramsAndValues);
        if(StringUtils.equals(action, "setting")) {
            logger.debug("集中器参数设置");
        }
        else {
            logger.debug("集中器参数读取");
        }
        responseText("ok");
    }
}
