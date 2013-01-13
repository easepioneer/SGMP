package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 编码
 * 
 * @author Nick
 *
 */
public class Code implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1523540525454740159L;

    private Long id;                            // CODE_ID
    private String codeCate;                    // CODE_CATE
    private String code;                        // CODE
    private String name;                        // NAME
    private String remark;                      // REMARK
    private String codeType;                    // CODE_TYPE
    private String value;                       // VALUE

    public Code() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCate() {
        return codeCate;
    }

    public void setCodeCate(String codeCate) {
        this.codeCate = codeCate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Code [id=" + id + ", codeCate=" + codeCate + ", code=" + code
                + ", name=" + name + ", remark=" + remark + ", codeType="
                + codeType + ", value=" + value + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result
                + ((codeCate == null) ? 0 : codeCate.hashCode());
        result = prime * result
                + ((codeType == null) ? 0 : codeType.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        Code other = (Code) obj;
        if(code == null) {
            if(other.code != null)
                return false;
        }
        else if(!code.equals(other.code))
            return false;
        if(codeCate == null) {
            if(other.codeCate != null)
                return false;
        }
        else if(!codeCate.equals(other.codeCate))
            return false;
        if(codeType == null) {
            if(other.codeType != null)
                return false;
        }
        else if(!codeType.equals(other.codeType))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(name == null) {
            if(other.name != null)
                return false;
        }
        else if(!name.equals(other.name))
            return false;
        if(remark == null) {
            if(other.remark != null)
                return false;
        }
        else if(!remark.equals(other.remark))
            return false;
        if(value == null) {
            if(other.value != null)
                return false;
        }
        else if(!value.equals(other.value))
            return false;
        return true;
    }

}
