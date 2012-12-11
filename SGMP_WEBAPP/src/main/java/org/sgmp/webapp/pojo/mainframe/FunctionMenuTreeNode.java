package org.sgmp.webapp.pojo.mainframe;

import org.sgmp.webapp.pojo.tree.TreeNode;

/**
 * 
 * @author Nick
 *
 */
public class FunctionMenuTreeNode extends TreeNode {

    /**
     * 
     */
    private static final long serialVersionUID = -1277754301199481791L;

    /**
     * 
     */
    public FunctionMenuTreeNode() {
        super();
    }

    /**
     * 
     * @param id
     * @param text
     * @param leaf
     */
    public FunctionMenuTreeNode(String id, String text, boolean leaf) {
        super(id, text, leaf);
    }
}
