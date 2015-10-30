package FastSlowPointers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import useDummyNodes.ListNode;

public class MergeKsortedLists{
	//compare two object using comparator interface
	public static Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){

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
		
		/* 1. compare method
		 private int compare(Object left, Object right) {
			if( priority == null ) {
				return ((Comparable)left).compareTo(right);
			} else {
				return priority.compare(left,right);
			} 
		} 
		
		2. compareTo method
		public int compareTo( NumberSubClass referenceName )
		
		If the Integer is equal to the argument then 0 is returned.
		If the Integer is less than the argument then -1 is returned.
		If the Integer is greater than the argument then 1 is returned.
		*/
	};
	
	public static ListNode mergeksortedlists(List<ListNode> lists){
		if (lists == null || lists.size() == 0){
			return null;
		}
		//1. implement a priority queue using heap
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		//2. add the head of the three linkedlist to heap.
		for (int i = 0; i < lists.size(); i++){
			if (lists.get(i) != null){
				heap.add(lists.get(i));
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
		
		System.out.println(mergeksortedlists(lists).val);
		
	}
}
