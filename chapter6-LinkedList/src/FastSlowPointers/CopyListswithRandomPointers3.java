/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


/*version3: No hash map
*��һ��ɨ��ʱ����������nextָ�룬 ��ʼ������1->2->3->4  �� Ȼ��ɨ������� �Ƚ���copy�ڵ�
1->1`->2->2`->3->3`->4->4`, Ȼ��ڶ���copy��ʱ��ȥ�����ߵ�copy�� ��ֽڵ�, һ��ɨ��һ�߲����������
�����õ�����dummy node����һ��������  1->2->3 , Ȼ��ڶ���� 1`->2`->3`  
*/

/*���ָ��ָ��ڵ㲻�����ʼ����ϣ��֮ǰ�ж�һ�� key �Ƿ���ڼ���
ǰ�����Ľⷨ����Ȼ����Ҫ����Ŀռ䡣�������Ŀռ����� hash table ��ά����ɵġ���Ϊ�����Ƿ���һ�����ʱ�������� random 
ָ��ָ��Ľ�㻹û�з��ʹ�����㻹û�д���, ������Ҫ�� hash table �Ķ������Կռ�ά����*/
/*���Ӷȷ���
����һ��ԭ�����жϹ�ϣ���� key �Ƿ���ڣ���ʱ�临�Ӷ�Ϊ $$O(n)$$, �ռ临�Ӷ�Ϊ $$O(1)$$.
*/
public class CopyListswithRandomPointers3 {
	 //version3: No hashMap and O(1) space
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null){
            return null;
        }
        RandomListNode current = head;
        //1. link the new list with node
        while (current != null){
            RandomListNode newnode = new RandomListNode(current.label);
            newnode.next = current.next;
            current.next = newnode;
            current = current.next.next;
        }
        //2. deep copy the random list
        current = head;
        while (current != null){
            if (current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //3.split the linkedlist 1->1'->2->2'....
        RandomListNode newhead = head.next;
        current = head;
        while (current != null) {
            RandomListNode temp = current.next;
            current.next = temp.next;
            current = current.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
       return newhead;
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
