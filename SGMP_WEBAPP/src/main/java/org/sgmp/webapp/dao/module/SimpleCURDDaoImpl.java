package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.mapper.module.SimpleCURDMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nick
 *
 * @param <E>
 */
@Repository
public class SimpleCURDDaoImpl<E> implements SimpleCURDDao<E> {

    private static final Logger logger = LoggerFactory.getLogger(SimpleCURDDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
 
    @Override
    public boolean create(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException {
        try {
            sqlSessionTemplate.getMapper(mapperClass).create(entity);
            return true;
        }
        catch(DataAccessException _dae) {
            logger.error("create error", _dae);
            throw new DaoException("DaoException", _dae.getCause());
        }
    }

    @Override
    public boolean update(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException {
        try {
            sqlSessionTemplate.getMapper(mapperClass).update(entity);
            return true;
        }
        catch(DataAccessException _dae) {
            logger.error("update error", _dae);
            throw new DaoException("DaoException", _dae.getCause());
        }
    }

    @Override
    public boolean delete(Class<? extends SimpleCURDMapper<E>> mapperClass, E entity) throws DaoException {
        try {
            sqlSessionTemplate.getMapper(mapperClass).delete(entity);
            return true;
        }
        catch(DataAccessException _dae) {
            logger.error("delete error", _dae);
            throw new DaoException("DaoException", _dae.getCause());
        }
    }

    @Override
    public boolean deleteById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws DaoException {
        try {
            sqlSessionTemplate.getMapper(mapperClass).deleteById(id);
            return true;
        }
        catch(DataAccessException _dae) {
            logger.error("deleteById error", _dae);
            throw new DaoException("DaoException", _dae.getCause());
        }
    }

    @Override
    public E getById(Class<? extends SimpleCURDMapper<E>> mapperClass, Long id) throws DaoException {
        return sqlSessionTemplate.getMapper(mapperClass).getById(id);
    }

    @Override
    public List<E> getList(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws DaoException {
        return sqlSessionTemplate.getMapper(mapperClass).getList(params);
    }

    @Override
    public Integer getCount(Class<? extends SimpleCURDMapper<E>> mapperClass, Map<?, ?> params) throws DaoException {
        return sqlSessionTemplate.getMapper(mapperClass).getCount(params);
    }

}
