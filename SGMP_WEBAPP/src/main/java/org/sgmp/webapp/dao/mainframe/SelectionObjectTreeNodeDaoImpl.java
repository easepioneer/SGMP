package org.sgmp.webapp.dao.mainframe;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.sgmp.webapp.DaoException;
import org.sgmp.webapp.mapper.mainframe.SelectionObjectTreeNodeMapper;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;
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
public class SelectionObjectTreeNodeDaoImpl implements SelectionObjectTreeNodeDao {

    private static final Logger logger = LoggerFactory.getLogger(SelectionObjectTreeNodeDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Orgnization(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Orgnization");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Orgnization(params);
    }

    @Override
    public Integer getTreeNodeCount_Orgnization(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Orgnization");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Orgnization(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Tg(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Tg");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Tg(params);
    }

    @Override
    public Integer getTreeNodeCount_Tg(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Tg");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Tg(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Terminal(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Terminal");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Terminal(params);
    }

    @Override
    public Integer getTreeNodeCount_Terminal(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Terminal");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Terminal(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Meter(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Meter");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Meter(params);
    }

    @Override
    public Integer getTreeNodeCount_Meter(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Meter");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Meter(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Protector(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Protector");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Protector(params);
    }

    @Override
    public Integer getTreeNodeCount_Protector(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Protector");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Protector(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Analogue(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Analogue");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Analogue(params);
    }

    @Override
    public Integer getTreeNodeCount_Analogue(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Analogue");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Analogue(params);
    }

    @Override
    public List<SelectionObjectTreeNode> getTreeNodeList_Switch(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeList_Switch");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeList_Switch(params);
    }

    @Override
    public Integer getTreeNodeCount_Switch(Map<?, ?> params) throws DaoException {
        logger.debug(this.getClass().getName() + "." + "getTreeNodeCount_Switch");
        return sqlSessionTemplate.getMapper(SelectionObjectTreeNodeMapper.class).getTreeNodeCount_Switch(params);
    }

}
