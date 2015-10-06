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
 ����ʹ��prev����������һ�η��ʵĽڵ㡣����ջ��Ԫ����curr��
 1. ��prev��curr�ĸ��ڵ�ʱ�������������±�������
            (1)��ʱ�����ȱ���curr�����ӣ�������ѹ��ջ����
            (2)���û�����ӣ��ٿ��Һ��ӡ�
            (3)������Һ��Ӷ������ڣ�curr��Ҷ�ڵ㣩�������curr��ֵ������ջ��Ԫ�ء�

2. ���prev��curr�����ӣ��������ڴ����������ϱ�����
(1)���ǿ�һ��curr���Һ��ӡ�������ԣ��ʹ��Һ������±��������Һ���ѹ��ջ����
(2) �����ӡcurr��ֵ������ջ��Ԫ�ء�

3. ���prev��curr���Һ��ӣ��������ڴ����������ϱ�������ӡcurr��ֵ������ջ��Ԫ�ء�
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
