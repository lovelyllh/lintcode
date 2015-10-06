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

/*1.从root开始遍历，如果n1和n2中的任一个和root匹配，那么root就是LCA。
2.如果都不匹配，则分别递归左、右子树，
 (1)如果有一个 key（n1或n2）出现在左子树，并且另一个key(n1或n2)出现在右子树，则root就是LCA.  
 (2)如果两个key都出现在左子树，则说明LCA在左子树中，否则在右子树*/
 
package binaryTreeAndDivideConquer;

public class LowestCommonAncester {
	public static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
		if (root == null){
			return null;
		}
		if (node1 == root || node2 == root){//remember this condition
			return root;
		}
		//divide
		TreeNode left = LCA(root.left, node1, node2);
		TreeNode right = LCA(root.right, node1, node2); 
		
		//conquer
		if (left != null && right != null){
			return root;
		}
		if (left != null){
			return left;
		}
		if (right != null){
			return right;
		}
		return null;
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
		System.out.println(LCA(r1, r5, r3).value);
	}

}
