/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode output = new ListNode(0);
        ListNode tail = output;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 !=null)
            tail.next = list1;
        else if (list2 !=null)
            tail.next = list2;
        return output.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1){
            ListNode result[] = new ListNode[(lists.length+1)/2];
            for (int i = 0; i < lists.length; i +=2){
               ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null  ;
                result[i / 2] = mergeTwoLists(l1, l2);
            }
            lists = result;
        }
        return lists[0];
    }
}