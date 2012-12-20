package org.sgmp.webapp.action.module;

import org.sgmp.webapp.action.AbstractSimpleAction;
import org.sgmp.webapp.service.module.SimpleInteractionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Nick
 *
 */
public abstract class AbstractSimpleInteractionAction extends AbstractSimpleAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3446273927169317499L;

    @Autowired
    private SimpleInteractionService simpleInteractionService;

    private String soType;              // selection object type
    private String soId;                // selection object id
    private String soName;              // selection object name
    private String soOrgId;             // selection object orgId
    private String soTgId;              // selection object tgId
    private String soTermId;            // selection object termId
    private String soGpId;              // selection object gpId

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
