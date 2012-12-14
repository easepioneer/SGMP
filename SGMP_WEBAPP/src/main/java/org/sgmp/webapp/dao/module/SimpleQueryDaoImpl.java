package org.sgmp.webapp.dao.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.mapper.module.SimpleQueryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Nick
 *
 */
@Repository
public class SimpleQueryDaoImpl implements SimpleQueryDao {
    public static final int PAGE_SIZE_DEFAULT = 20;
    private static final Logger logger = LoggerFactory.getLogger(SimpleQueryDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<?> getList(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params, 
            String start, String limit, String sort, String dir) throws DaoException {
        params = ObjectUtils.defaultIfNull(params, new HashMap<String, Object>());
        int _start = 0;
        int _limit = PAGE_SIZE_DEFAULT;
        int _end = _start + _limit;
        try {
            _start = Integer.parseInt(start);
            _limit = Integer.parseInt(limit);
            _end = _start + _limit;
        }
        catch(NumberFormatException _nfe) {
            logger.error("getList error", _nfe);
            throw new DaoException("DaoException", _nfe.getCause());
        }
        params.put("_start", _start);
        params.put("_end", _end);
        params.put("_sort", sort);
        params.put("_dir", dir);
        return sqlSessionTemplate.getMapper(mapperClass).getList(params);
    }

    @Override
    public Integer getCount(Class<? extends SimpleQueryMapper> mapperClass, Map<String, Object> params) throws DaoException {
        return sqlSessionTemplate.getMapper(mapperClass).getCount(params);
    }

}
