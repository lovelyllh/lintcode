package FastSlowPointers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import useDummyNodes.ListNode;

public class MergeKsortedLists2{
	
	/*1. use an innerclass priorityqueuesort and comparator interface to
	compare two object using comparator interface
	ps: inner class can't be static
	*/

	public class PriorityQueueSort implements Comparator<ListNode>{
		@Override
		public int compare(ListNode left, ListNode right) {
			// TODO Auto-generated method stub
			if (left == null){
				return 1;
			}else if (right == null){
				return -1;
			}
			return left.val - right.val;
		}
	}
	
	
	public ListNode mergeksortedlists(List<ListNode> lists){
		if (lists == null || lists.size() == 0){
			return null;
		}
		//comparator
		PriorityQueueSort pqs = new PriorityQueueSort();
		//1. implement a priority queue using heap
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), pqs);
		//2. add the head of the three linkedlist to heap.
		for (ListNode node: lists){
			if (node != null){
				heap.offer(node);
			}
		}
		//2. dummy node
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		//3. get the smallest element from
		while (!heap.isEmpty()){
			//pop up the smallest head
			ListNode head = heap.poll();//get the smallest element
			tail.next = head;	
			tail = head;
			//add the head.next to the heap,
			if (head.next != null){
				heap.add(head.next);
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*[
		  2->4->null,
		  null,
		  -1->null
		],
		return -1->2->4->null.*/
		//linkedlist n
		
		//create an instance of the class
		MergeKsortedLists2 ms = new MergeKsortedLists2();
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		n1.next = n2;
		n2.next = null;
		//linkedlist m
		ListNode m1 = null;
		//linkedlist k
		ListNode k1 = new ListNode(-1);
		k1.next = null;
		
		List<ListNode> lists = new LinkedList<ListNode>();
		lists.add(n1);
		lists.add(m1);
		lists.add(k1);
		
		System.out.println(ms.mergeksortedlists(lists).val);	
	}
}
