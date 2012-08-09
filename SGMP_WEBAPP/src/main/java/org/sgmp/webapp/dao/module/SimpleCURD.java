package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;

/**
 * DAO简单CURD操作接口
 *      - 代表创建（Create）、更新（Update）、读取（Read）和删除（Delete）操作。
 *      - CURD 定义了用于处理数据的基本原子操作。
 * 
 * @author Nick
 *
 */
public interface SimpleCURD<T> {

    /**
     * 创建实体对象
     * 
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public boolean create(T entity) throws DaoException;

    /**
     * 更新实体对象
     * 
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public boolean update(T entity) throws DaoException;

    /**
     * 删除实体对象
     * 
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public boolean delete(T entity) throws DaoException;

    /**
     * 删除实体对象
     * 
     * @param id
     * @return
     * @throws DaoException
     */
    public boolean delete(Long id) throws DaoException;

    /**
     * 获取实体对象
     * 
     * @param id
     * @return
     * @throws DataAccessException
     */
    public T get(Long id) throws DaoException;

    /**
     * 获取实体对象列表
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<T> getList(Map<?, ?> params) throws DaoException;

}
