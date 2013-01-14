package org.sgmp.webapp.action.mainframe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.action.AbstractSimpleAction;
import org.sgmp.webapp.pojo.mainframe.SelectionObjectTreeNode;
import org.sgmp.webapp.service.mainframe.SelectionObjectTreeNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Nick
 *
 */
@Component
public class LeftViewAction extends AbstractSimpleAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3828594187837763861L;

    private static final Logger logger = LoggerFactory.getLogger(LeftViewAction.class);

    @Autowired
    private SelectionObjectTreeNodeService sotnService;

    private String id;                  // 
    private String soType;              // selection object type
    private String soId;                // selection object id
    private String soName;              // selection object name
    private String soOrgId;             // selection object orgId
    private String soTgId;              // selection object tgId
    private String soTermId;            // selection object termId
    private String soGpId;              // selection object gpId

    public void getRoot() throws ActionException {
        logger.debug(" ==================== getRoot ==================== ");
        List<SelectionObjectTreeNode> rootList = new ArrayList<SelectionObjectTreeNode>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isRootNode", true);
        params.put("rootSoId", "1");
        try {
            rootList = sotnService.getTreeNodeList_Orgnization(params);
        }
        catch(ServiceException _se) {
            logger.error("getRoot error", _se);
            throw new ActionException("ActionException", _se.getCause());
        }
        finally {
            responseJson(rootList);
        }
    }

    /**
     * 
     * @throws ActionException
     */
    public void getTree() throws ActionException {
        logger.debug(" ==================== getTree ==================== ");
        logger.debug("id         : " + id);
        logger.debug("soType     : " + soType);
        logger.debug("soId       : " + soId);
        logger.debug("soName     : " + soName);
        logger.debug("soOrgId    : " + soOrgId);
        logger.debug("soTgId     : " + soTgId);
        logger.debug("soTermId   : " + soTermId);
        logger.debug("soGpId     : " + soGpId);
        if(StringUtils.equals(id, "root")) {
            getRoot();
            return;
        }
        else {
            List<SelectionObjectTreeNode> nodeList = new ArrayList<SelectionObjectTreeNode>();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("parentSoId", soId);
            try {
                if(StringUtils.equals(soType, "org")) {
                    nodeList.addAll(sotnService.getTreeNodeList_Orgnization(params));
                    nodeList.addAll(sotnService.getTreeNodeList_Tg(params));
                }
                else if(StringUtils.equals(soType, "tg")) {
                    nodeList.addAll(sotnService.getTreeNodeList_Terminal(params));
                }
                else if(StringUtils.equals(soType, "term")) {
                    nodeList.addAll(sotnService.getTreeNodeList_Meter(params));
                    nodeList.addAll(sotnService.getTreeNodeList_Protector(params));
                }
            }
            catch(ServiceException _se) {
                logger.error("getTree error", _se);
                throw new ActionException("ActionException", _se.getCause());
            }
            finally {
                responseJson(nodeList);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoType() {
        return soType;
    }

    public void setSoType(String soType) {
        this.soType = soType;
    }

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public String getSoName() {
        return soName;
    }

    public void setSoName(String soName) {
        this.soName = soName;
    }

    public String getSoOrgId() {
        return soOrgId;
    }

    public void setSoOrgId(String soOrgId) {
        this.soOrgId = soOrgId;
    }

    public String getSoTgId() {
        return soTgId;
    }

    public void setSoTgId(String soTgId) {
        this.soTgId = soTgId;
    }

    public String getSoTermId() {
        return soTermId;
    }

    public void setSoTermId(String soTermId) {
        this.soTermId = soTermId;
    }

    public String getSoGpId() {
        return soGpId;
    }

    public void setSoGpId(String soGpId) {
        this.soGpId = soGpId;
    }

}
