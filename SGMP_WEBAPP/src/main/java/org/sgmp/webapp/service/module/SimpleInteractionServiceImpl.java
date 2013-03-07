package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.dao.module.SimpleInteractionDao;
import org.sgmp.webapp.mapper.module.SimpleInteractionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Nick
 *
 */
@Service
public class SimpleInteractionServiceImpl implements SimpleInteractionService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleInteractionServiceImpl.class);

    @Autowired
    private SimpleInteractionDao simpleInteractionDao;

    @Override
    public List<?> getInteractionObjectList(Class<? extends SimpleInteractionMapper> mapperClass, Map<String, Object> params, 
            String start, String limit, String sort, String dir) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getInteractionObjectList");
        return simpleInteractionDao.getInteractionObjectList(mapperClass, params, start, limit, sort, dir);
    }

    @Override
    public Integer getInteractionObjectCount(Class<? extends SimpleInteractionMapper> mapperClass, Map<String, Object> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getInteractionObjectCount");
        return simpleInteractionDao.getInteractionObjectCount(mapperClass, params);
    }

    @Override
    public Map<String, Object> getInteractionObject(Class<? extends SimpleInteractionMapper> mapperClass, Map<String, Object> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getInteractionObject");
        return simpleInteractionDao.getInteractionObject(mapperClass, params);
    }

}
