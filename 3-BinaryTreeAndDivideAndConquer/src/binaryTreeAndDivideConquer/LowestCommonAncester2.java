/*Lowest Common Ancestor

Given the root and two nodes in a Binary Tree. Find the lowest common 
ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is 
the ancestor of both nodes.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
*/
/*Follow Up Question 1: 如果树中的每个节点存储了自己的parent节点，算法应该是什么样的？
Follow Up Question 2: 如果树中的每个节点没有存储自己的parent节点，但给你这棵二叉树的根节点，算法应该是什么样的？
*/
//can't compile
package binaryTreeAndDivideConquer;

import java.util.ArrayList;

public class LowestCommonAncester2 {
	public static ArrayList<TreeNode> getPath2root(TreeNode root){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while (root != null){
			list.add(root);
			root = root.parent; 
		}
		return list;
	}
	
	public static TreeNode getLCA(TreeNode node1, TreeNode node2){
		ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
		list1 = getPath2root(node1); // all the ancestor of node1
		list2 = getPath2root(node2);// all the ancestor of node2
		int i;
		int j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--){
			if (list1.get(i) != list2.get(j)){
				return list1.get(i).parent;
			}
		}
		return list1.get(i + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*4
		 / \
		3   7
		   / \
		  5   6
		LCA(3, 5) = 4

		LCA(5, 6) = 7

		LCA(6, 7) = 7*/
		
		TreeNode r1 = new TreeNode(4);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(7);
		TreeNode r4 = new TreeNode(5);
		TreeNode r5 = new TreeNode(6);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = r4;
		r3.right = r5;
		r4.left = null;
		r4.right = null;
		r5.left = null;
		r5.right = null;
		/*LCA(3, 5) = 4*/
		/*System.out.println(LCA(r1, r2, r4));*/
		/*LCA(5, 6) = 7*/
		/*System.out.println(LCA(r1, r4, r5));
		/*LCA(6, 7) = 7*/
		System.out.println(getLCA(r5, r3).value);

	}

}
