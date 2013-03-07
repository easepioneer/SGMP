package org.sgmp.webapp.action.module;

import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.mapper.module.ProtectorDataReadingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 保护器数据召测
 * 
 * @author Nick
 *
 */
@Component
public class ProtectorDataReadingAction extends AbstractSimpleInteractionAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4035450730493190110L;

    private static final Logger logger = LoggerFactory.getLogger(ProtectorDataReadingAction.class);

    @Override
    public void beforeGetGird() {
        super.setMapperClass(ProtectorDataReadingMapper.class);
    }

    @Override
    public void beforeSend() throws ActionException {
        // TODO Auto-generated method stub
        super.beforeSend();
    }

    @Override
    public void beforeReceive() throws ActionException {
        // TODO Auto-generated method stub
        super.beforeReceive();
    }

    @Override
    public void afterSend() throws ActionException {
        // TODO Auto-generated method stub
        super.afterSend();
    }

    @Override
    public void afterReceive() throws ActionException {
        // TODO Auto-generated method stub
        super.afterReceive();
    }

}
