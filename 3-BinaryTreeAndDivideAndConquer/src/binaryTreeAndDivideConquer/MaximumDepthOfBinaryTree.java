package binaryTreeAndDivideConquer;
/*Maximum Depth of Binary Tree
question: http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
answer: http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example
Given a binary tree as follow:

  1
 / \ 
2   3
   / \
  4   5
The maximum depth is 3.
*/

//version1: recursive
public class MaximumDepthOfBinaryTree {
	public static int maximumDepth(TreeNode root){
		if (root == null){
			return 0;
		}
		int leftValue;
		int rightValue;
		leftValue= maximumDepth(root.left);
		rightValue = maximumDepth(root.right);
		return Math.max(leftValue, rightValue) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
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
		System.out.println(maximumDepth(r1));
	}
}
