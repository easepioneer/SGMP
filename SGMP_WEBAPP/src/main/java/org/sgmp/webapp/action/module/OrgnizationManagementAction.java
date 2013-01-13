package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.OrgnizationMapper;
import org.sgmp.webapp.pojo.module.Orgnization;
import org.sgmp.webapp.pojo.module.OrgnizationTreeNode;
import org.sgmp.webapp.service.module.SimpleCURDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 组织机构管理
 * 
 * @author Nick
 *
 */
@Component
public class OrgnizationManagementAction extends AbstractSimpleCURDAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -9217429305699907213L;

    private static final Logger logger = LoggerFactory.getLogger(OrgnizationManagementAction.class);

    @Autowired
    private SimpleCURDService<Orgnization> orgService;

    /**
     * 
     * @throws ActionException
     */
    public void getList() throws ActionException {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            List<Orgnization> list = orgService.getList(OrgnizationMapper.class, null);
            result.put("list", list);
        }
        catch(ServiceException _se) {
            logger.error("getList error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseJson(result);
        }
    }

    /**
     * 
     * @throws ActionException
     */
    public void getTree() throws ActionException {
        Map<String, Object> result = new HashMap<String, Object>();
        List<OrgnizationTreeNode> otnList = getOrgnizationTreeNodeList(0L);
        result.put("tree", otnList);
        responseJson(result);
    }

    /**
     * 
     * @param parentId
     * @return
     */
    public List<OrgnizationTreeNode> getOrgnizationTreeNodeList(Long parentId) {
        List<OrgnizationTreeNode> otnList = new ArrayList<OrgnizationTreeNode>();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentId", parentId);

        List<Orgnization> oList = new ArrayList<Orgnization>();
        try {
            oList = orgService.getList(OrgnizationMapper.class, params);
        }
        catch(ServiceException _se) {
            logger.error("getList error", _se);
        }

        for(Orgnization o : oList) {
            OrgnizationTreeNode otn = new OrgnizationTreeNode();
            otn.setId(String.valueOf(o.getId()));
            otn.setText(o.getOrgName());
            otn.setOrgId(o.getId());
            otn.setOrgNo(o.getOrgNo());
            otn.setOrgName(o.getOrgName());
            otn.setOrgType(o.getOrgType());
            otn.setParentId(o.getParentId());
            otn.setSortNo(o.getSortNo());
            otn.setChildren(getOrgnizationTreeNodeList(o.getId()));
            otnList.add(otn);
        }

        return otnList;
    }

}
