package org.sgmp.webapp.mapper.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.mapper.BaseMapper;
import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Nick
 *
 * @param <E>
 */
public interface SimpleCURDMapper<E> extends BaseMapper {

    /**
     * 
     * @param entity
     * @throws DataAccessException
     */
    public void create(E entity) throws DataAccessException;

    /**
     * 
     * @param entity
     * @throws DataAccessException
     */
    public void update(E entity) throws DataAccessException;

    /**
     * 
     * @param entity
     * @throws DataAccessException
     */
    public void delete(E entity) throws DataAccessException;


    /**
     * 
     * @param id
     * @throws DataAccessException
     */
    public void deleteById(Long id) throws DataAccessException;

    /**
     * 
     * @param id
     * @return
     * @throws DataAccessException
     */
    public E getById(Long id) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<E> getList(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getCount(Map<?, ?> params) throws DataAccessException;

}
