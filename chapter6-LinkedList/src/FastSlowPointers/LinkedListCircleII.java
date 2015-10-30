/*Linked List Cycle II
question: http://www.lintcode.com/en/problem/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Example
Given -21->10->4->5, tail connects to node index 1£¬·µ»Ø10

Challenge
Follow up:
Can you solve it without using extra space?
*/
package FastSlowPointers;

import useDummyNodes.ListNode;

public class LinkedListCircleII {
	public static ListNode detectCircle(ListNode head){
		if (head == null || head.next == null){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode temp = head;
		//1. detect if the linkedlist has cycle
		while (fast != slow){
			if (fast == null || fast.next == null){
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		 //2. if slow.next == temp, the place is the cycle entrance
		while (slow.next != temp){
			slow = slow.next;
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
