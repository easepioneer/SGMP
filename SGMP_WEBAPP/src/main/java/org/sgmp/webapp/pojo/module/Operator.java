package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作员
 * 
 * @author Nick
 *
 */
public class Operator implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4331622605413560830L;

    private Long id;                            // EMP_NO
    private Long orgId;                         // ORG_ID
    private String no;                          // STAFF_NO
    private String name;                        // NAME
    private String password;                    // PASSWD
    private String gender;                      // GENDER
    private String mobile;                      // MOBILE
    private String remark;                      // REMARK
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Operator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Operator [id=" + id + ", orgId=" + orgId + ", no=" + no
                + ", name=" + name + ", password=" + password + ", gender="
                + gender + ", mobile=" + mobile + ", remark=" + remark
                + ", lastTimestamp=" + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((no == null) ? 0 : no.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
        Operator other = (Operator) obj;
        if(gender == null) {
            if(other.gender != null)
                return false;
        }
        else if(!gender.equals(other.gender))
            return false;
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
        if(mobile == null) {
            if(other.mobile != null)
                return false;
        }
        else if(!mobile.equals(other.mobile))
            return false;
        if(name == null) {
            if(other.name != null)
                return false;
        }
        else if(!name.equals(other.name))
            return false;
        if(no == null) {
            if(other.no != null)
                return false;
        }
        else if(!no.equals(other.no))
            return false;
        if(orgId == null) {
            if(other.orgId != null)
                return false;
        }
        else if(!orgId.equals(other.orgId))
            return false;
        if(password == null) {
            if(other.password != null)
                return false;
        }
        else if(!password.equals(other.password))
            return false;
        if(remark == null) {
            if(other.remark != null)
                return false;
        }
        else if(!remark.equals(other.remark))
            return false;
        return true;
    }

}
