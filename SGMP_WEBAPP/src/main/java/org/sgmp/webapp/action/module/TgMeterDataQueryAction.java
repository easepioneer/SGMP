package org.sgmp.webapp.action.module;

import java.util.HashMap;
import java.util.Map;

import org.sgmp.webapp.mapper.module.TgMeterDataQueryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 台区考核表数据查询
 * 
 * @author Nick
 *
 */
@Component
public class TgMeterDataQueryAction extends AbstractSimpleQueryAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2709450024408938858L;

    private static final Logger logger = LoggerFactory.getLogger(TgMeterDataQueryAction.class);

    private String dataTable;           //
    private String startDate;           // 
    private String endDate;             // 

    @Override
    public void beforeGetGird() {
        logger.info(" ====== dataTable ====== : " + this.dataTable);
        logger.info(" ====== startDate ====== : " + this.startDate);
        logger.info(" ======= endDate ======= : " + this.endDate);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dataTable", dataTable);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        super.setMapperClass(TgMeterDataQueryMapper.class);
        super.setQueryParams(params);
    }

    @Override
    public void beforeGetChart() {
        beforeGetGird();
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
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
