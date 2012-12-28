package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.dao.BaseDao;
import org.sgmp.webapp.mapper.module.SimpleCURDMapper;

/**
 * DAO简单CURD操作接口
 *      - 代表创建（Create）、更新（Update）、读取（Read）和删除（Delete）操作。
 *      - CURD 定义了用于处理数据的基本原子操作。
 * 
 * @author Nick
 *
 */
public interface SimpleCURDDao<E> extends BaseDao {

    /**
     * 创建实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws DaoException
     */
    public boolean create(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException;

    /**
     * 更新实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws DaoException
     */
    public boolean update(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException;

    /**
     * 删除实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws DaoException
     */
    public boolean delete(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException;

    /**
     * 删除实体对象
     * 
     * @param id
     * @return
     * @throws DaoException
     */
    public boolean deleteById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws DaoException;

    /**
     * 获取实体对象
     * 
     * @param mapperClass
     * @param id
     * @return
     * @throws DaoException
     */
    public E getById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws DaoException;

    /**
     * 获取实体对象列表
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws DaoException
     */
    public List<E> getList(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getCount(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws DaoException;

}
