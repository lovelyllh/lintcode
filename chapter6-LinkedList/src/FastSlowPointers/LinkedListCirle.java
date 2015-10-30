/*Linked List Cycle
question: http://www.lintcode.com/en/problem/linked-list-cycle/

Given a linked list, determine if it has a cycle in it.

Example
Given -21->10->4->5, tail connects to node index 1, return true

Challenge
Follow up:
Can you solve it without using extra space?
*/
package FastSlowPointers;

import useDummyNodes.ListNode;

public class LinkedListCirle {
	public static boolean hasCircle(ListNode head){
		if (head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		//have circle-> slow meet fast
		while (fast != slow){
			if (fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(-21);
		ListNode n2 = new ListNode(10);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
		System.out.println(hasCircle(n1));
	}
}
