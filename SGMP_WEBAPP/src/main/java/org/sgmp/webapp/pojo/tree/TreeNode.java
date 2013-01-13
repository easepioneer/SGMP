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
    protected boolean leaf;
    protected List<?> children;

    /**
     * 
     */
    public TreeNode() {
        super();
    }

    /**
     * 
     * @param id
     * @param text
     * @param leaf
     */
    public TreeNode(String id, String text, boolean leaf) {
        super();
        this.id = id;
        this.text = text;
        this.leaf = leaf;
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

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

}
