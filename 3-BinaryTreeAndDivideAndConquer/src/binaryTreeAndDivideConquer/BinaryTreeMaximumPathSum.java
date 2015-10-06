package binaryTreeAndDivideConquer;
/*Binary Tree Maximum Path Sum
question: http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/
answer: http://www.jiuzhang.com/solutions/binary-tree-maximum-path-sum/

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.

Example
Given the below binary tree:

  1
 / \
2   3
return 6.
*/

//solution 1: recursion
//http://www.cnblogs.com/EdwardLiu/p/3961296.html
/*The general idea to solve the problem is to use recursion. During recursion, we try to calculate the max path and add to max[0], which is because Java cannot send  reference.
Below are the cases of max path that includes root
1. Root itself
2. Root and one path of left subtree
3. Root and one path of right subtree
4. One path from left subtree and another one from right subtree
The first three can be used to calculate the upper level root max path.
Finally, we do not have to go through root in order to find the maximum path, but we can traverse every trended so that the maximum value is already stored in max[0]
	*/
public class BinaryTreeMaximumPathSum {
	
	
	public static int maxPath(TreeNode root){
		if (root == null){
			return 0;
		}
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		getcurrentmaxpath(root, max);
		return max[0] ;
	}
	
	public static int getcurrentmaxpath(TreeNode root, int[] max){
		if (root == null){
			return 0;
		}
		//divide
		int leftsum = getcurrentmaxpath(root.left, max);
		int rightsum = getcurrentmaxpath(root.right, max);
		//conquer
		//单向路径最大值
		int currentsum = Math.max(root.value, Math.max(leftsum + root.value, rightsum + root.value)); 
		//max path that includes root
		max[0] = Math.max(max[0], Math.max(currentsum, leftsum + root.value + rightsum));
		return currentsum;//why return currentsum???
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = null;
		r3.right = null;
		System.out.println(maxPath(r1));
	}
}
