package org.hhraymond.algo.list;

/**
 *
 * @author hhraymond
 * @since 2019-07-16
 */
public class SolutionList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("操作前:");
        ListNode node = node1;
        while (node.next != null) {
            System.out.println(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val + "->");

        reverseBetween(node1, 2, 4);
        //removeNthFromEnd(node1, 2);

        System.out.println("操作后:");
        node = node1;
        while (node.next != null) {
            System.out.println(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val + "->");
    }

    /**
    *
     给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     示例：
     给定一个链表: 1->2->3->4->5, 和 n = 2.
     当删除了倒数第二个节点后，链表变为 1->2->3->5.
    *
    * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     *
     将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     示例：
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     *
     * */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /*
    * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    * 说明: 1 ≤ m ≤ n ≤ 链表长度。
    * 示例:
    * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
    * 输出: 1->4->3->2->5->NULL
    *
    * */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
