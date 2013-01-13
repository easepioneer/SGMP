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
     * @return
     * @throws DataAccessException
     */
    public List<SelectionObjectTreeNode> getTreeNode_Orgnization(Map<?, ?> params) throws DataAccessException;

    public List<SelectionObjectTreeNode> getTreeNode_Tg(Map<?, ?> params) throws DataAccessException;

    public List<SelectionObjectTreeNode> getTreeNode_Terminal(Map<?, ?> params) throws DataAccessException;

    public List<SelectionObjectTreeNode> getTreeNode_Meter(Map<?, ?> params) throws DataAccessException;

    public List<SelectionObjectTreeNode> getTreeNode_Protector(Map<?, ?> params) throws DataAccessException;

}
