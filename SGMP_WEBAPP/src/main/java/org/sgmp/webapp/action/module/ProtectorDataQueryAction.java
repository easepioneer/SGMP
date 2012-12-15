package org.sgmp.webapp.action.module;

import java.util.HashMap;
import java.util.Map;

import org.sgmp.webapp.mapper.module.ProtectorDataQueryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 保护器数据查询
 * 
 * @author Nick
 *
 */
@Component
public class ProtectorDataQueryAction extends AbstractSimpleQueryAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5201739290584707882L;

    private static final Logger logger = LoggerFactory.getLogger(ProtectorDataQueryAction.class);

    private String startDate;           // 
    private String endDate;             // 

    @Override
    public void beforeGetGird() {
        logger.info(" ====== startDate ====== : " + this.startDate);
        logger.info(" ======= endDate ======= : " + this.endDate);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        super.setMapperClass(ProtectorDataQueryMapper.class);
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
