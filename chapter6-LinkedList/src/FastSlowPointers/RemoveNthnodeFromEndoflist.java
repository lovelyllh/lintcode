/*Remove Nth Node From End of List
question: http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/

Given a linked list, remove the nth node from the end of list and return its head.

Example
Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.
Note
The minimum number of nodes in list is n.

Challenge
O(n) time
*/
package FastSlowPointers;

import useDummyNodes.ListNode;

public class RemoveNthnodeFromEndoflist {
	public static ListNode removeNthfromend(ListNode head, int n){
		if (head == null || n <= 0){
			return head;
		}	
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		pre.next = head;
		//1. find the index of the last element
		int index = 0;
		while (pre.next != null){
			pre = pre.next;
			index++;
		}
		if (index == n){
			dummy.next = head.next;
			return dummy.next;
		}else if (index < n){
			return head;
		}else{
			for (int i = 1; i < index - n; i++){
				head = head.next;
			}
			head.next = head.next.next;
			return dummy.next;
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1->2->3->4->5->null, and n = 2.*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		int n = 2;
		System.out.println(removeNthfromend(n1, n).val);
	}
}
