package BinarySearchTree;

import binaryTreeAndDivideConquer.TreeNode;

/*Given a binary search tree and a new tree node, insert the node into the tree. 
You should keep the tree still be a valid binary search tree.
question: http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
answer: http://www.jiuzhang.com/solutions/insert-node-in-binary-search-tree/

Example
Given binary search tree as follow, after Insert node 6, the tree should be:

 2             2
/ \           / \
1   4   -->   1   4
  /             / \ 
 3             3   6
Challenge
Can you do it without recursion?
*/

//iteration version
/*题解 - 迭代
看过了以上递归版的题解，对于这个题来说，将递归转化为迭代的思路也是非常清晰易懂的。迭代比较当前节点的值和插入节点的值，
到了二叉树的最后一层时选择是链接至左子结点还是右子节点。
*/
public class InsertNodeInABinarySearchTreeIteration {
	public static TreeNode insertNode(TreeNode root, TreeNode node){
		if (root == null){
			return node;
		}
		if (node == null){
			return root;
		}
		TreeNode current = root; //use two pointers to track position changes
		TreeNode temp = null;
		while (current != null){
			temp = current;
			if (node.value < current.value){
				current = current.left; // update current pointer
			}else{
				current = current.right;
			}
		}
		if (temp!= null){
			if (node.value < temp.value){
				temp.left = node;
			}else{
				temp.right = node;
			}		
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(2);
		TreeNode r2 = new TreeNode(1);
		TreeNode r3 = new TreeNode(4);
		TreeNode r4 = new TreeNode(3);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = r4;
		r3.right = null;
		TreeNode r5 = new TreeNode(6);
		System.out.println(insertNode(r1, r5).value);
	}
}
