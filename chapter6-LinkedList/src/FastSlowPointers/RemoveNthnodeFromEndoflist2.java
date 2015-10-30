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
//version2: fastslow pointers
public class RemoveNthnodeFromEndoflist2 {
	public static ListNode removeNthfromend(ListNode head, int n){
		if (head == null || n <= 0){
			return head;
		}	
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy;
		ListNode fast = dummy;
		dummy.next = head;
		//1. fast pointers
		for (int i = 0; i < n; i++){
			if (fast == null){
				return null;
			}
			fast = fast.next;
		}
		//2. slow pointer and fast pointer
		while (fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
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
