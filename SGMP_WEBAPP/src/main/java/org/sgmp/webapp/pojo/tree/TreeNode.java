package org.sgmp.webapp.pojo.tree;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Nick
 *
 */
public class TreeNode implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8606142262738320503L;

    protected String id;
    protected String text;
    protected String cls;
    protected String iconCls;
    protected String qtip;
    protected String qtitle;
    protected Boolean leaf;
    protected Boolean expanded;
    protected List<?> children;

    /**
     * 
     */
    public TreeNode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getQtip() {
        return qtip;
    }

    public void setQtip(String qtip) {
        this.qtip = qtip;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode [id=" + id + ", text=" + text + ", cls=" + cls
                + ", iconCls=" + iconCls + ", qtip=" + qtip + ", qtitle="
                + qtitle + ", leaf=" + leaf + ", expanded=" + expanded
                + ", children=" + children + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((children == null) ? 0 : children.hashCode());
        result = prime * result + ((cls == null) ? 0 : cls.hashCode());
        result = prime * result
                + ((expanded == null) ? 0 : expanded.hashCode());
        result = prime * result + ((iconCls == null) ? 0 : iconCls.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((leaf == null) ? 0 : leaf.hashCode());
        result = prime * result + ((qtip == null) ? 0 : qtip.hashCode());
        result = prime * result + ((qtitle == null) ? 0 : qtitle.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
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
        TreeNode other = (TreeNode) obj;
        if(children == null) {
            if(other.children != null)
                return false;
        }
        else if(!children.equals(other.children))
            return false;
        if(cls == null) {
            if(other.cls != null)
                return false;
        }
        else if(!cls.equals(other.cls))
            return false;
        if(expanded == null) {
            if(other.expanded != null)
                return false;
        }
        else if(!expanded.equals(other.expanded))
            return false;
        if(iconCls == null) {
            if(other.iconCls != null)
                return false;
        }
        else if(!iconCls.equals(other.iconCls))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        }
        else if(!id.equals(other.id))
            return false;
        if(leaf == null) {
            if(other.leaf != null)
                return false;
        }
        else if(!leaf.equals(other.leaf))
            return false;
        if(qtip == null) {
            if(other.qtip != null)
                return false;
        }
        else if(!qtip.equals(other.qtip))
            return false;
        if(qtitle == null) {
            if(other.qtitle != null)
                return false;
        }
        else if(!qtitle.equals(other.qtitle))
            return false;
        if(text == null) {
            if(other.text != null)
                return false;
        }
        else if(!text.equals(other.text))
            return false;
        return true;
    }

}
