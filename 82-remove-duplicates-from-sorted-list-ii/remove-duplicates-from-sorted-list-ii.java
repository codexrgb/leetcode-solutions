class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {

                // Move curr to the last node having the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // Remove the complete duplicate group
                prev.next = curr.next;

            } else {
                // No duplicate, so move prev
                prev = curr;
            }

            // Move curr
            curr = curr.next;
        }

        return dummy.next;
    }
}