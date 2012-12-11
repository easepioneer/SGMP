package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
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
     * @param namespace
     * @param statement
     * @param params
     * @param start
     * @param limit
     * @param sort
     * @param dir
     * @return
     * @throws ServiceException
     */
    public List<?> getList(String namespace, String statement, Map<?, ?> params, String start, String limit, String sort, String dir) throws ServiceException;

}
