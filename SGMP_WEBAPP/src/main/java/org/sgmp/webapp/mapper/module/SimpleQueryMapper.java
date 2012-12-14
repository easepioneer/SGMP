package org.sgmp.webapp.mapper.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.mapper.BaseMapper;
import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Nick
 *
 */
public interface SimpleQueryMapper extends BaseMapper {

    /**
     * 
     * @param params
     * @return
     * @throws MapperException
     */
    public List<?> getList(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws MapperException
     */
    public Integer getCount(Map<?, ?> params) throws DataAccessException;

}
