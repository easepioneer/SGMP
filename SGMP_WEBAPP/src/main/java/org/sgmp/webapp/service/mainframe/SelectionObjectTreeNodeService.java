package org.sgmp.webapp.service.mainframe;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;
import org.sgmp.webapp.service.BaseService;

/**
 * 
 * @author Nick
 *
 */
public interface SelectionObjectTreeNodeService extends BaseService {

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Orgnization(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Orgnization(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Tg(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Tg(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Terminal(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Terminal(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Meter(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Meter(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Protector(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Protector(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Analogue(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Analogue(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Switch(Map<?, ?> params) throws ServiceException;

    /**
     * 
     * @param params
     * @return
     * @throws ServiceException
     */
    public Integer getTreeNodeCount_Switch(Map<?, ?> params) throws ServiceException;

}
