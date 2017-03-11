
// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       ListNode aPointer = l1;
	       ListNode bPointer = l2;
	       ListNode cHead = new ListNode(0);
	       ListNode cPointer = cHead;
	       
	       int carry = 0;
	       while(aPointer != null || bPointer != null || carry != 0)
	       {
	    	  int valueA = (aPointer == null)? 0: aPointer.val;
	    	  int valueB = (bPointer == null)? 0: bPointer.val;
	    	  
	    	  int res = valueA + valueB + carry;
	    	  
	    	  ListNode temp = new ListNode(res%10);
	    	  temp.next = null;
	    	  carry = res/10;
	    	  
	    	  cPointer.next = temp;
	    	  cPointer = temp;
	    	  
	    	  aPointer = (aPointer == null)? aPointer:aPointer.next;
	    	  bPointer = (bPointer == null)? bPointer:bPointer.next;
	    	  
	       }
	       return cHead.next;   
	 }
}
public class Ok {
	 public static void main(String[] args){
		Solution aSolution = new Solution();
		
		
		//print
		
		 
   }
}
