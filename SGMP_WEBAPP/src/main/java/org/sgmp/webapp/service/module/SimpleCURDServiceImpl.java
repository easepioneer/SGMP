package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.dao.module.SimpleCURDDao;
import org.sgmp.webapp.mapper.module.SimpleCURDMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Nick
 *
 * @param <E>
 */
@Service
public class SimpleCURDServiceImpl<E> implements SimpleCURDService<E> {

    private static final Logger logger = LoggerFactory.getLogger(SimpleCURDServiceImpl.class);

    @Autowired
    protected SimpleCURDDao<E> simpleCURDDao;

    @Override
    public boolean create(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "create");
        return simpleCURDDao.create(mapperClass, entity);
    }

    @Override
    public boolean update(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "update");
        return simpleCURDDao.update(mapperClass, entity);
    }

    @Override
    public boolean delete(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "delete");
        return simpleCURDDao.delete(mapperClass, entity);
    }

    @Override
    public boolean deleteById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "deleteById");
        return simpleCURDDao.deleteById(mapperClass, id);
    }

    @Override
    public E getById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getById");
        return simpleCURDDao.getById(mapperClass, id);
    }

    @Override
    public List<E> getList(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getList");
        return simpleCURDDao.getList(mapperClass, params);
    }

    @Override
    public Integer getCount(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getCount");
        return simpleCURDDao.getCount(mapperClass, params);
    }

}
