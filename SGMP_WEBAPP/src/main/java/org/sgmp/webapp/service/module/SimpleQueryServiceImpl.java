package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.dao.module.SimpleQueryDao;
import org.sgmp.webapp.mapper.module.SimpleQueryMapper;
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
public class SimpleQueryServiceImpl implements SimpleQueryService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleQueryServiceImpl.class);

    @Autowired
    public SimpleQueryDao simpleQueryDao;

    @Override
    public List<?> getList(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params, 
            String start, String limit, String sort, String dir) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getList");
        return simpleQueryDao.getList(mapperClass, params, start, limit, sort, dir);
    }

    @Override
    public Integer getCount(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getCount");
        return simpleQueryDao.getCount(mapperClass, params);
    }

}
