package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.SimpleInteractionMapper;
import org.sgmp.webapp.service.BaseService;

/**
 * Service简单交互操作接口
 *      - 集中器参数设置 | 保护器参数设置 | 台区考核表数据召测 | 保护器数据召测等。
 * 
 * @author Nick
 * 
 */
public interface SimpleInteractionService extends BaseService {

    /**
     * 
     * @param mapperClass
     * @param params
     * @param start
     * @param limit
     * @param sort
     * @param dir
     * @return
     * @throws ServiceException
     */
    public List<?> getInteractionObjectList(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params, String start, String limit, String sort, String dir) throws ServiceException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getInteractionObjectCount(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param mapperClass
     * @param params
     * @return
     * @throws ServiceException
     */
    public Map<?, ?> getInteractionObject(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws ServiceException;

}
