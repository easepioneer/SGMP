package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 变压器
 * 
 * @author Nick
 *
 */
public class Transformer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6523127582876603979L;

    private Long id;                            // EQUIP_ID
    private Long orgId;                         // ORG_ID
    private Long tgId;                          // TG_ID
    private String tranType;                    // TYPE_CODE
    private String tranName;                    // TRAN_NAME
    private String instAddr;                    // INST_ADDR
    private Date instDate;                      // INST_DATE
    private Float plateCap;                     // PLATE_CAP
    private String runStatus;                   // RUN_STATUS_CODE
    private String tranModel;                   // MODEL_NO
    private String rvHv;                        // RV_HV
    private String rvMv;                        // RV_MV
    private String rvLv;                        // RV_LV
    private String rcHv;                        // RC_HV
    private String rcMv;                        // RC_MV
    private String rcLv;                        // RC_LV
    private String pr;                          // PR_CODE
    private Date lastTimestamp;                 // LASTTIME_STAMP

    public Transformer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTranName() {
        return tranName;
    }

    public void setTranName(String tranName) {
        this.tranName = tranName;
    }

    public String getInstAddr() {
        return instAddr;
    }

    public void setInstAddr(String instAddr) {
        this.instAddr = instAddr;
    }

    public Date getInstDate() {
        return instDate;
    }

    public void setInstDate(Date instDate) {
        this.instDate = instDate;
    }

    public Float getPlateCap() {
        return plateCap;
    }

    public void setPlateCap(Float plateCap) {
        this.plateCap = plateCap;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getTranModel() {
        return tranModel;
    }

    public void setTranModel(String tranModel) {
        this.tranModel = tranModel;
    }

    public String getRvHv() {
        return rvHv;
    }

    public void setRvHv(String rvHv) {
        this.rvHv = rvHv;
    }

    public String getRvMv() {
        return rvMv;
    }

    public void setRvMv(String rvMv) {
        this.rvMv = rvMv;
    }

    public String getRvLv() {
        return rvLv;
    }

    public void setRvLv(String rvLv) {
        this.rvLv = rvLv;
    }

    public String getRcHv() {
        return rcHv;
    }

    public void setRcHv(String rcHv) {
        this.rcHv = rcHv;
    }

    public String getRcMv() {
        return rcMv;
    }

    public void setRcMv(String rcMv) {
        this.rcMv = rcMv;
    }

    public String getRcLv() {
        return rcLv;
    }

    public void setRcLv(String rcLv) {
        this.rcLv = rcLv;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(Date lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @Override
    public String toString() {
        return "Transformer [id=" + id + ", tgId=" + tgId + ", orgId=" + orgId
                + ", tranType=" + tranType + ", tranName=" + tranName
                + ", instAddr=" + instAddr + ", instDate=" + instDate
                + ", plateCap=" + plateCap + ", runStatus=" + runStatus
                + ", tranModel=" + tranModel + ", rvHv=" + rvHv + ", rvMv="
                + rvMv + ", rvLv=" + rvLv + ", rcHv=" + rcHv + ", rcMv=" + rcMv
                + ", rcLv=" + rcLv + ", pr=" + pr + ", lastTimestamp="
                + lastTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((instAddr == null) ? 0 : instAddr.hashCode());
        result = prime * result
                + ((instDate == null) ? 0 : instDate.hashCode());
        result = prime * result
                + ((lastTimestamp == null) ? 0 : lastTimestamp.hashCode());
        result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
        result = prime * result
                + ((plateCap == null) ? 0 : plateCap.hashCode());
        result = prime * result + ((pr == null) ? 0 : pr.hashCode());
        result = prime * result + ((rcHv == null) ? 0 : rcHv.hashCode());
        result = prime * result + ((rcLv == null) ? 0 : rcLv.hashCode());
        result = prime * result + ((rcMv == null) ? 0 : rcMv.hashCode());
        result = prime * result
                + ((runStatus == null) ? 0 : runStatus.hashCode());
        result = prime * result + ((rvHv == null) ? 0 : rvHv.hashCode());
        result = prime * result + ((rvLv == null) ? 0 : rvLv.hashCode());
        result = prime * result + ((rvMv == null) ? 0 : rvMv.hashCode());
        result = prime * result + ((tgId == null) ? 0 : tgId.hashCode());
        result = prime * result
                + ((tranModel == null) ? 0 : tranModel.hashCode());
        result = prime * result
                + ((tranName == null) ? 0 : tranName.hashCode());
        result = prime * result
                + ((tranType == null) ? 0 : tranType.hashCode());
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
        Transformer other = (Transformer) obj;
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
        if(instDate == null) {
            if(other.instDate != null)
                return false;
        }
        else if(!instDate.equals(other.instDate))
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
        if(plateCap == null) {
            if(other.plateCap != null)
                return false;
        }
        else if(!plateCap.equals(other.plateCap))
            return false;
        if(pr == null) {
            if(other.pr != null)
                return false;
        }
        else if(!pr.equals(other.pr))
            return false;
        if(rcHv == null) {
            if(other.rcHv != null)
                return false;
        }
        else if(!rcHv.equals(other.rcHv))
            return false;
        if(rcLv == null) {
            if(other.rcLv != null)
                return false;
        }
        else if(!rcLv.equals(other.rcLv))
            return false;
        if(rcMv == null) {
            if(other.rcMv != null)
                return false;
        }
        else if(!rcMv.equals(other.rcMv))
            return false;
        if(runStatus == null) {
            if(other.runStatus != null)
                return false;
        }
        else if(!runStatus.equals(other.runStatus))
            return false;
        if(rvHv == null) {
            if(other.rvHv != null)
                return false;
        }
        else if(!rvHv.equals(other.rvHv))
            return false;
        if(rvLv == null) {
            if(other.rvLv != null)
                return false;
        }
        else if(!rvLv.equals(other.rvLv))
            return false;
        if(rvMv == null) {
            if(other.rvMv != null)
                return false;
        }
        else if(!rvMv.equals(other.rvMv))
            return false;
        if(tgId == null) {
            if(other.tgId != null)
                return false;
        }
        else if(!tgId.equals(other.tgId))
            return false;
        if(tranModel == null) {
            if(other.tranModel != null)
                return false;
        }
        else if(!tranModel.equals(other.tranModel))
            return false;
        if(tranName == null) {
            if(other.tranName != null)
                return false;
        }
        else if(!tranName.equals(other.tranName))
            return false;
        if(tranType == null) {
            if(other.tranType != null)
                return false;
        }
        else if(!tranType.equals(other.tranType))
            return false;
        return true;
    }

}
