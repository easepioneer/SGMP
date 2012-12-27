package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 保护器
 * 
 * @author Nick
 *
 */
public class Protector implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1561482302917496971L;

    private Long id;                            // PS_ID
    private Long termId;                        // TERM_ID
    private Long gpId;                          // GP_ID
    private String assetNo;                     // ASSET_NO
    private String psName;                      // PS_NAME
    private String psModel;                     // MODEL_CODE
    private String commMode;                    // COMM_MODE_GM
    private String baudrate;                    // BTL
    private String ratedEc;                     // RATED_EC
    private String psType;                      // PS_TYPE
    private String testDay;                     // TEST_DAY
    private String testTime;                    // TEST_TIME
    private String autoTest;                    // AUTO_TEST
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Protector() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getPsModel() {
        return psModel;
    }

    public void setPsModel(String psModel) {
        this.psModel = psModel;
    }

    public String getCommMode() {
        return commMode;
    }

    public void setCommMode(String commMode) {
        this.commMode = commMode;
    }

    public String getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(String baudrate) {
        this.baudrate = baudrate;
    }

    public String getRatedEc() {
        return ratedEc;
    }

    public void setRatedEc(String ratedEc) {
        this.ratedEc = ratedEc;
    }

    public String getPsType() {
        return psType;
    }

    public void setPsType(String psType) {
        this.psType = psType;
    }

    public String getTestDay() {
        return testDay;
    }

    public void setTestDay(String testDay) {
        this.testDay = testDay;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getAutoTest() {
        return autoTest;
    }

    public void setAutoTest(String autoTest) {
        this.autoTest = autoTest;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Protector [id=" + id + ", termId=" + termId + ", gpId=" + gpId
                + ", assetNo=" + assetNo + ", psName=" + psName + ", psModel="
                + psModel + ", commMode=" + commMode + ", baudrate=" + baudrate
                + ", ratedEc=" + ratedEc + ", psType=" + psType + ", testDay="
                + testDay + ", testTime=" + testTime + ", autoTest=" + autoTest
                + ", lastTimestamp=" + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((assetNo == null) ? 0 : assetNo.hashCode());
        result = prime * result
                + ((autoTest == null) ? 0 : autoTest.hashCode());
        result = prime * result
                + ((baudrate == null) ? 0 : baudrate.hashCode());
        result = prime * result
                + ((commMode == null) ? 0 : commMode.hashCode());
        result = prime * result + ((gpId == null) ? 0 : gpId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((psModel == null) ? 0 : psModel.hashCode());
        result = prime * result + ((psName == null) ? 0 : psName.hashCode());
        result = prime * result + ((psType == null) ? 0 : psType.hashCode());
        result = prime * result + ((ratedEc == null) ? 0 : ratedEc.hashCode());
        result = prime * result + ((termId == null) ? 0 : termId.hashCode());
        result = prime * result + ((testDay == null) ? 0 : testDay.hashCode());
        result = prime * result
                + ((testTime == null) ? 0 : testTime.hashCode());
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
        Protector other = (Protector) obj;
        if(assetNo == null) {
            if(other.assetNo != null)
                return false;
        }
        else if(!assetNo.equals(other.assetNo))
            return false;
        if(autoTest == null) {
            if(other.autoTest != null)
                return false;
        }
        else if(!autoTest.equals(other.autoTest))
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
        if(gpId == null) {
            if(other.gpId != null)
                return false;
        }
        else if(!gpId.equals(other.gpId))
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
        if(psModel == null) {
            if(other.psModel != null)
                return false;
        }
        else if(!psModel.equals(other.psModel))
            return false;
        if(psName == null) {
            if(other.psName != null)
                return false;
        }
        else if(!psName.equals(other.psName))
            return false;
        if(psType == null) {
            if(other.psType != null)
                return false;
        }
        else if(!psType.equals(other.psType))
            return false;
        if(ratedEc == null) {
            if(other.ratedEc != null)
                return false;
        }
        else if(!ratedEc.equals(other.ratedEc))
            return false;
        if(termId == null) {
            if(other.termId != null)
                return false;
        }
        else if(!termId.equals(other.termId))
            return false;
        if(testDay == null) {
            if(other.testDay != null)
                return false;
        }
        else if(!testDay.equals(other.testDay))
            return false;
        if(testTime == null) {
            if(other.testTime != null)
                return false;
        }
        else if(!testTime.equals(other.testTime))
            return false;
        return true;
    }

}
