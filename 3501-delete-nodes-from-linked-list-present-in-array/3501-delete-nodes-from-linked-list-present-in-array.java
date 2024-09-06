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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        ListNode prev = dummyHead;
        ListNode cur = dummyHead.next;
        while(cur != null){
                if(set.contains(cur.val)){
                    cur = cur.next;
                    prev.next = cur;
                }else{
                    prev = cur;
                    cur= cur.next;
                }
        }
        return dummyHead.next;
    }
}