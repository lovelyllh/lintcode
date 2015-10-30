/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


//version2: hash map: 1 traverse
//���ָ��ָ��ڵ㲻�����ʼ����ϣ��֮ǰ�ж�һ�� key �Ƿ���ڼ���
/*���Ӷȷ���
����һ��ԭ�����жϹ�ϣ���� key �Ƿ���ڣ���ʱ�临�Ӷ�Ϊ $$O(n)$$, �ռ临�Ӷ�Ϊ $$O(n)$$.
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
