package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 计量点
 * 
 * @author Nick
 *
 */
public class MeasuringPoint implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7768873179067412620L;

    private Long id;                            // MP_ID
    private Long orgId;                         // ORG_ID
    private Long tgId;                          // TG_ID
    private Long meterId;                       // METER_ID
    private String mpNo;                        // MP_NO
    private String mpName;                      // MP_NAME
    private String mpAddr;                      // MP_ADDR
    private String mpType;                      // TYPE_CODE
    private String mpAttr;                      // MP_ATTR_CODE
    private String mpUsageType;                 // USAGE_TYPE_CODE
    private String mpSide;                      // SIDE_CODE
    private String mpVolt;                      // VOLT_CODE
    private Date appDate;                       // APP_DATE
    private Date runDate;                       // RUN_DATE
    private String wiringMode;                  // WIRING_MODE
    private String measMode;                    // MEAS_MODE
    private String switchNo;                    // SWITCH_NO
    private String mrSectNo;                    // MR_SECT_NO
    private String mpStatus;                    // STATUS_CODE
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public MeasuringPoint() {
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

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public String getMpNo() {
        return mpNo;
    }

    public void setMpNo(String mpNo) {
        this.mpNo = mpNo;
    }

    public String getMpName() {
        return mpName;
    }

    public void setMpName(String mpName) {
        this.mpName = mpName;
    }

    public String getMpAddr() {
        return mpAddr;
    }

    public void setMpAddr(String mpAddr) {
        this.mpAddr = mpAddr;
    }

    public String getMpType() {
        return mpType;
    }

    public void setMpType(String mpType) {
        this.mpType = mpType;
    }

    public String getMpAttr() {
        return mpAttr;
    }

    public void setMpAttr(String mpAttr) {
        this.mpAttr = mpAttr;
    }

    public String getMpUsageType() {
        return mpUsageType;
    }

    public void setMpUsageType(String mpUsageType) {
        this.mpUsageType = mpUsageType;
    }

    public String getMpSide() {
        return mpSide;
    }

    public void setMpSide(String mpSide) {
        this.mpSide = mpSide;
    }

    public String getMpVolt() {
        return mpVolt;
    }

    public void setMpVolt(String mpVolt) {
        this.mpVolt = mpVolt;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public String getWiringMode() {
        return wiringMode;
    }

    public void setWiringMode(String wiringMode) {
        this.wiringMode = wiringMode;
    }

    public String getMeasMode() {
        return measMode;
    }

    public void setMeasMode(String measMode) {
        this.measMode = measMode;
    }

    public String getSwitchNo() {
        return switchNo;
    }

    public void setSwitchNo(String switchNo) {
        this.switchNo = switchNo;
    }

    public String getMrSectNo() {
        return mrSectNo;
    }

    public void setMrSectNo(String mrSectNo) {
        this.mrSectNo = mrSectNo;
    }

    public String getMpStatus() {
        return mpStatus;
    }

    public void setMpStatus(String mpStatus) {
        this.mpStatus = mpStatus;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "MeasuringPoint [id=" + id + ", orgId=" + orgId + ", tgId="
                + tgId + ", meterId=" + meterId + ", mpNo=" + mpNo
                + ", mpName=" + mpName + ", mpAddr=" + mpAddr + ", mpType="
                + mpType + ", mpAttr=" + mpAttr + ", mpUsageType="
                + mpUsageType + ", mpSide=" + mpSide + ", mpVolt=" + mpVolt
                + ", appDate=" + appDate + ", runDate=" + runDate
                + ", wiringMode=" + wiringMode + ", measMode=" + measMode
                + ", switchNo=" + switchNo + ", mrSectNo=" + mrSectNo
                + ", mpStatus=" + mpStatus + ", lastTimestamp=" + lastTimestamp
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((appDate == null) ? 0 : appDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result
                + ((measMode == null) ? 0 : measMode.hashCode());
        result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
        result = prime * result + ((mpAddr == null) ? 0 : mpAddr.hashCode());
        result = prime * result + ((mpAttr == null) ? 0 : mpAttr.hashCode());
        result = prime * result + ((mpName == null) ? 0 : mpName.hashCode());
        result = prime * result + ((mpNo == null) ? 0 : mpNo.hashCode());
        result = prime * result + ((mpSide == null) ? 0 : mpSide.hashCode());
        result = prime * result
                + ((mpStatus == null) ? 0 : mpStatus.hashCode());
        result = prime * result + ((mpType == null) ? 0 : mpType.hashCode());
        result = prime * result
                + ((mpUsageType == null) ? 0 : mpUsageType.hashCode());
        result = prime * result + ((mpVolt == null) ? 0 : mpVolt.hashCode());
        result = prime * result
                + ((mrSectNo == null) ? 0 : mrSectNo.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
        result = prime * result
                + ((switchNo == null) ? 0 : switchNo.hashCode());
        result = prime * result + ((tgId == null) ? 0 : tgId.hashCode());
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
        MeasuringPoint other = (MeasuringPoint) obj;
        if(appDate == null) {
            if(other.appDate != null)
                return false;
        }
        else if(!appDate.equals(other.appDate))
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
        if(measMode == null) {
            if(other.measMode != null)
                return false;
        }
        else if(!measMode.equals(other.measMode))
            return false;
        if(meterId == null) {
            if(other.meterId != null)
                return false;
        }
        else if(!meterId.equals(other.meterId))
            return false;
        if(mpAddr == null) {
            if(other.mpAddr != null)
                return false;
        }
        else if(!mpAddr.equals(other.mpAddr))
            return false;
        if(mpAttr == null) {
            if(other.mpAttr != null)
                return false;
        }
        else if(!mpAttr.equals(other.mpAttr))
            return false;
        if(mpName == null) {
            if(other.mpName != null)
                return false;
        }
        else if(!mpName.equals(other.mpName))
            return false;
        if(mpNo == null) {
            if(other.mpNo != null)
                return false;
        }
        else if(!mpNo.equals(other.mpNo))
            return false;
        if(mpSide == null) {
            if(other.mpSide != null)
                return false;
        }
        else if(!mpSide.equals(other.mpSide))
            return false;
        if(mpStatus == null) {
            if(other.mpStatus != null)
                return false;
        }
        else if(!mpStatus.equals(other.mpStatus))
            return false;
        if(mpType == null) {
            if(other.mpType != null)
                return false;
        }
        else if(!mpType.equals(other.mpType))
            return false;
        if(mpUsageType == null) {
            if(other.mpUsageType != null)
                return false;
        }
        else if(!mpUsageType.equals(other.mpUsageType))
            return false;
        if(mpVolt == null) {
            if(other.mpVolt != null)
                return false;
        }
        else if(!mpVolt.equals(other.mpVolt))
            return false;
        if(mrSectNo == null) {
            if(other.mrSectNo != null)
                return false;
        }
        else if(!mrSectNo.equals(other.mrSectNo))
            return false;
        if(orgId == null) {
            if(other.orgId != null)
                return false;
        }
        else if(!orgId.equals(other.orgId))
            return false;
        if(runDate == null) {
            if(other.runDate != null)
                return false;
        }
        else if(!runDate.equals(other.runDate))
            return false;
        if(switchNo == null) {
            if(other.switchNo != null)
                return false;
        }
        else if(!switchNo.equals(other.switchNo))
            return false;
        if(tgId == null) {
            if(other.tgId != null)
                return false;
        }
        else if(!tgId.equals(other.tgId))
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
