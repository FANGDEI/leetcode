/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class L2两数相加 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = "", b = "";
        while (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }

        while (l2 != null) {
            b += l2.val;
            l2 = l2.next;
        }

        String hp = "";
        if(a.length()<b.length()){
            for(int i=0;i<b.length()-a.length();i++){
                hp+=0;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            hp += a.charAt(i);
        }
        a = hp;
        hp = "";
        if(b.length()<a.length()){
            for(int i=0;i<a.length()-b.length();i++){
                hp+=0;
            }
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            hp += b.charAt(i);
        }
        b = hp;
        System.out.println(a+" "+b);
        String c = "";
        int jin = 0;
        for (int i = a.length()-1; i>=0; i--) {
            if (a.charAt(i) - '0' + b.charAt(i) - '0' + jin >= 10) {
                c += a.charAt(i) - '0' + b.charAt(i) - '0' + jin - 10;
                jin = 1;

            } else {
                c += a.charAt(i) - '0' + b.charAt(i) - '0' + jin;
                jin = 0;
            }
        }
        if(jin==1){
            c+=1;
        }
        ListNode cur = new ListNode(c.charAt(0)-'0');
        ListNode ans = cur;
        for (int i = 1; i <c.length(); i++) {
            ListNode node = new ListNode(c.charAt(i) - '0');
            cur.next = node;
            cur = node;
        }
        return ans;
    }
}