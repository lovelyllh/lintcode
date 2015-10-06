package binaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.Stack;

/*Binary Tree Preorder Traversal
 question: http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 answer:  http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
 
Given a binary tree, return the preorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3}:

1
 \
  2
 /
3
return [1,2,3].

Challenge
Can you do it without recursion?
*/
//don't recommend recursion, i can't run trough recursion, why?? it said memory limit

//version 1: Iteration: recommend!
/*For tree problems, every recursive solution usually has a iterative solution, which uses stack to operate inner memory mechanism of recursion. Here we can define a stack and do below things:
1. Add root to the stack, we will pop it later, to expand the tree up side down
2. Pop the node, add it to the result and use a temp TreeNode to do the next expand
3. Look at the node and find whether it has right child, if yes, put the right child in the stack
4. If the current node does not have a right child, try to find whether it has a left child, if yes, put the left child in the stack
5. Do things until the stack is empty and return the rest
*/
public class BinaryTreePreorderTraversal {
	public static ArrayList<Integer> preOrderTraverse(TreeNode root){
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		if (root == null){
			return preorder; //not return to null!!!
		}		
		//first create a stack for iteration
		Stack<TreeNode> st = new Stack<TreeNode>();
		//add root first
		st.push(root);
		TreeNode current = null;
		while (!st.empty()){
			current = st.pop();
			preorder.add(current.value);//first add the current value.
			if (current.right != null){//dont forget it!
				st.push(current.right);
			}
			if (current.left != null){
				st.push(current.left);
			}
		}
		return preorder;
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
		System.out.println(preOrderTraverse(r1));
	}

}
