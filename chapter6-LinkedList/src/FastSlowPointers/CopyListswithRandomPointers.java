/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


//version1: hash map: two traverse
/*���Ӷȷ���
�ܹ�Ҫ��������ɨ�裬����ʱ�临�Ӷ��� $$O(2n)=O(n)$$, ������ϳ�ʱ���ܻ� TLE(���� Python). �ռ�����Ҫһ����ϣ����������
ӳ�䣬���Կռ临�Ӷ�Ҳ�� $$O(n)$$.
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
			//��һ������ʱ������ͬʱ���� random ָ�룬����ʱ�� random ָ�벢û�����������ӡ��ϣ�ʵ���������ӵ���ԭʼ����� node �ϡ�
			//continue
			head = head.next;
			current = current.next;
		}
		//4. re-mapping old random node to new node
		//�ڶ��α�����Ϊ�˰�ԭʼ����ı����ӵ� node ӳ�䵽�������е� node���Ӷ�������������ӡ���
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
