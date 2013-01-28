package org.sgmp.webapp.mapper.mainframe;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.mapper.BaseMapper;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;
import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Nick
 *
 */
public interface SelectionObjectTreeNodeMapper extends BaseMapper {

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Orgnization(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Orgnization(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Tg(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Tg(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Terminal(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Terminal(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Meter(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Meter(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Protector(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Protector(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Analogue(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Analogue(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNodeList_Switch(Map<?, ?> params) throws DataAccessException;

    /**
     * 
     * @param params
     * @return
     * @throws DataAccessException
     */
    public Integer getTreeNodeCount_Switch(Map<?, ?> params) throws DataAccessException;

}
