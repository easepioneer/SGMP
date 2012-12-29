package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.SimpleCURDMapper;
import org.sgmp.webapp.service.BaseService;

/**
 * Service简单CURD操作接口
 *      - 代表创建（Create）、更新（Update）、读取（Read）和删除（Delete）操作。
 *      - CURD 定义了用于处理数据的基本原子操作。
 * 
 * @author Nick
 *
 * @param <E>
 */
public interface SimpleCURDService<E> extends BaseService {

    /**
     * 创建实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean create(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException;

    /**
     * 更新实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean update(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException;

    /**
     * 删除实体对象
     * 
     * @param mapperClass
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean delete(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException;

    /**
     * 删除实体对象
     * 
     * @param mapperClass
     * @param id
     * @return
     * @throws ServiceException
     */
    public boolean deleteById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws ServiceException;

    /**
     * 获取实体对象
     * 
     * @param mapperClass
     * @param id
     * @return
     * @throws ServiceException
     */
    public E getById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws ServiceException;

    /**
     * 获取实体对象列表
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<E> getList(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getCount(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws ServiceException;

}
