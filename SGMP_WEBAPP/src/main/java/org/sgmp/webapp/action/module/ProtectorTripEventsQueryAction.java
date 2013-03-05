package org.sgmp.webapp.action.module;

import java.util.HashMap;
import java.util.Map;

import org.sgmp.webapp.mapper.module.ProtectorTripEventsQueryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 保护器跳闸事件查询
 * 
 * @author Nick
 *
 */
@Component
public class ProtectorTripEventsQueryAction extends AbstractSimpleQueryAction {

    /**
     * ProtectorTripEventsQuery
     */
    private static final long serialVersionUID = -2475334611384812979L;

    private static final Logger logger = LoggerFactory.getLogger(ProtectorTripEventsQueryAction.class);

    private String startDate;           // 
    private String endDate;             // 

    @Override
    public void beforeGetGird() {
        logger.info(" ====== startDate ====== : " + this.startDate);
        logger.info(" ======= endDate ======= : " + this.endDate);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        super.setMapperClass(ProtectorTripEventsQueryMapper.class);
        super.setQueryParams(params);
    }

    @Override
    public void beforeGetChart() {
        beforeGetGird();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
