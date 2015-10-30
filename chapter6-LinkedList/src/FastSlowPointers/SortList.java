/*Sort List
question: http://www.lintcode.com/en/problem/sort-list/

Sort a linked list in O(n log n) time using constant space complexity.

Have you met this question in a real interview? Yes
Example
Given 1-3->2->null, sort it to 1->2->3->null.
*/
package FastSlowPointers;

import useDummyNodes.ListNode;
//version1: Merge sort
public class SortList {
	public static ListNode sortlist(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		//steps: 1. find median 2. split to left and right 3. merge left and right
		//step1: find median
		ListNode mid = findMiddle(head);
		//step2: split to left and right
		ListNode right = sortlist(mid.next); //right part'head is median + 1
		mid.next = null;
		ListNode left = sortlist(head);//left part is from head to median - 1
		//step3: merge
		return merge(left, right);	
	}
	//find middle node
	public static ListNode findMiddle(ListNode head){
		//when fast goes all the way to end, slow reaches middle
		if (head == null || head.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		//fast.next can't be nul because we will have fast.next.next below
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	//merge two sorted list
	public static ListNode merge(ListNode left, ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;//one dummy node
		while (left != null && right != null){
			if (left.val < right.val){
				tail.next = left;
				left = left.next;
			}else{
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}
		if (left != null){
			tail.next = left;
		}else{
			tail.next = right;
		}		
		return dummy.next;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(sortlist(n1).val);
	}
}
