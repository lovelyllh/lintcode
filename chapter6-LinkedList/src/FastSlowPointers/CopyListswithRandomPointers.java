/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


//version1: hash map: two traverse
/*复杂度分析
总共要进行两次扫描，所以时间复杂度是 $$O(2n)=O(n)$$, 在链表较长时可能会 TLE(比如 Python). 空间上需要一个哈希表来做结点的
映射，所以空间复杂度也是 $$O(n)$$.
*/
public class CopyListswithRandomPointers {
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
			//1. generate new list with next,link new node to new list
			RandomListNode newnode = new RandomListNode(head.label);
			current.next = newnode;
			//2. map old node head to newnode
			map.put(head, newnode);
			//3. copy old node random pointer
			newnode.random = head.random;
			//第一次链接时勿忘记同时拷贝 random 指针，但此时的 random 指针并没有真正“链接”上，实际上是链接到了原始链表的 node 上。
			//continue
			head = head.next;
			current = current.next;
		}
		//4. re-mapping old random node to new node
		//第二次遍历是为了把原始链表的被链接的 node 映射到新链表中的 node，从而完成真正“链接”。
		current = dummy.next;
		while (current != null){
			if (current.random != null){
				current.random = map.get(current.random);
			}
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
