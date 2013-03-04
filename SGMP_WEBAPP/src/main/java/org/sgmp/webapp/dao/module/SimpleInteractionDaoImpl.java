package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.mapper.module.SimpleInteractionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nick
 *
 */
@Repository
public class SimpleInteractionDaoImpl implements SimpleInteractionDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<?> getInteractionObjectList(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params, 
            String start, String limit, String sort, String dir) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getInteractionObjectCount(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<?, ?> getInteractionObject(Class<? extends SimpleInteractionMapper> mapperClass, Map<?, ?> params) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

}
