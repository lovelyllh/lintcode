/*Reorder List
question: http://www.lintcode.com/en/problem/reorder-list/

Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

Example
For example,
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
*/
package FastSlowPointers;

import useDummyNodes.ListNode;

/*
1) Find the middle node
2) Reverse the second part of the list
3) Merge the first and the second list*/
public class ReorderList {
	public static ListNode reorderlist(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		//1. get middle
		ListNode middle = findmiddle(head);
		//2. reverse the right part
		ListNode right = reverse(middle.next);
		middle.next = null;
		//3. merge the left part and the right part
		return merge(head, right);	
	}
	
	private static ListNode findmiddle(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static ListNode reverse(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode newhead = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = newhead;
			newhead = head;
			head = temp;
			
		}
		return newhead;		
	}
	
	private static ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int index = 0;
		while (head1 != null && head2 != null){
			if (index % 2 == 0){//0 % 2 == 0; 1 % 2 == 1; 2 % 2 == 0
				tail.next = head1;
				head1 = head1.next;
			}else{
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
			index++;
		}
		while (head1 != null){
			tail.next = head1;
		}
		while (head2 != null){
			tail.next = head2;
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given 1->2->3->4->null, reorder it to 1->4->2->3->null.*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		System.out.println(reorderlist(n1).val);
	}
}
