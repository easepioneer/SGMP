package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 
 * @author Nick
 *
 */
public class Switch implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 239684748149586431L;

    private Long id;                            // SWITCH_ID
    private Long termId;                        // TERM_ID
    private Integer switchNo;                   // SWITCH_NO
    private String switchType;                  // SWITCH_TYPE
    private String switchName;                  // SWITCH_VALUE_NAME

    public Switch() {
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

    public Integer getSwitchNo() {
        return switchNo;
    }

    public void setSwitchNo(Integer switchNo) {
        this.switchNo = switchNo;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName;
    }

}
