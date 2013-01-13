package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 
 * @author Nick
 *
 */
public class ProtectorInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2515501715090250884L;

    private Long id;                            // C_PS.PS_ID
    private Long termId;                        // C_PS.TERM_ID
    private Long gpId;                          // C_PS.GP_ID
    private String assetNo;                     // C_PS.ASSET_NO
    private String psName;                      // C_PS.PS_NAME
    private String psModel;                     // C_PS.MODEL_CODE
    private String commMode;                    // C_PS.COMM_MODE_GM
    private String baudrate;                    // C_PS.BTL
    private String ratedEc;                     // C_PS.RATED_EC
    private String psType;                      // C_PS.PS_TYPE
    private String testDay;                     // C_PS.TEST_DAY
    private String testTime;                    // C_PS.TEST_TIME
    private String autoTest;                    // C_PS.AUTO_TEST
    private Long objectId;                      // C_GP.OBJECT_ID
    private Integer gpSn;                       // C_GP.GP_SN
    private String gpChar;                      // C_GP.GP_CHAR
    private String gpType;                      // C_GP.GP_TYPE
    private String gpStatus;                    // C_GP.GP_STATUS
    private String gpAddr;                      // C_GP.GP_ADDR
    private Integer ctTimes;                    // C_GP.CT_TIMES
    private Integer ptTimes;                    // C_GP.PT_TIMES
    private String port;                        // C_GP.PORT
    private String protocolNo;                  // C_GP.PROTOCOL_NO

    public ProtectorInfo() {
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

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Integer getGpSn() {
        return gpSn;
    }

    public void setGpSn(Integer gpSn) {
        this.gpSn = gpSn;
    }

    public String getGpChar() {
        return gpChar;
    }

    public void setGpChar(String gpChar) {
        this.gpChar = gpChar;
    }

    public String getGpType() {
        return gpType;
    }

    public void setGpType(String gpType) {
        this.gpType = gpType;
    }

    public String getGpStatus() {
        return gpStatus;
    }

    public void setGpStatus(String gpStatus) {
        this.gpStatus = gpStatus;
    }

    public String getGpAddr() {
        return gpAddr;
    }

    public void setGpAddr(String gpAddr) {
        this.gpAddr = gpAddr;
    }

    public Integer getCtTimes() {
        return ctTimes;
    }

    public void setCtTimes(Integer ctTimes) {
        this.ctTimes = ctTimes;
    }

    public Integer getPtTimes() {
        return ptTimes;
    }

    public void setPtTimes(Integer ptTimes) {
        this.ptTimes = ptTimes;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocolNo() {
        return protocolNo;
    }

    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }

    @Override
    public String toString() {
        return "ProtectorInfo [id=" + id + ", termId=" + termId + ", gpId="
                + gpId + ", assetNo=" + assetNo + ", psName=" + psName
                + ", psModel=" + psModel + ", commMode=" + commMode
                + ", baudrate=" + baudrate + ", ratedEc=" + ratedEc
                + ", psType=" + psType + ", testDay=" + testDay + ", testTime="
                + testTime + ", autoTest=" + autoTest + ", objectId="
                + objectId + ", gpSn=" + gpSn + ", gpChar=" + gpChar
                + ", gpType=" + gpType + ", gpStatus=" + gpStatus + ", gpAddr="
                + gpAddr + ", ctTimes=" + ctTimes + ", ptTimes=" + ptTimes
                + ", port=" + port + ", protocolNo=" + protocolNo + "]";
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
        result = prime * result + ((ctTimes == null) ? 0 : ctTimes.hashCode());
        result = prime * result + ((gpAddr == null) ? 0 : gpAddr.hashCode());
        result = prime * result + ((gpChar == null) ? 0 : gpChar.hashCode());
        result = prime * result + ((gpId == null) ? 0 : gpId.hashCode());
        result = prime * result + ((gpSn == null) ? 0 : gpSn.hashCode());
        result = prime * result
                + ((gpStatus == null) ? 0 : gpStatus.hashCode());
        result = prime * result + ((gpType == null) ? 0 : gpType.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((objectId == null) ? 0 : objectId.hashCode());
        result = prime * result + ((port == null) ? 0 : port.hashCode());
        result = prime * result
                + ((protocolNo == null) ? 0 : protocolNo.hashCode());
        result = prime * result + ((psModel == null) ? 0 : psModel.hashCode());
        result = prime * result + ((psName == null) ? 0 : psName.hashCode());
        result = prime * result + ((psType == null) ? 0 : psType.hashCode());
        result = prime * result + ((ptTimes == null) ? 0 : ptTimes.hashCode());
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
        ProtectorInfo other = (ProtectorInfo) obj;
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
        if(ctTimes == null) {
            if(other.ctTimes != null)
                return false;
        }
        else if(!ctTimes.equals(other.ctTimes))
            return false;
        if(gpAddr == null) {
            if(other.gpAddr != null)
                return false;
        }
        else if(!gpAddr.equals(other.gpAddr))
            return false;
        if(gpChar == null) {
            if(other.gpChar != null)
                return false;
        }
        else if(!gpChar.equals(other.gpChar))
            return false;
        if(gpId == null) {
            if(other.gpId != null)
                return false;
        }
        else if(!gpId.equals(other.gpId))
            return false;
        if(gpSn == null) {
            if(other.gpSn != null)
                return false;
        }
        else if(!gpSn.equals(other.gpSn))
            return false;
        if(gpStatus == null) {
            if(other.gpStatus != null)
                return false;
        }
        else if(!gpStatus.equals(other.gpStatus))
            return false;
        if(gpType == null) {
            if(other.gpType != null)
                return false;
        }
        else if(!gpType.equals(other.gpType))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(objectId == null) {
            if(other.objectId != null)
                return false;
        }
        else if(!objectId.equals(other.objectId))
            return false;
        if(port == null) {
            if(other.port != null)
                return false;
        }
        else if(!port.equals(other.port))
            return false;
        if(protocolNo == null) {
            if(other.protocolNo != null)
                return false;
        }
        else if(!protocolNo.equals(other.protocolNo))
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
        if(ptTimes == null) {
            if(other.ptTimes != null)
                return false;
        }
        else if(!ptTimes.equals(other.ptTimes))
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
