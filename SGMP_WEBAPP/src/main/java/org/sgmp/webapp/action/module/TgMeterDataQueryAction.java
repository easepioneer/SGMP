package org.sgmp.webapp.action.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.action.AbstractSimpleAction;
import org.sgmp.webapp.service.module.SimpleQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 台区考核表数据查询
 * 
 * @author Nick
 *
 */
@Component
public class TgMeterDataQueryAction extends AbstractSimpleAction implements SimpleQuery {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2709450024408938858L;

    private static final Logger logger = LoggerFactory.getLogger(TgMeterDataQueryAction.class);

    @Autowired
    private SimpleQueryService simpleQueryService;

    private String soType;              // selection object type
    private String soId;                // selection object id
    private String soName;              // selection object name
    private String soOrgId;             // selection object orgId
    private String soTgId;              // selection object tgId
    private String soTermId;            // selection object termId
    private String soGpId;              // selection object gpId
    private String startDate;           // 
    private String endDate;             // 
    private String start;
    private String limit;
    private String sort;
    private String dir;

    @Override
    public void getGrid() throws ActionException {
        logger.info(" selection object type   : " + this.soType);
        logger.info(" selection object id     : " + this.soId);
        logger.info(" selection object name   : " + this.soName);
        logger.info(" selection object orgId  : " + this.soOrgId);
        logger.info(" selection object tgId   : " + this.soTgId);
        logger.info(" selection object termId : " + this.soTermId);
        logger.info(" selection object gpId   : " + this.soGpId);
        logger.info(" ====== startDate ====== : " + this.startDate);
        logger.info(" ======= endDate ======= : " + this.endDate);
        logger.info(" start                   : " + this.start);
        logger.info(" limit                   : " + this.limit);
        logger.info(" sort                    : " + this.sort);
        logger.info(" dir                     : " + this.dir);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("soType", soType);
        params.put("soId", soId);
        params.put("soName", soName);
        params.put("soOrgId", soOrgId);
        params.put("soTgId", soTgId);
        params.put("soTermId", soTermId);
        params.put("soGpId", soGpId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        try {
            List<?> list = simpleQueryService.getList("TgMeterDataQueryMapper", "getList", params, start, limit, sort, dir);
            responseJson(list);
        }
        catch(ServiceException _se) {
            logger.error("getGrid error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
    }

    @Override
    public void getChart() throws ActionException {
        // TODO Auto-generated method stub
        
    }

    public String getSoType() {
        return soType;
    }

    public void setSoType(String soType) {
        this.soType = soType;
    }

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    public String getSoOrgId() {
        return soOrgId;
    }

    public void setSoOrgId(String soOrgId) {
        this.soOrgId = soOrgId;
    }

    public String getSoTgId() {
        return soTgId;
    }

    public void setSoTgId(String soTgId) {
        this.soTgId = soTgId;
    }

    public String getSoTermId() {
        return soTermId;
    }

    public void setSoTermId(String soTermId) {
        this.soTermId = soTermId;
    }

    public String getSoGpId() {
        return soGpId;
    }

    public void setSoGpId(String soGpId) {
        this.soGpId = soGpId;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

}
