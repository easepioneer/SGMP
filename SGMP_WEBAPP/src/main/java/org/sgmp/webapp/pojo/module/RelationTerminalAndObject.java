package org.sgmp.webapp.pojo.module;

import java.io.Serializable;

/**
 * 集中器与对象（台区、大用户）关系
 * 
 * @author Nick
 *
 */
public class RelationTerminalAndObject implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2924783310469527731L;

    private Long id;                            // TERM_OBJ_ID
    private Long termId;                        // TERM_ID
    private String objectType;                  // OBJ_TYPE
    private Long objectId;                      // OBJ_ID

    public RelationTerminalAndObject() {
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

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "RelationTerminalAndObject [id=" + id + ", termId=" + termId
                + ", objectType=" + objectType + ", objectId=" + objectId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((objectId == null) ? 0 : objectId.hashCode());
        result = prime * result
                + ((objectType == null) ? 0 : objectType.hashCode());
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
        RelationTerminalAndObject other = (RelationTerminalAndObject) obj;
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
        if(objectType == null) {
            if(other.objectType != null)
                return false;
        }
        else if(!objectType.equals(other.objectType))
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
