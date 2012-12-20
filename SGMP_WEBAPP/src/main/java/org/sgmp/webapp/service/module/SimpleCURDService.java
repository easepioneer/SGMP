package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.service.BaseService;

/**
 * Service简单CURD操作接口
 *      - 代表创建（Create）、更新（Update）、读取（Read）和删除（Delete）操作。
 *      - CURD 定义了用于处理数据的基本原子操作。
 * 
 * @author Nick
 *
 */
public interface SimpleCURDService<T> extends BaseService {

    /**
     * 创建实体对象
     * 
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean create(T entity) throws ServiceException;

    /**
     * 更新实体对象
     * 
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean update(T entity) throws ServiceException;

    /**
     * 删除实体对象
     * 
     * @param entity
     * @return
     * @throws ServiceException
     */
    public boolean delete(T entity) throws ServiceException;

    /**
     * 删除实体对象
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public boolean delete(Long id) throws ServiceException;

    /**
     * 获取实体对象
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public T get(Long id) throws ServiceException;

    /**
     * 获取实体对象列表
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<T> getList(Map<?, ?> params) throws ServiceException;

}
