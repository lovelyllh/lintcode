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

//recursive version

/*题解 - 递归

二叉树的题使用递归自然是最好理解的，代码也简洁易懂，缺点就是递归调用时栈空间容易溢出，故实际实现中一般使用迭代替代递归，性能更佳嘛。
不过迭代的缺点就是代码量稍(很)大，逻辑也可能不是那么好懂。
既然确定使用递归，那么接下来就应该考虑具体的实现问题了。在递归的具体实现中，主要考虑如下两点： 
1. 基本条件/终止条件 - 返回值需斟酌。 2. 递归步/条件递归 - 能使原始问题收敛。
首先来找找递归步，根据二叉查找树的定义，若插入节点的值若大于当前节点的值，则继续与当前节点的右子树的值进行比较；
反之则继续与当前节点的左子树的值进行比较。题目的要求是返回最终二叉搜索树的根节点，从以上递归步的描述中似乎还难以对应到实际代码，
这时不妨分析下终止条件。

2. 有了递归步，终止条件也就水到渠成了，若当前节点为空时，即返回结果。问题是——返回什么结果？
当前节点为空时，说明应该将「插入节点」插入到上一个遍历节点的左子节点或右子节点。
对应到程序代码中即为root->right = node或者root->left = node. 
也就是说递归步使用root->right/left = func(...)即可。
*/

public class InsertNodeInABinarySearchTree {
	public static TreeNode insertNode(TreeNode root, TreeNode node){
		if (root == null){
			return node;
		}
		if (node == null){
			return root;
		}
		if(root.value > node.value){
			root.left = insertNode(root.left, node);
		}else{
			root.right = insertNode(root.right, node);
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
		System.out.println(insertNode(r1, r5));
	}
}
