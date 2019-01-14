package org.hhraymond.algo.bintree;

/**
 * @author huangzhen@u51.com
 * @since 2019-01-14
 */
public class BaseConvert {

    public static void main(String[] args) {

    }

    /******
     * 问题：剑指Offer 叉搜索树转换为双向链表 27
     * https://www.cnblogs.com/keedor/p/4467040.html
     解答思路：
     1、中序遍历，左指针指向上一个，右指针指向下一个
     2、原先指向左子节点的指针调整为链表中指向前一个节点的指针
        原先指向右子节点的指针调整为链表中指向后一个节点的指针
     ******/
    public static BinaryTreeNode baseconvert(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root == null) {
            return lastNode;
        }
        BinaryTreeNode current = root;
        if (current.leftNode != null) {
            lastNode=baseconvert(current.leftNode, lastNode);
        }
        current.leftNode = lastNode;
        if (lastNode != null) {
            lastNode.rightNode = current;
        }
        lastNode = current;
        if (current.rightNode != null) {
            lastNode=baseconvert(current.rightNode, lastNode);
        }
        return lastNode;
    }
}
