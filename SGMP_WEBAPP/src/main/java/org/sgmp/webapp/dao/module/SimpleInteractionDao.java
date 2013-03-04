package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.dao.BaseDao;
import org.sgmp.webapp.mapper.module.SimpleInteractionMapper;

/**
 * DAO简单交互操作接口
 *      - 集中器参数设置 | 保护器参数设置 | 台区考核表数据召测 | 保护器数据召测等。
 * 
 * @author Nick
 * 
 */
public interface SimpleInteractionDao extends BaseDao {

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
    public List<?> getInteractionObjectList(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params, String start, String limit, String sort, String dir) throws DaoException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getInteractionObjectCount(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Map<?, ?> getInteractionObject(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws DaoException;

}
