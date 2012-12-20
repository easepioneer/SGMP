package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 终端/集中器
 * 
 * @author Nick
 *
 */
public class Terminal implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5023561351065580426L;

    private Long id;                            // TERM_ID
    private Long orgId;                         // ORG_ID
    private String assetNo;                     // ASSET_NO
    private String logicalAddr;                 // LOGICAL_ADDR
    private String runStatus;                   // RUN_STATUS
    private String curStatus;                   // CUR_STATUS
    private String simNo;                       // SIM_NO
    private String termType;                    // TERM_TYPE
    private String wiringMode;                  // WIRING_MODE
    private String termModel;                   // MODEL_CODE
    private Date instDate;                      // INSTALL_DATE
    private String commMode;                    // COMM_MODE
    private String channelType;                 // CHANNEL_TYPE
    private String protocolNo;                  // PROTOCOL_NO
    private String pr;                          // PR
    private String isAc;                        // ISAC
    private String physicsAddr;                 // PHYSICS_ADDR
    private Integer commPattern;                // COMM_PATTERN
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Terminal() {
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

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getLogicalAddr() {
        return logicalAddr;
    }

    public void setLogicalAddr(String logicalAddr) {
        this.logicalAddr = logicalAddr;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(String curStatus) {
        this.curStatus = curStatus;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getWiringMode() {
        return wiringMode;
    }

    public void setWiringMode(String wiringMode) {
        this.wiringMode = wiringMode;
    }

    public String getTermModel() {
        return termModel;
    }

    public void setTermModel(String termModel) {
        this.termModel = termModel;
    }

    public Date getInstDate() {
        return instDate;
    }

    public void setInstDate(Date instDate) {
        this.instDate = instDate;
    }

    public String getCommMode() {
        return commMode;
    }

    public void setCommMode(String commMode) {
        this.commMode = commMode;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getIsAc() {
        return isAc;
    }

    public void setIsAc(String isAc) {
        this.isAc = isAc;
    }

    public String getPhysicsAddr() {
        return physicsAddr;
    }

    public void setPhysicsAddr(String physicsAddr) {
        this.physicsAddr = physicsAddr;
    }

    public Integer getCommPattern() {
        return commPattern;
    }

    public void setCommPattern(Integer commPattern) {
        this.commPattern = commPattern;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Terminal [id=" + id + ", orgId=" + orgId + ", assetNo="
                + assetNo + ", logicalAddr=" + logicalAddr + ", runStatus="
                + runStatus + ", curStatus=" + curStatus + ", simNo=" + simNo
                + ", termType=" + termType + ", wiringMode=" + wiringMode
                + ", termModel=" + termModel + ", instDate=" + instDate
                + ", commMode=" + commMode + ", channelType=" + channelType
                + ", protocolNo=" + protocolNo + ", pr=" + pr + ", isAc="
                + isAc + ", physicsAddr=" + physicsAddr + ", commPattern="
                + commPattern + ", lastTimestamp=" + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assetNo == null) ? 0 : assetNo.hashCode());
        result = prime * result
                + ((channelType == null) ? 0 : channelType.hashCode());
        result = prime * result
                + ((commMode == null) ? 0 : commMode.hashCode());
        result = prime * result
                + ((commPattern == null) ? 0 : commPattern.hashCode());
        result = prime * result
                + ((curStatus == null) ? 0 : curStatus.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((instDate == null) ? 0 : instDate.hashCode());
        result = prime * result + ((isAc == null) ? 0 : isAc.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result
                + ((logicalAddr == null) ? 0 : logicalAddr.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result
                + ((physicsAddr == null) ? 0 : physicsAddr.hashCode());
        result = prime * result + ((pr == null) ? 0 : pr.hashCode());
        result = prime * result
                + ((protocolNo == null) ? 0 : protocolNo.hashCode());
        result = prime * result
                + ((runStatus == null) ? 0 : runStatus.hashCode());
        result = prime * result + ((simNo == null) ? 0 : simNo.hashCode());
        result = prime * result
                + ((termModel == null) ? 0 : termModel.hashCode());
        result = prime * result
                + ((termType == null) ? 0 : termType.hashCode());
        result = prime * result
                + ((wiringMode == null) ? 0 : wiringMode.hashCode());
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
        Terminal other = (Terminal) obj;
        if(assetNo == null) {
            if(other.assetNo != null)
                return false;
        }
        else if(!assetNo.equals(other.assetNo))
            return false;
        if(channelType == null) {
            if(other.channelType != null)
                return false;
        }
        else if(!channelType.equals(other.channelType))
            return false;
        if(commMode == null) {
            if(other.commMode != null)
                return false;
        }
        else if(!commMode.equals(other.commMode))
            return false;
        if(commPattern == null) {
            if(other.commPattern != null)
                return false;
        }
        else if(!commPattern.equals(other.commPattern))
            return false;
        if(curStatus == null) {
            if(other.curStatus != null)
                return false;
        }
        else if(!curStatus.equals(other.curStatus))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(instDate == null) {
            if(other.instDate != null)
                return false;
        }
        else if(!instDate.equals(other.instDate))
            return false;
        if(isAc == null) {
            if(other.isAc != null)
                return false;
        }
        else if(!isAc.equals(other.isAc))
            return false;
        if(lastTimestamp == null) {
            if(other.lastTimestamp != null)
                return false;
        }
        else if(!lastTimestamp.equals(other.lastTimestamp))
            return false;
        if(logicalAddr == null) {
            if(other.logicalAddr != null)
                return false;
        }
        else if(!logicalAddr.equals(other.logicalAddr))
            return false;
        if(orgId == null) {
            if(other.orgId != null)
                return false;
        }
        else if(!orgId.equals(other.orgId))
            return false;
        if(physicsAddr == null) {
            if(other.physicsAddr != null)
                return false;
        }
        else if(!physicsAddr.equals(other.physicsAddr))
            return false;
        if(pr == null) {
            if(other.pr != null)
                return false;
        }
        else if(!pr.equals(other.pr))
            return false;
        if(protocolNo == null) {
            if(other.protocolNo != null)
                return false;
        }
        else if(!protocolNo.equals(other.protocolNo))
            return false;
        if(runStatus == null) {
            if(other.runStatus != null)
                return false;
        }
        else if(!runStatus.equals(other.runStatus))
            return false;
        if(simNo == null) {
            if(other.simNo != null)
                return false;
        }
        else if(!simNo.equals(other.simNo))
            return false;
        if(termModel == null) {
            if(other.termModel != null)
                return false;
        }
        else if(!termModel.equals(other.termModel))
            return false;
        if(termType == null) {
            if(other.termType != null)
                return false;
        }
        else if(!termType.equals(other.termType))
            return false;
        if(wiringMode == null) {
            if(other.wiringMode != null)
                return false;
        }
        else if(!wiringMode.equals(other.wiringMode))
            return false;
        return true;
    }

}
