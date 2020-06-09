package com.example.leetcode.easy;


public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = head;
        ListNode pre = new ListNode();
        pre.next = pointer;
        ListNode result = pre;
        while (pointer != null){
            if(pointer.val == val){
                pre.next = pointer.next;
            } else {
                pre = pointer;
            }
            pointer = pointer.next;
        }
        return result.next;
    }

    /**
     * faster solution
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsV1(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode c = head;
        while(c.next != null) {
            if(c.next.val == val)
                c.next = c.next.next;
            else
                c = c.next;
        }
        if(head.val == val)
            head = head.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
