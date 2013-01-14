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

    protected String soType;
    protected String soId;
    protected String soName;
    protected String soOrgId;
    protected String soTgId;
    protected String soTermId;
    protected String soGpId;

    /**
     * 
     */
    public SelectionObjectTreeNode() {
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

    @Override
    public String toString() {
        return "SelectionObjectTreeNode [soType=" + soType + ", soId=" + soId
                + ", soName=" + soName + ", soOrgId=" + soOrgId + ", soTgId="
                + soTgId + ", soTermId=" + soTermId + ", soGpId=" + soGpId
                + ", id=" + id + ", text=" + text + ", cls=" + cls
                + ", iconCls=" + iconCls + ", qtip=" + qtip + ", qtitle="
                + qtitle + ", leaf=" + leaf + ", expanded=" + expanded
                + ", children=" + children + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((soGpId == null) ? 0 : soGpId.hashCode());
        result = prime * result + ((soId == null) ? 0 : soId.hashCode());
        result = prime * result + ((soName == null) ? 0 : soName.hashCode());
        result = prime * result + ((soOrgId == null) ? 0 : soOrgId.hashCode());
        result = prime * result
                + ((soTermId == null) ? 0 : soTermId.hashCode());
        result = prime * result + ((soTgId == null) ? 0 : soTgId.hashCode());
        result = prime * result + ((soType == null) ? 0 : soType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        SelectionObjectTreeNode other = (SelectionObjectTreeNode) obj;
        if(soGpId == null) {
            if(other.soGpId != null)
                return false;
        }
        else if(!soGpId.equals(other.soGpId))
            return false;
        if(soId == null) {
            if(other.soId != null)
                return false;
        }
        else if(!soId.equals(other.soId))
            return false;
        if(soName == null) {
            if(other.soName != null)
                return false;
        }
        else if(!soName.equals(other.soName))
            return false;
        if(soOrgId == null) {
            if(other.soOrgId != null)
                return false;
        }
        else if(!soOrgId.equals(other.soOrgId))
            return false;
        if(soTermId == null) {
            if(other.soTermId != null)
                return false;
        }
        else if(!soTermId.equals(other.soTermId))
            return false;
        if(soTgId == null) {
            if(other.soTgId != null)
                return false;
        }
        else if(!soTgId.equals(other.soTgId))
            return false;
        if(soType == null) {
            if(other.soType != null)
                return false;
        }
        else if(!soType.equals(other.soType))
            return false;
        return true;
    }

}
