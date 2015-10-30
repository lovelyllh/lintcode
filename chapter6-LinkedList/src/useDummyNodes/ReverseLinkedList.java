/*Reverse Linked List
question: http://www.lintcode.com/en/problem/reverse-linked-list/

Reverse a linked list.

Example
For linked list 1->2->3, the reversed linked list is 3->2->1

Challenge
Reverse it in-place and in one-pass
*/

package useDummyNodes;
public class ReverseLinkedList {
	public static ListNode reverseLinkedList(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		ListNode pre = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;		
		}
		return pre;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1->2->3*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(reverseLinkedList(n1).val);
	}
}
