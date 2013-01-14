package org.sgmp.webapp.dao.mainframe;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.dao.BaseDao;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;

/**
 * 对象选择树
 * 
 * @author Nick
 *
 */
public interface SelectionObjectTreeNodeDao extends BaseDao {

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Orgnization(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getTreeNodeCount_Orgnization(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Tg(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getTreeNodeCount_Tg(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Terminal(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getTreeNodeCount_Terminal(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Meter(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getTreeNodeCount_Meter(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Protector(Map<?, ?> params) throws DaoException;

    /**
     * 
     * @param params
     * @return
     * @throws DaoException
     */
    public Integer getTreeNodeCount_Protector(Map<?, ?> params) throws DaoException;

}
