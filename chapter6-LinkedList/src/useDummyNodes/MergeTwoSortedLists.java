/*Merge Two Sorted Lists
question: http://www.lintcode.com/en/problem/merge-two-sorted-lists/

Merge two sorted (ascending) linked lists and return it as a new sorted list. 
The new sorted list should be made by splicing together the nodes of the two lists 
and sorted in ascending order.

Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.

*/
package useDummyNodes;
public class MergeTwoSortedLists {
	public static ListNode mergetwosortedlist(ListNode l1, ListNode l2){
		if (l1 == null && l2 == null){
			return null;
		}
		//use dummy node, because the head can't be determined
		ListNode dummy = new ListNode(0);
		ListNode lastnode = dummy; //one dummy node	
		while (l1 != null && l2 != null){
			if (l1.val < l2.val){
				lastnode.next = l1;
				l1 = l1.next;
			}else{
				lastnode.next = l2;
				l2 = l2.next;
			}
			lastnode = lastnode.next;
		}
		if (l1 != null){
			lastnode.next = l1.next;
		}
		if (l2 != null){
			lastnode.next = l2.next;
		}
		return dummy.next;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null*/
		ListNode l1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(11);
		ListNode n5 = new ListNode(15);
		
		l1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode l2 = new ListNode(2);
		l2.next = null;
		System.out.println(mergetwosortedlist(l1, l2).val);
	}
}
