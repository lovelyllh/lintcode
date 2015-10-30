/*Remove Nth Node From End of List
question: http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element 
appear only once.

Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

package useDummyNodes;
public class RemoveDuplicatesFromSortedList {
	public static ListNode removeDuplicate(ListNode head){
		if (head == null){
			return null;
		}
		ListNode pre = head;
		while (pre.next != null){
			if (pre.next.val != pre.val){
				pre = pre.next;
			}else{
				pre.next = pre.next.next;
			}
		}
		return head;			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1->2->3->4->5->null, and n = 2*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(removeDuplicate(n1).val);
	}
}
