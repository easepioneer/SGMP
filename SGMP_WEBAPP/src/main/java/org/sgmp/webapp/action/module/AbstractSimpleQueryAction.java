package org.sgmp.webapp.action.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.action.AbstractSimpleAction;
import org.sgmp.webapp.mapper.module.SimpleQueryMapper;
import org.sgmp.webapp.service.module.SimpleQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Nick
 *
 */
public abstract class AbstractSimpleQueryAction extends AbstractSimpleAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1503381915421446105L;

    private static final Logger logger = LoggerFactory.getLogger(AbstractSimpleQueryAction.class);

    @Autowired
    private SimpleQueryService simpleQueryService;

    private Class<? extends SimpleQueryMapper> mapperClass;
    private Map<String, Object> queryParams;

    private String soType;              // selection object type
    private String soId;                // selection object id
    private String soName;              // selection object name
    private String soOrgId;             // selection object orgId
    private String soTgId;              // selection object tgId
    private String soTermId;            // selection object termId
    private String soGpId;              // selection object gpId
    private String start;
    private String limit;
    private String sort;
    private String dir;

    /**
     * 
     * @throws ActionException
     */
    public void getGrid() throws ActionException {
        beforeGetGird();
        queryParams = ObjectUtils.defaultIfNull(queryParams, new HashMap<String, Object>());
        queryParams.put("soType", soType);
        queryParams.put("soId", soId);
        queryParams.put("soName", soName);
        queryParams.put("soOrgId", soOrgId);
        queryParams.put("soTgId", soTgId);
        queryParams.put("soTermId", soTermId);
        queryParams.put("soGpId", soGpId);
        try {
            List<?> records = simpleQueryService.getList(mapperClass, queryParams, start, limit, sort, dir);
            Integer totalCount = simpleQueryService.getCount(mapperClass, queryParams);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("records", records);
            result.put("totalCount", totalCount);
            responseJson(result);
        }
        catch(ServiceException _se) {
            logger.error("getGrid error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
    }

    /**
     * 
     * @throws ActionException
     */
    public void getChart() throws ActionException {
        // TODO Auto-generated method stub
        beforeGetChart();
    }

    /**
     * 
     */
    public void beforeGetGird() {
        
    }

    /**
     * 
     */
    public void beforeGetChart() {
        
    }

    public void setMapperClass(Class<? extends SimpleQueryMapper> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
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
