package org.hhraymond.algo.bintree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *         10
 *        /  \
 *       6   14
 *      / \  / \
 *     4  8 12 16
 *
 * 前序(先根)：根结点 ---> 左子树 ---> 右子树
 * 10 - 6 - 4 - 8 - 14 - 12 - 16
 *
 * 后序(后根)：左子树 ---> 右子树 ---> 根结点
 * 4 - 8 - 6 - 12 - 16 - 14 - 10
 *
 * 中序：左子树 ---> 根结点 ---> 右子树
 * 4 - 6 - 8 - 10 - 12 - 14 - 16
 *
 * @author hhraymond
 * @since 2019-01-14
 */
public class BaseConvert {

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node4, node8);

        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node16 = new BinaryTreeNode(16);
        BinaryTreeNode node14 = new BinaryTreeNode(14, node12, node16);

        BinaryTreeNode node10 = new BinaryTreeNode(10, node6, node14);

        System.out.println("====pre root======");
        preRootDumpTree(node10);
        System.out.println("====post root=====");
        postRootDumpTree(node10);
        System.out.println("====mid root======");
        midRootDumpTree(node10);
        System.out.println("====deep======");
        System.out.println("deep: " + treeDeep(node10));
        System.out.println("====levelOrder======");
        levelOrder(node10);

        List<List<Integer>> list = levelOrder2(node10);
        System.out.println("====levelOrder2======");
        dumpArray(list);


        System.out.println("====convert======");
        BinaryTreeNode nodeC = null;
        BinaryTreeNode nodeR = baseconvert(node10, nodeC);
        dumpList(nodeR);
    }

    public static void dumpList(BinaryTreeNode node) {
        if (node != null) {
            System.out.println("list: " + node.data);
            dumpList(node.leftNode);
        }
    }

    public static void dumpArray(List<List<Integer>> list) {
        list.forEach(i -> {
            i.forEach( j -> {
                System.out.println("list: " + j);
            });
            System.out.println("==");
        });
    }

    public static void preRootDumpTree(BinaryTreeNode node) {
        if (node != null) {
            System.out.println("data: " + node.data);
            preRootDumpTree(node.leftNode);
            preRootDumpTree(node.rightNode);
        }
    }

    public static void postRootDumpTree(BinaryTreeNode node) {
        if (node != null) {
            postRootDumpTree(node.leftNode);
            postRootDumpTree(node.rightNode);
            System.out.println("data: " + node.data);
        }
    }

    public static void midRootDumpTree(BinaryTreeNode node) {
        if (node != null) {
            midRootDumpTree(node.leftNode);
            System.out.println("data: " + node.data);
            midRootDumpTree(node.rightNode);
        }
    }

    // 链表，非递归方式
    public static void levelOrder(BinaryTreeNode root){
        if (root == null) return;
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        BinaryTreeNode currentNode;
        while (!list.isEmpty()){
            currentNode=list.poll();
            System.out.println("levelOrder: " + currentNode.data);
            if (currentNode.leftNode != null){
                list.add(currentNode.leftNode);
            }
            if (currentNode.rightNode != null){
                list.add(currentNode.rightNode);
            }
        }
    }

    // 二叉树层次遍历，按层次返回list
    // 思路：层次遍历，前序方式递归
    public static List<List<Integer>> levelOrder2(BinaryTreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        func(root,0,levelList);
        return levelList;
    }
    public static void func(BinaryTreeNode<Integer> node, int level, List<List<Integer>> levelList){
        if (node == null){
            return;
        }
        if (levelList.size() <= level){
            List<Integer> valList = new ArrayList<>();
            valList.add(node.data);
            levelList.add(valList);
        } else {
            levelList.get(level).add(node.data);
        }
        func(node.leftNode,level+1, levelList);
        func(node.rightNode,level+1, levelList);
    }

    // 后序。后根
    public static int treeDeep(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = treeDeep(node.leftNode);
        int right = treeDeep(node.rightNode);
        return (right > left) ? (right + 1) : (left + 1);
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
            lastNode = baseconvert(current.leftNode, lastNode);
        }
        current.leftNode = lastNode;
        if (lastNode != null) {
            lastNode.rightNode = current;
        }
        lastNode = current;
        if (current.rightNode != null) {
            lastNode = baseconvert(current.rightNode, lastNode);
        }
        return lastNode;
    }
}
