package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 采集点 / 测量点
 * 
 * @author Nick
 *
 */
public class GatherPoint implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3298982230410355612L;

    private Long id;                            // GP_ID
    private Long objectId;                      // OBJECT_ID
    private Long tranId;                        // TRAN_ID
    private Long termId;                        // TERM_ID
    private Long mpId;                          // MP_ID
    private Long gmId;                          // GM_ID
    private Integer gpSn;                       // GP_SN
    private String gpChar;                      // GP_CHAR
    private String gpType;                      // GP_TYPE
    private String gpStatus;                    // GP_STATUS
    private String gpAddr;                      // GP_ADDR
    private Integer ctTimes;                    // CT_TIMES
    private Integer ptTimes;                    // PT_TIMES
    private String port;                        // PORT
    private String protocolNo;                  // PROTOCOL_NO
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public GatherPoint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getMpId() {
        return mpId;
    }

    public void setMpId(Long mpId) {
        this.mpId = mpId;
    }

    public Long getGmId() {
        return gmId;
    }

    public void setGmId(Long gmId) {
        this.gmId = gmId;
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

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "GatherPoint [id=" + id + ", objectId=" + objectId + ", tranId="
                + tranId + ", termId=" + termId + ", mpId=" + mpId + ", gmId="
                + gmId + ", gpSn=" + gpSn + ", gpChar=" + gpChar + ", gpType="
                + gpType + ", gpStatus=" + gpStatus + ", gpAddr=" + gpAddr
                + ", ctTimes=" + ctTimes + ", ptTimes=" + ptTimes + ", port="
                + port + ", protocolNo=" + protocolNo + ", lastTimestamp="
                + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ctTimes == null) ? 0 : ctTimes.hashCode());
        result = prime * result + ((gmId == null) ? 0 : gmId.hashCode());
        result = prime * result + ((gpAddr == null) ? 0 : gpAddr.hashCode());
        result = prime * result + ((gpChar == null) ? 0 : gpChar.hashCode());
        result = prime * result + ((gpSn == null) ? 0 : gpSn.hashCode());
        result = prime * result
                + ((gpStatus == null) ? 0 : gpStatus.hashCode());
        result = prime * result + ((gpType == null) ? 0 : gpType.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((mpId == null) ? 0 : mpId.hashCode());
        result = prime * result
                + ((objectId == null) ? 0 : objectId.hashCode());
        result = prime * result + ((port == null) ? 0 : port.hashCode());
        result = prime * result
                + ((protocolNo == null) ? 0 : protocolNo.hashCode());
        result = prime * result + ((ptTimes == null) ? 0 : ptTimes.hashCode());
        result = prime * result + ((termId == null) ? 0 : termId.hashCode());
        result = prime * result + ((tranId == null) ? 0 : tranId.hashCode());
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
        GatherPoint other = (GatherPoint) obj;
        if(ctTimes == null) {
            if(other.ctTimes != null)
                return false;
        }
        else if(!ctTimes.equals(other.ctTimes))
            return false;
        if(gmId == null) {
            if(other.gmId != null)
                return false;
        }
        else if(!gmId.equals(other.gmId))
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
        if(lastTimestamp == null) {
            if(other.lastTimestamp != null)
                return false;
        }
        else if(!lastTimestamp.equals(other.lastTimestamp))
            return false;
        if(mpId == null) {
            if(other.mpId != null)
                return false;
        }
        else if(!mpId.equals(other.mpId))
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
        if(ptTimes == null) {
            if(other.ptTimes != null)
                return false;
        }
        else if(!ptTimes.equals(other.ptTimes))
            return false;
        if(termId == null) {
            if(other.termId != null)
                return false;
        }
        else if(!termId.equals(other.termId))
            return false;
        if(tranId == null) {
            if(other.tranId != null)
                return false;
        }
        else if(!tranId.equals(other.tranId))
            return false;
        return true;
    }

}
