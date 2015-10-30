/*Remove Duplicates from Sorted List II
question: http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/

Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
	*/	

package useDummyNodes;
public class RemoveDuplicatesFromSortedListII {
	public static ListNode removeAllDuplicates(ListNode head){
		if (head == null){
			return null;
		}
		ListNode dummy = new ListNode(0);
		//we use dummy node to make sure the first node can't be deleted
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null){
			if (pre.next.val == pre.next.next.val){
				int prevalue = pre.next.val;//first record the duplicate value
				while (pre.next != null && pre.next.val == prevalue){
					//then parse the next duplicate node 
					pre.next = pre.next.next;
				}				
			}else{
				pre = pre.next;
			}
		}
		return dummy.next;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given 1->1->1->2->3, return 2->3.*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		System.out.println(removeAllDuplicates(n1).val);
	}
}
