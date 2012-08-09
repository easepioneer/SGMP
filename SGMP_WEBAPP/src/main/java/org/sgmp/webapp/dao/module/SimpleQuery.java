package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;

/**
 * DAO简单查询接口
 *      - 
 * 
 * @author Nick
 *
 */
public interface SimpleQuery {

    /**
     * 查询获得查询结果
     * 
     * @param statement
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<?> getList(String statement, Map<?, ?> params) throws ServiceException;

}
