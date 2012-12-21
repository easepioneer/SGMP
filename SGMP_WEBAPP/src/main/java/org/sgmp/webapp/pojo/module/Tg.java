package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 台区
 * 
 * @author Nick
 *
 */
public class Tg implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 222188900997574327L;

    private Long id;                            // TG_ID
    private Long orgId;                         // ORG_ID
    private String tgNo;                        // TG_NO
    private String tgName;                      // TG_NAME
    private Float tgCap;                        // TG_CAP
    private String instAddr;                    // INST_ADDR
    private Date chgDate;                       // CHG_DATE
    private String pubPrivFlag;                 // PUB_PRIV_FLAG
    private String runStatus;                   // RUN_STATUS_CODE
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Tg() {
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

    public String getTgNo() {
        return tgNo;
    }

    public void setTgNo(String tgNo) {
        this.tgNo = tgNo;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public Float getTgCap() {
        return tgCap;
    }

    public void setTgCap(Float tgCap) {
        this.tgCap = tgCap;
    }

    public String getInstAddr() {
        return instAddr;
    }

    public void setInstAddr(String instAddr) {
        this.instAddr = instAddr;
    }

    public Date getChgDate() {
        return chgDate;
    }

    public void setChgDate(Date chgDate) {
        this.chgDate = chgDate;
    }

    public String getPubPrivFlag() {
        return pubPrivFlag;
    }

    public void setPubPrivFlag(String pubPrivFlag) {
        this.pubPrivFlag = pubPrivFlag;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Tg [id=" + id + ", orgId=" + orgId + ", tgNo=" + tgNo
                + ", tgName=" + tgName + ", tgCap=" + tgCap + ", instAddr="
                + instAddr + ", chgDate=" + chgDate + ", pubPrivFlag="
                + pubPrivFlag + ", runStatus=" + runStatus + ", lastTimestamp="
                + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chgDate == null) ? 0 : chgDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((instAddr == null) ? 0 : instAddr.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result
                + ((pubPrivFlag == null) ? 0 : pubPrivFlag.hashCode());
        result = prime * result
                + ((runStatus == null) ? 0 : runStatus.hashCode());
        result = prime * result + ((tgCap == null) ? 0 : tgCap.hashCode());
        result = prime * result + ((tgName == null) ? 0 : tgName.hashCode());
        result = prime * result + ((tgNo == null) ? 0 : tgNo.hashCode());
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
        Tg other = (Tg) obj;
        if(chgDate == null) {
            if(other.chgDate != null)
                return false;
        }
        else if(!chgDate.equals(other.chgDate))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(instAddr == null) {
            if(other.instAddr != null)
                return false;
        }
        else if(!instAddr.equals(other.instAddr))
            return false;
        if(lastTimestamp == null) {
            if(other.lastTimestamp != null)
                return false;
        }
        else if(!lastTimestamp.equals(other.lastTimestamp))
            return false;
        if(orgId == null) {
            if(other.orgId != null)
                return false;
        }
        else if(!orgId.equals(other.orgId))
            return false;
        if(pubPrivFlag == null) {
            if(other.pubPrivFlag != null)
                return false;
        }
        else if(!pubPrivFlag.equals(other.pubPrivFlag))
            return false;
        if(runStatus == null) {
            if(other.runStatus != null)
                return false;
        }
        else if(!runStatus.equals(other.runStatus))
            return false;
        if(tgCap == null) {
            if(other.tgCap != null)
                return false;
        }
        else if(!tgCap.equals(other.tgCap))
            return false;
        if(tgName == null) {
            if(other.tgName != null)
                return false;
        }
        else if(!tgName.equals(other.tgName))
            return false;
        if(tgNo == null) {
            if(other.tgNo != null)
                return false;
        }
        else if(!tgNo.equals(other.tgNo))
            return false;
        return true;
    }

}
