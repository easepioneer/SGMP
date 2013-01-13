package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Nick
 *
 */
public class MeterInfo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7187133381752044876L;

    private Long id;                            // C_METER.METER_ID
    private Long orgId;                         // C_METER.ORG_ID
    private String assetNo;                     // C_METER.ASSET_NO
    private Date instDate;                      // C_METER.INST_DATE
    private Float totalFactor;                  // C_METER.T_FACTOR
    private String commNo;                      // C_METER.COMM_NO
    private String baudrate;                    // C_METER.BAUDRATE
    private String commMode;                    // C_METER.COMM_MODE
    private Long mpId;                          // C_MP.MP_ID
    private Long tgId;                          // C_MP.TG_ID
    private String mpNo;                        // C_MP.MP_NO
    private String mpName;                      // C_MP.MP_NAME
    private String mpAddr;                      // C_MP.MP_ADDR
    private String mpType;                      // C_MP.TYPE_CODE
    private String mpAttr;                      // C_MP.MP_ATTR_CODE
    private String mpUsageType;                 // C_MP.USAGE_TYPE_CODE
    private String mpSide;                      // C_MP.SIDE_CODE
    private String mpVolt;                      // C_MP.VOLT_CODE
    private Date appDate;                       // C_MP.APP_DATE
    private Date runDate;                       // C_MP.RUN_DATE
    private String wiringMode;                  // C_MP.WIRING_MODE
    private String measMode;                    // C_MP.MEAS_MODE
    private String switchNo;                    // C_MP.SWITCH_NO
    private String mrSectNo;                    // C_MP.MR_SECT_NO
    private String mpStatus;                    // C_MP.STATUS_CODE
    private Long gpId;                          // C_GP.GP_ID
    private Long tranId;                        // C_GP.TRAN_ID
    private Long termId;                        // C_GP.TERM_ID
    private Integer gpSn;                       // C_GP.GP_SN
    private String gpChar;                      // C_GP.GP_CHAR
    private String gpType;                      // C_GP.GP_TYPE
    private String gpStatus;                    // C_GP.GP_STATUS
    private String gpAddr;                      // C_GP.GP_ADDR
    private Integer ctTimes;                    // C_GP.CT_TIMES
    private Integer ptTimes;                    // C_GP.PT_TIMES
    private String port;                        // C_GP.PORT
    private String protocolNo;                  // C_GP.PROTOCOL_NO

    public MeterInfo() {
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

    public Long getMpId() {
        return mpId;
    }

    public void setMpId(Long mpId) {
        this.mpId = mpId;
    }

    public Long getTgId() {
        return tgId;
    }

    public void setTgId(Long tgId) {
        this.tgId = tgId;
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

    public Long getGpId() {
        return gpId;
    }

    public void setGpId(Long gpId) {
        this.gpId = gpId;
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

}
