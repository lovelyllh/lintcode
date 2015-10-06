/*Validate Binary Search Tree
question: http://www.lintcode.com/en/problem/validate-binary-search-tree/
answer:  http://www.jiuzhang.com/solutions/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example
An example:

  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
*/

//version1: Recursion
//递归遍历所有节点，时间复杂度为 $$O(n)$$, 使用了部分额外空间，空间复杂度为 $$O(1)$$.

/*题解
按照题中对二叉搜索树所给的定义递归判断，我们从递归的两个步骤出发分析： 1. 基本条件/终止条件 - 返回值需斟酌。
2. 递归步/条件递归 - 能使原始问题收敛。
终止条件好确定——当前节点为空，或者不符合二叉搜索树的定义，返回值分别是什么呢？
先别急，分析下递归步试试先。递归步的核心步骤为比较当前节点的key和左右子节点的key大小，和定义不符则返回false, 否则递归处理。
从这里可以看出在节点为空时应返回true, 由上层的其他条件判断。但需要注意的是这里不仅要考虑根节点与当前的左右子节点，
还需要考虑左子树中父节点的最小值和右子树中父节点的最大值。否则程序在[10,5,15,#,#,6,20] 这种 case 误判。
由于不仅需要考虑当前父节点，还需要考虑父节点的父节点... 故递归时需要引入上界和下界值。
画图分析可知对于左子树我们需要比较父节点中最小值，对于右子树则是父节点中的最大值。又由于满足二叉搜索树的定义时，左子结点的值一定小于根节点，
右子节点的值一定大于根节点，故无需比较所有父节点的值，使用递推即可得上界与下界，这里的实现非常巧妙。
*/

//time complexity:O(n)
//space complexity: O(1)
package BinarySearchTree;

import binaryTreeAndDivideConquer.TreeNode;

public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root){
		if (root == null){
			return true;
		}
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		return validBSTHelper(root, min, max);
	}
	
	public static boolean validBSTHelper(TreeNode root, long min, long max){
		if (root == null){
			return true;
		}
		if (min >= root.value || max <= root.value){
			return false;
		}
		boolean left = validBSTHelper(root.left, min, root.value);
		boolean right = validBSTHelper(root.right, root.value, max);	
		return left && right;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(10);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(15);
		TreeNode r4 = new TreeNode(6);
		TreeNode r5 = new TreeNode(20);
		r1.left = r2;
		r1.right = r3;
		r2.left = null;
		r2.right = null;
		r3.left = r4;
		r3.right = r5;
		System.out.println(isValidBST(r1));
	}
}
