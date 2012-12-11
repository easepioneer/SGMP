package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.dao.module.SimpleQueryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.inject.Inject;

/**
 * 
 * @author Nick
 *
 */
@Service
public class SimpleQueryServiceImpl implements SimpleQueryService {
    private static final Logger logger = LoggerFactory.getLogger(SimpleQueryServiceImpl.class);

    @Inject
    private SimpleQueryDao simpleQueryDao;

    @Override
    public List<?> getList(String namespace, String statement, Map<?, ?> params, 
            String start, String limit, String sort, String dir) throws ServiceException {
        logger.info(namespace + "." + statement);
        return simpleQueryDao.getList(namespace, statement, params, start, limit, sort, dir);
    }

}
