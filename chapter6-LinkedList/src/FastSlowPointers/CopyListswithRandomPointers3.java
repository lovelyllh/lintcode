/*Copy List with Random Pointer
question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

*/
package FastSlowPointers;

import java.util.HashMap;


/*version3: No hash map
*第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。 然后扫描过程中 先建立copy节点
1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy， 拆分节点, 一边扫描一边拆成两个链表，
这里用到两个dummy node。第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  
*/

/*随机指针指向节点不定，故加入哈希表之前判断一下 key 是否存在即可
前两个的解法很显然，需要额外的空间。这个额外的空间是由 hash table 的维护造成的。因为当我们访问一个结点时可能它的 random 
指针指向的结点还没有访问过，结点还没有创建, 所以需要用 hash table 的额外线性空间维护。*/
/*复杂度分析
遍历一次原链表，判断哈希表中 key 是否存在，故时间复杂度为 $$O(n)$$, 空间复杂度为 $$O(1)$$.
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
