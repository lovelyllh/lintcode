package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.Stack;

/*Binary Tree Postorder Traversal
question: http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
answer: http://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/

Given a binary tree, return the postorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 
return [3,2,1].

Challenge
Can you do it without recursion?
*/

//version 4-iteration 
/*
 我们使用prev变量跟踪上一次访问的节点。假设栈顶元素是curr。
 1. 当prev是curr的父节点时，我们正在向下遍历树。
            (1)此时，优先遍历curr的左孩子（将左孩子压入栈）。
            (2)如果没有左孩子，再看右孩子。
            (3)如果左右孩子都不存在（curr是叶节点），就输出curr的值并弹出栈顶元素。

2. 如果prev是curr的左孩子，我们正在从左子树向上遍历。
(1)我们看一下curr的右孩子。如果可以，就从右孩子向下遍历（将右孩子压入栈），
(2) 否则打印curr的值并弹出栈顶元素。

3. 如果prev是curr的右孩子，我们正在从右子树向上遍历。打印curr的值并弹出栈顶元素。
*/

public class BinaryTreePostorderTraversal4 {
	public static ArrayList<Integer> postTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null){
			return result;
		}
		Stack<TreeNode> st = new Stack<TreeNode>(); 
		TreeNode current = root;
		TreeNode pre = null;
		st.push(root);
		while (!st.empty()){
			current = st.peek();
			//case 1: pre is the parent node, it is searching down the left subtree.
			if (pre == null || pre.left == current || pre.right == current ){
				if (current.left != null){
					st.push(current.left);
				}if (current.right != null){
					st.push(current.right);
				}
			}else if (current.left == pre){ //case 2, we are backtracking up the left subtree
				if (current.right != null){
					st.push(current.right);
				}
			}else{//case 3, travese up the right tree
				result.add(current.value);
				st.pop();
			}
			pre = current;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		r1.left = null;
		r1.right = r2;
		r2.left = r3;
		r2.right = null;
		r3.left = null;
		r3.right = null;
		System.out.println(postTraversal(r1));
	}

}
