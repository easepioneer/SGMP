package org.sgmp.webapp.pojo.mainframe;

import org.sgmp.webapp.pojo.tree.TreeNode;

/**
 * 
 * @author Nick
 *
 */
public class SelectionObjectTreeNode extends TreeNode {

    /**
     * 
     */
    private static final long serialVersionUID = -1962897310526417104L;

    private String soType;
    private String soId;
    private String soName;
    private String soOrgId;
    private String soTgId;
    private String soTermId;
    private String soGpId;

    /**
     * 
     */
    public SelectionObjectTreeNode() {
        super();
    }

    /**
     * 
     * @param id
     * @param text
     * @param leaf
     * @param soType
     * @param soId
     * @param soName
     */
    public SelectionObjectTreeNode(String id, String text, boolean leaf, String soType, String soId, String soName) {
        super(id, text, leaf);
        this.soType = soType;
        this.soId = soId;
        this.soName = soName;
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
