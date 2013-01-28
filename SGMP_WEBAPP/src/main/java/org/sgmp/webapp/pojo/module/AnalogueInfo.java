package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 
 * @author Nick
 *
 */
public class AnalogueInfo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7065367291914139488L;

    private Long gpId;                          // C_ANALOGUE.GP_ID
    private String analogueName;                // C_ANALOGUE.ANALOGUE_NAME
    private Float rangeBegin;                   // C_ANALOGUE.RANGE_BEGIN
    private Float rangeEnd;                     // C_ANALOGUE.RANGE_END
    private Float maxValue;                     // C_ANALOGUE.MAX_VALUE
    private Float minValue;                     // C_ANALOGUE.MIN_VALUE
    private String freezeDensity;               // C_ANALOGUE.FREEZ_DENSITY
    private Long objectId;                      // C_GP.OBJECT_ID
    private Long termId;                        // C_GP.TERM_ID
    private Integer gpSn;                       // C_GP.GP_SN
    private String gpChar;                      // C_GP.GP_CHAR
    private String gpType;                      // C_GP.GP_TYPE
    private String gpStatus;                    // C_GP.GP_STATUS
    private String port;                        // C_GP.PORT

    public AnalogueInfo() {
    }

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
    }

    public String getAnalogueName() {
        return analogueName;
    }

    public void setAnalogueName(String analogueName) {
        this.analogueName = analogueName;
    }

    public Float getRangeBegin() {
        return rangeBegin;
    }

    public void setRangeBegin(Float rangeBegin) {
        this.rangeBegin = rangeBegin;
    }

    public Float getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(Float rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    public Float getMinValue() {
        return minValue;
    }

    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    public String getFreezeDensity() {
        return freezeDensity;
    }

    public void setFreezeDensity(String freezeDensity) {
        this.freezeDensity = freezeDensity;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AnalogueInfo [gpId=" + gpId + ", analogueName=" + analogueName
                + ", rangeBegin=" + rangeBegin + ", rangeEnd=" + rangeEnd
                + ", maxValue=" + maxValue + ", minValue=" + minValue
                + ", freezeDensity=" + freezeDensity + ", objectId=" + objectId
                + ", termId=" + termId + ", gpSn=" + gpSn + ", gpChar="
                + gpChar + ", gpType=" + gpType + ", gpStatus=" + gpStatus
                + ", port=" + port + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((analogueName == null) ? 0 : analogueName.hashCode());
        result = prime * result
                + ((freezeDensity == null) ? 0 : freezeDensity.hashCode());
        result = prime * result + ((gpChar == null) ? 0 : gpChar.hashCode());
        result = prime * result + ((gpId == null) ? 0 : gpId.hashCode());
        result = prime * result + ((gpSn == null) ? 0 : gpSn.hashCode());
        result = prime * result
                + ((gpStatus == null) ? 0 : gpStatus.hashCode());
        result = prime * result + ((gpType == null) ? 0 : gpType.hashCode());
        result = prime * result
                + ((maxValue == null) ? 0 : maxValue.hashCode());
        result = prime * result
                + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result
                + ((objectId == null) ? 0 : objectId.hashCode());
        result = prime * result + ((port == null) ? 0 : port.hashCode());
        result = prime * result
                + ((rangeBegin == null) ? 0 : rangeBegin.hashCode());
        result = prime * result
                + ((rangeEnd == null) ? 0 : rangeEnd.hashCode());
        result = prime * result + ((termId == null) ? 0 : termId.hashCode());
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
        AnalogueInfo other = (AnalogueInfo) obj;
        if(analogueName == null) {
            if(other.analogueName != null)
                return false;
        }
        else if(!analogueName.equals(other.analogueName))
            return false;
        if(freezeDensity == null) {
            if(other.freezeDensity != null)
                return false;
        }
        else if(!freezeDensity.equals(other.freezeDensity))
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
        if(maxValue == null) {
            if(other.maxValue != null)
                return false;
        }
        else if(!maxValue.equals(other.maxValue))
            return false;
        if(minValue == null) {
            if(other.minValue != null)
                return false;
        }
        else if(!minValue.equals(other.minValue))
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
        if(rangeBegin == null) {
            if(other.rangeBegin != null)
                return false;
        }
        else if(!rangeBegin.equals(other.rangeBegin))
            return false;
        if(rangeEnd == null) {
            if(other.rangeEnd != null)
                return false;
        }
        else if(!rangeEnd.equals(other.rangeEnd))
            return false;
        if(termId == null) {
            if(other.termId != null)
                return false;
        }
        else if(!termId.equals(other.termId))
            return false;
        return true;
    }

}
