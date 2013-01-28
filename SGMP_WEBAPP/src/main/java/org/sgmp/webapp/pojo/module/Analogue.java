package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 模拟量
 * 
 * @author Nick
 *
 */
public class Analogue implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4918855643040802213L;

    private Long gpId;                          // GP_ID
    private String analogueName;                // ANALOGUE_NAME
    private Float rangeBegin;                   // RANGE_BEGIN
    private Float rangeEnd;                     // RANGE_END
    private Float maxValue;                     // MAX_VALUE
    private Float minValue;                     // MIN_VALUE
    private String freezeDensity;               // FREEZ_DENSITY

    public Analogue() {
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

    @Override
    public String toString() {
        return "Analogue [gpId=" + gpId + ", analogueName=" + analogueName
                + ", rangeBegin=" + rangeBegin + ", rangeEnd=" + rangeEnd
                + ", maxValue=" + maxValue + ", minValue=" + minValue
                + ", freezeDensity=" + freezeDensity + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((analogueName == null) ? 0 : analogueName.hashCode());
        result = prime * result
                + ((freezeDensity == null) ? 0 : freezeDensity.hashCode());
        result = prime * result + ((gpId == null) ? 0 : gpId.hashCode());
        result = prime * result
                + ((maxValue == null) ? 0 : maxValue.hashCode());
        result = prime * result
                + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result
                + ((rangeBegin == null) ? 0 : rangeBegin.hashCode());
        result = prime * result
                + ((rangeEnd == null) ? 0 : rangeEnd.hashCode());
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
        Analogue other = (Analogue) obj;
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
        if(gpId == null) {
            if(other.gpId != null)
                return false;
        }
        else if(!gpId.equals(other.gpId))
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
        return true;
    }

}
