package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.SimpleQueryMapper;
import org.sgmp.webapp.service.BaseService;

/**
 * Service简单查询接口
 *      - 
 * 
 * @author Nick
 *
 */
public interface SimpleQueryService extends BaseService {

    /**
     * 
     * @param mapperClass
     * @param params
     * @param start
     * @param limit
     * @param sort
     * @param dir
     * @return
     * @throws ServiceException
     */
    public List<?> getList(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params, String start, String limit, String sort, String dir) throws ServiceException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getCount(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params) throws ServiceException;

}
