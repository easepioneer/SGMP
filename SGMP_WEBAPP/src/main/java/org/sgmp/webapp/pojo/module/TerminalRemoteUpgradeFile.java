package org.sgmp.webapp.pojo.module;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Nick
 *
 */
public class TerminalRemoteUpgradeFile implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 348820536600860359L;

    private Long id;                            // FILE_ID
    private String version;                     // FILE_VERSION
    private String name;                        // FILE_NAME
    private File binfile;                       // BINFILE
    private Date postTime;                      // POST_TIME

    public TerminalRemoteUpgradeFile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getBinfile() {
        return binfile;
    }

    public void setBinfile(File binfile) {
        this.binfile = binfile;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "TerminalRemoteUpgradeFile [id=" + id + ", version=" + version
                + ", name=" + name + ", binfile=" + binfile + ", postTime="
                + postTime + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((binfile == null) ? 0 : binfile.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((postTime == null) ? 0 : postTime.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        TerminalRemoteUpgradeFile other = (TerminalRemoteUpgradeFile) obj;
        if(binfile == null) {
            if(other.binfile != null)
                return false;
        }
        else if(!binfile.equals(other.binfile))
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
        if(postTime == null) {
            if(other.postTime != null)
                return false;
        }
        else if(!postTime.equals(other.postTime))
            return false;
        if(version == null) {
            if(other.version != null)
                return false;
        }
        else if(!version.equals(other.version))
            return false;
        return true;
    }

}
