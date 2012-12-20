package org.sgmp.webapp.mapper.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.mapper.BaseMapper;
import org.springframework.dao.DataAccessException;

public interface SimpleInteractionMapper extends BaseMapper {

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<?> getInteractionObjectList(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getInteractionObjectCount(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Map<?, ?> getInteractionObject(Map<?, ?> params) throws DataAccessException;

}
