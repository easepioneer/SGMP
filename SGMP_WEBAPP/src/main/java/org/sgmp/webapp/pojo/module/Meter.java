package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 电表
 * 
 * @author Nick
 *
 */
public class Meter implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3598553807595624995L;

    private Long id;                            // METER_ID
    private Long orgId;                         // ORG_ID
    private String assetNo;                     // ASSET_NO
    private Date instDate;                      // INST_DATE
    private Float totalFactor;                  // T_FACTOR
    private String commNo;                      // COMM_NO
    private String baudrate;                    // BAUDRATE
    private String commMode;                    // COMM_MODE

    public Meter() {
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

    public Date getInstDate() {
        return instDate;
    }

    public void setInstDate(Date instDate) {
        this.instDate = instDate;
    }

    public Float getTotalFactor() {
        return totalFactor;
    }

    public void setTotalFactor(Float totalFactor) {
        this.totalFactor = totalFactor;
    }

    public String getCommNo() {
        return commNo;
    }

    public void setCommNo(String commNo) {
        this.commNo = commNo;
    }

    public String getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(String baudrate) {
        this.baudrate = baudrate;
    }

    public String getCommMode() {
        return commMode;
    }

    public void setCommMode(String commMode) {
        this.commMode = commMode;
    }

    @Override
    public String toString() {
        return "Meter [id=" + id + ", orgId=" + orgId + ", assetNo=" + assetNo
                + ", instDate=" + instDate + ", totalFactor=" + totalFactor
                + ", commNo=" + commNo + ", baudrate=" + baudrate
                + ", commMode=" + commMode + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assetNo == null) ? 0 : assetNo.hashCode());
        result = prime * result
                + ((baudrate == null) ? 0 : baudrate.hashCode());
        result = prime * result
                + ((commMode == null) ? 0 : commMode.hashCode());
        result = prime * result + ((commNo == null) ? 0 : commNo.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((instDate == null) ? 0 : instDate.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result
                + ((totalFactor == null) ? 0 : totalFactor.hashCode());
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
        Meter other = (Meter) obj;
        if(assetNo == null) {
            if(other.assetNo != null)
                return false;
        }
        else if(!assetNo.equals(other.assetNo))
            return false;
        if(baudrate == null) {
            if(other.baudrate != null)
                return false;
        }
        else if(!baudrate.equals(other.baudrate))
            return false;
        if(commMode == null) {
            if(other.commMode != null)
                return false;
        }
        else if(!commMode.equals(other.commMode))
            return false;
        if(commNo == null) {
            if(other.commNo != null)
                return false;
        }
        else if(!commNo.equals(other.commNo))
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
        if(orgId == null) {
            if(other.orgId != null)
                return false;
        }
        else if(!orgId.equals(other.orgId))
            return false;
        if(totalFactor == null) {
            if(other.totalFactor != null)
                return false;
        }
        else if(!totalFactor.equals(other.totalFactor))
            return false;
        return true;
    }

}
