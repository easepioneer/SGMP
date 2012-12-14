package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.dao.BaseDao;
import org.sgmp.webapp.mapper.module.SimpleQueryMapper;

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
     * @param mapperClass
     * @param params
     * @param start
     * @param limit
     * @param sort
     * @param dir
     * @return
     * @throws DaoException
     */
    public List<?> getList(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params, String start, String limit, String sort, String dir) throws DaoException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getCount(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params) throws DaoException;

}
