package LeetCode;

// Definition for singly-linked list.
public class lt_02_addtwonumbers {
    int val;
    lt_02_addtwonumbers next;
    lt_02_addtwonumbers() {}
    lt_02_addtwonumbers(int val) { this.val = val; }
    lt_02_addtwonumbers(int val, lt_02_addtwonumbers next) { this.val = val; this.next = next; }
}

class Solution {
    public lt_02_addtwonumbers addTwoNumbers(lt_02_addtwonumbers l1, lt_02_addtwonumbers l2) {
        lt_02_addtwonumbers dummy = new lt_02_addtwonumbers(0);
        lt_02_addtwonumbers curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new lt_02_addtwonumbers(sum % 10);
            curr = curr.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            curr.next = new lt_02_addtwonumbers(carry);
        }
        
        return dummy.next;
    }
}
