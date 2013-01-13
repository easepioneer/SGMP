package org.sgmp.webapp.pojo.module;

import org.sgmp.webapp.pojo.tree.TreeNode;

/**
 * 
 * @author Nick
 *
 */
public class OrgnizationTreeNode extends TreeNode {

    /**
     * 
     */
    private static final long serialVersionUID = -3236603443459881209L;

    private Long orgId;                         // ORG_ID
    private String orgNo;                       // ORG_NO
    private String orgName;                     // ORG_NAME
    private String orgType;                     // ORG_TYPE
    private Long parentId;                      // P_ORG_ID
    private Integer sortNo;                     // SORT_NO

    public OrgnizationTreeNode() {
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

}
