package org.sgmp.webapp.service.module;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;

public class SimpleCURDServiceImpl<T> implements SimpleCURDService<T> {

    @Override
    public boolean create(T entity) throws ServiceException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(T entity) throws ServiceException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(T entity) throws ServiceException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Long id) throws ServiceException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T get(Long id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getList(Map<?, ?> params) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

}
