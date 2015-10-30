/*Reverse Linked List II
question: http://www.lintcode.com/en/problem/reverse-linked-list-ii/
Reverse a linked list from position m to n.

Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Note
Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.

Challenge
Reverse it in-place and in one-pass
*/
package useDummyNodes;
public class ReverseLinkedListII {
	public static ListNode reverselinkedlistfromrange(ListNode head, int m, int n){
		if (m >= n || head == null){
			return null;
		}
		//use dummy node, because we can't make sure the head
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;//set dummy to be head
		//step1: find the mth node	
		for (int i = 1; i < m; i++){
			if (head == null){//when m is larger than the linkedlist size
				return null;
			}
			head = head.next;
		}
		//step2: reverse the list between m and n
		ListNode premNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode;
		ListNode postnNode = nNode.next;
		for (int i = m; i < n; i++){
			if (postnNode == null){//when n is larger than the linkedlist size
				return null;
			}
			ListNode temp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;	
			postnNode = temp;
		}
		premNode.next = nNode;
		mNode.next = postnNode;
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1->2->3->4->5->NULL, m = 2 and n = 4*/
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
		System.out.println(reverselinkedlistfromrange(n1, 2, 4).val);
	}
}
