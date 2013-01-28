package org.sgmp.webapp.service.mainframe;

import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.dao.mainframe.SelectionObjectTreeNodeDao;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Nick
 *
 */
@Service
public class SelectionObjectTreeNodeServiceImpl implements SelectionObjectTreeNodeService {

    private static final Logger logger = LoggerFactory.getLogger(SelectionObjectTreeNodeServiceImpl.class);

    @Autowired
    private SelectionObjectTreeNodeDao selectionObjectTreeNodeDao;

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Orgnization(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Orgnization");
        return selectionObjectTreeNodeDao.getTreeNodeList_Orgnization(params);
    }

    @Override
    public Integer getTreeNodeCount_Orgnization(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Orgnization");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Orgnization(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Tg(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Tg");
        return selectionObjectTreeNodeDao.getTreeNodeList_Tg(params);
    }

    @Override
    public Integer getTreeNodeCount_Tg(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Tg");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Tg(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Terminal(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Terminal");
        return selectionObjectTreeNodeDao.getTreeNodeList_Terminal(params);
    }

    @Override
    public Integer getTreeNodeCount_Terminal(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Terminal");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Terminal(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Meter(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Meter");
        return selectionObjectTreeNodeDao.getTreeNodeList_Meter(params);
    }

    @Override
    public Integer getTreeNodeCount_Meter(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Meter");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Meter(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Protector(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Protector");
        return selectionObjectTreeNodeDao.getTreeNodeList_Protector(params);
    }

    @Override
    public Integer getTreeNodeCount_Protector(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Protector");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Protector(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Analogue(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Analogue");
        return selectionObjectTreeNodeDao.getTreeNodeList_Analogue(params);
    }

    @Override
    public Integer getTreeNodeCount_Analogue(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Analogue");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Analogue(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Switch(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Switch");
        return selectionObjectTreeNodeDao.getTreeNodeList_Switch(params);
    }

    @Override
    public Integer getTreeNodeCount_Switch(Map<?, ?> params) throws ServiceException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Switch");
        return selectionObjectTreeNodeDao.getTreeNodeCount_Switch(params);
    }

}
