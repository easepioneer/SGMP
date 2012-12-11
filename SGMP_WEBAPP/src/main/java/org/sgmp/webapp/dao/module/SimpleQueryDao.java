package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.dao.BaseDao;

/**
 * DAO简单查询接口
 *      - 
 * 
 * @author Nick
 *
 */
public interface SimpleQueryDao extends BaseDao {

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
     * @throws DaoException
     */
    public List<?> getList(String namespace, String statement, Map<?, ?> params, String start, String limit, String sort, String dir) throws DaoException;

}
