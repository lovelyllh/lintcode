/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


//version2: hash map: 1 traverse
//随机指针指向节点不定，故加入哈希表之前判断一下 key 是否存在即可
/*复杂度分析
遍历一次原链表，判断哈希表中 key 是否存在，故时间复杂度为 $$O(n)$$, 空间复杂度为 $$O(n)$$.
*/
public class CopyListswithRandomPointers2 {
	public RandomListNode copylists(RandomListNode head){
		if (head == null){
			return null;
		}
		//create a dummy node
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode current = dummy;
		//create a hashmap
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (head != null){
			RandomListNode newnode = null;
			//1. link new node to new list 
			if (map.containsKey(head)){
				newnode = map.get(head);
			}else{
				newnode = new RandomListNode(head.label);
				map.put(head, newnode);
			}
			current.next = newnode;
			//2. re-mapping old random node to new node
			if (head.random != null){
				if (map.containsKey(head.random)){
					newnode.random = map.get(head.random);
				}else{
					newnode.random = new RandomListNode(head.random.label);
					map.put(head.random, newnode.random);
				}
				
			}
			head = head.next;
			current = current.next;
		}
		return dummy.next;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListswithRandomPointers object = new CopyListswithRandomPointers();
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		n1.random = n3;
		System.out.println(object.copylists(n1));	
	}
}
