/*Partition List
question: http://www.lintcode.com/en/problem/partition-list/
Given a linked list and a value x, partition it such that all nodes less than x come 
before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.
*/
package useDummyNodes;
public class PartitionList {
	public static ListNode partitionlist(ListNode head, int m){
		if (head == null){
			return null;
		}
		ListNode leftdummy = new ListNode(0);
		ListNode rightdummy = new ListNode(0);
		ListNode left = leftdummy;
		ListNode right = rightdummy; //use two dummy nodes
		while (head != null){
			if (head.val < m){
				left.next = head;
				left = head;
			}else{
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		//add null to the end of the linkedlist
		right.next = null;
		left.next = rightdummy.next;
		return leftdummy.next;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*1->4->3->2->5->2->null and x = 3,*/
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		int m = 3;
		System.out.println(partitionlist(n1,m).val);

	}

}
