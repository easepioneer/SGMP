package org.sgmp.webapp.action.module;

import org.sgmp.webapp.ActionException;

/**
 * Action简单查询接口
 *      - 
 * 
 * @author Nick
 *
 */
public interface SimpleQuery {

    /**
     * 
     * @throws ActionException
     */
    public void getGrid() throws ActionException;

    /**
     * 
     * @throws ActionException
     */
    public void getChart() throws ActionException;

}
