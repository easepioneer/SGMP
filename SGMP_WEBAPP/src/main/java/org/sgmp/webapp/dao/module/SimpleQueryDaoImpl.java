package org.sgmp.webapp.dao.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nick
 *
 */
@Repository
public class SimpleQueryDaoImpl implements SimpleQueryDao {

    @Override
    public List<?> getList(String namespace, String statement, Map<?, ?> params, 
            String start, String limit, String sort, String dir) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

}
