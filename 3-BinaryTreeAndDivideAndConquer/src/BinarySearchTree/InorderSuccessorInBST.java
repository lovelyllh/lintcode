/*Inorder Successor in BST
question: http://www.lintcode.com/en/problem/inorder-successor-in-bst/
answer:  http://www.jiuzhang.com/solutions/inorder-successor-in-bst/

Given a binary search tree and a node in it, find the in-order successor of that 
node in the BST.

Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Note
If the given node has no in-order successor in the tree, return null.

Challenge
O(h), where h is the height of the BST.
*/

package BinarySearchTree;

import binaryTreeAndDivideConquer.TreeNode;

public class InorderSuccessorInBST {
	public static TreeNode inorderSuccesor(TreeNode root, TreeNode node){
		if (root == null || node == null){
			return null;
		}
		TreeNode successor = null;
		while (root != null && root.value != node.value){
			if (node.value < root.value){
				successor = root;
				root = root.left;
			}else{
				root = root.right;
			}
		}
		if (root.right == null){
			return successor;
		}
		root = root.right;
		if (root.left != null){
			root = root.left;
		}
		return root;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(2);
		TreeNode r2 = new TreeNode(1);
		TreeNode r3 = new TreeNode(3);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = null;
		r3.right = null;
		System.out.println(inorderSuccesor(r1, r1).value);
	}
}
