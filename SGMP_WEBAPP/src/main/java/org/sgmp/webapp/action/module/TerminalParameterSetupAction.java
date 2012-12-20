package org.sgmp.webapp.action.module;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.RealTimeInterface;

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

    @Autowired
    private RealTimeInterface realTimeProxy376;

    private String action;
    private String paramsAndValues;

    /**
     * 
     * @throws ActionException
     */
    public void send() throws ActionException {
        if(StringUtils.equals(action, "setting")) {
            logger.debug("集中器参数设置");
        }
        else {
            logger.debug("集中器参数读取");
        }
        responseText("ok");
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParamsAndValues() {
        return paramsAndValues;
    }

    public void setParamsAndValues(String paramsAndValues) {
        this.paramsAndValues = paramsAndValues;
    }
}
