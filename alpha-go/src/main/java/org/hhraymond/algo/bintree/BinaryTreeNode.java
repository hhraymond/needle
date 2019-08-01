package org.hhraymond.algo.bintree;

/**
 * @author hhraymond
 * @since 2019-01-14
 */
public class BinaryTreeNode {
    public Object data;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(Object data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.leftNode = left;
        this.rightNode = right;

    }

    public BinaryTreeNode(Object data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}
