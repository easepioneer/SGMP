package org.sgmp.webapp.pojo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Nick
 *
 */
public class TerminalRemoteUpgradeTask implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5694960679006501113L;

    private Long id;                            // TASK_ID
    private Long sequence;                      // SEQUENCE_CODE
    private String logicalAddr;                 // LOGICAL_ADDR
    private Long fileId;                        // FILE_ID
    private Date postTime;                      // POST_TIME
    private String taskStatus;                  // TASK_STATUS
    private Integer schedule ;                  // SCHEDULE
    private Integer failFrameNo;                // FAILFRAMENO
    private String valid;                       // VALID

    public TerminalRemoteUpgradeTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getLogicalAddr() {
        return logicalAddr;
    }

    public void setLogicalAddr(String logicalAddr) {
        this.logicalAddr = logicalAddr;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Integer getFailFrameNo() {
        return failFrameNo;
    }

    public void setFailFrameNo(Integer failFrameNo) {
        this.failFrameNo = failFrameNo;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "TerminalRemoteUpgradeTask [id=" + id + ", sequence=" + sequence
                + ", logicalAddr=" + logicalAddr + ", fileId=" + fileId
                + ", postTime=" + postTime + ", taskStatus=" + taskStatus
                + ", schedule=" + schedule + ", failFrameNo=" + failFrameNo
                + ", valid=" + valid + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((failFrameNo == null) ? 0 : failFrameNo.hashCode());
        result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((logicalAddr == null) ? 0 : logicalAddr.hashCode());
        result = prime * result
                + ((postTime == null) ? 0 : postTime.hashCode());
        result = prime * result
                + ((schedule == null) ? 0 : schedule.hashCode());
        result = prime * result
                + ((sequence == null) ? 0 : sequence.hashCode());
        result = prime * result
                + ((taskStatus == null) ? 0 : taskStatus.hashCode());
        result = prime * result + ((valid == null) ? 0 : valid.hashCode());
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
        TerminalRemoteUpgradeTask other = (TerminalRemoteUpgradeTask) obj;
        if(failFrameNo == null) {
            if(other.failFrameNo != null)
                return false;
        }
        else if(!failFrameNo.equals(other.failFrameNo))
            return false;
        if(fileId == null) {
            if(other.fileId != null)
                return false;
        }
        else if(!fileId.equals(other.fileId))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(logicalAddr == null) {
            if(other.logicalAddr != null)
                return false;
        }
        else if(!logicalAddr.equals(other.logicalAddr))
            return false;
        if(postTime == null) {
            if(other.postTime != null)
                return false;
        }
        else if(!postTime.equals(other.postTime))
            return false;
        if(schedule == null) {
            if(other.schedule != null)
                return false;
        }
        else if(!schedule.equals(other.schedule))
            return false;
        if(sequence == null) {
            if(other.sequence != null)
                return false;
        }
        else if(!sequence.equals(other.sequence))
            return false;
        if(taskStatus == null) {
            if(other.taskStatus != null)
                return false;
        }
        else if(!taskStatus.equals(other.taskStatus))
            return false;
        if(valid == null) {
            if(other.valid != null)
                return false;
        }
        else if(!valid.equals(other.valid))
            return false;
        return true;
    }

}
