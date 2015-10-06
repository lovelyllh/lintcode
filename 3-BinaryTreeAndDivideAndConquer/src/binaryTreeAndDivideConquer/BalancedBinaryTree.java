/*Balanced Binary Tree
question: http://www.lintcode.com/en/problem/balanced-binary-tree/
answer: http://www.jiuzhang.com/solutions/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not
*/

/*Analysis
Use Divide and Conquer!
How to divide? We try to analyze the left and right subtrees of root, here we can say
1. They should be Balanced Binary Tree no doubt!
2. Difference of their maximum depths should not exceed 1
How to conquer? We put the left subtrees to be balanced, right to be balanced, we calculate the difference of their maximum depth. We can use code from previous maxDepth method
*/
package binaryTreeAndDivideConquer;

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root){
		if (root == null){
			return true;
		}
		if (maxDepth(root) == -1){
			return false;
		}
		return true;
	}
	//if balanced, return depth, if not balanced, return -1
	public static int maxDepth(TreeNode root){
		if (root == null){
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1; //if left subtree is not balanced || .....
		}//left and right could return -1 in the recursive process
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

		A)  3            B)    3 
		   / \                  \
		  9  20                 20
		    /  \                / \
		   15   7              15  7
		   */
		
		TreeNode r1 = new TreeNode(3);
		TreeNode r2 = new TreeNode(9);
		TreeNode r3 = new TreeNode(20);
		TreeNode r4 = new TreeNode(15);
		TreeNode r5 = new TreeNode(7);
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
		
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(20);
		TreeNode a3 = new TreeNode(15);
		TreeNode a4 = new TreeNode(7);
		
		a1.left = null;
		a1.right = a2;
		a2.left = a3;
		a2.right = a4;
		a3.left = null;
		a3.right = null;
		a4.left = null;
		a4.right = null;
		System.out.println(isBalanced(r1));
		System.out.println(isBalanced(a1));
	}
}
