package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构
 * 
 * @author Nick
 *
 */
public class Orgnization implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2166009965110497109L;

    private Long id;                            // ORG_ID
    private String orgNo;                       // ORG_NO
    private String orgName;                     // ORG_NAME
    private String orgType;                     // ORG_TYPE
    private Long parentId;                      // P_ORG_ID
    private Integer sortNo;                     // SORT_NO
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Orgnization() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Orgnization [id=" + id + ", orgNo=" + orgNo + ", orgName="
                + orgName + ", orgType=" + orgType + ", parentId=" + parentId
                + ", sortNo=" + sortNo + ", lastTimestamp=" + lastTimestamp
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
        result = prime * result + ((orgNo == null) ? 0 : orgNo.hashCode());
        result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
        result = prime * result
                + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((sortNo == null) ? 0 : sortNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Orgnization other = (Orgnization) obj;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(lastTimestamp == null) {
            if(other.lastTimestamp != null)
                return false;
        }
        else if(!lastTimestamp.equals(other.lastTimestamp))
            return false;
        if(orgName == null) {
            if(other.orgName != null)
                return false;
        }
        else if(!orgName.equals(other.orgName))
            return false;
        if(orgNo == null) {
            if(other.orgNo != null)
                return false;
        }
        else if(!orgNo.equals(other.orgNo))
            return false;
        if(orgType == null) {
            if(other.orgType != null)
                return false;
        }
        else if(!orgType.equals(other.orgType))
            return false;
        if(parentId == null) {
            if(other.parentId != null)
                return false;
        }
        else if(!parentId.equals(other.parentId))
            return false;
        if(sortNo == null) {
            if(other.sortNo != null)
                return false;
        }
        else if(!sortNo.equals(other.sortNo))
            return false;
        return true;
    }

}
