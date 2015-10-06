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
//�ݹ�������нڵ㣬ʱ�临�Ӷ�Ϊ $$O(n)$$, ʹ���˲��ֶ���ռ䣬�ռ临�Ӷ�Ϊ $$O(1)$$.

/*���
�������жԶ��������������Ķ���ݹ��жϣ����Ǵӵݹ������������������� 1. ��������/��ֹ���� - ����ֵ�����á�
2. �ݹ鲽/�����ݹ� - ��ʹԭʼ����������
��ֹ������ȷ��������ǰ�ڵ�Ϊ�գ����߲����϶����������Ķ��壬����ֵ�ֱ���ʲô�أ�
�ȱ𼱣������µݹ鲽�����ȡ��ݹ鲽�ĺ��Ĳ���Ϊ�Ƚϵ�ǰ�ڵ��key�������ӽڵ��key��С���Ͷ��岻���򷵻�false, ����ݹ鴦��
��������Կ����ڽڵ�Ϊ��ʱӦ����true, ���ϲ�����������жϡ�����Ҫע��������ﲻ��Ҫ���Ǹ��ڵ��뵱ǰ�������ӽڵ㣬
����Ҫ�����������и��ڵ����Сֵ���������и��ڵ�����ֵ�����������[10,5,15,#,#,6,20] ���� case ���С�
���ڲ�����Ҫ���ǵ�ǰ���ڵ㣬����Ҫ���Ǹ��ڵ�ĸ��ڵ�... �ʵݹ�ʱ��Ҫ�����Ͻ���½�ֵ��
��ͼ������֪����������������Ҫ�Ƚϸ��ڵ�����Сֵ���������������Ǹ��ڵ��е����ֵ����������������������Ķ���ʱ�����ӽ���ֵһ��С�ڸ��ڵ㣬
���ӽڵ��ֵһ�����ڸ��ڵ㣬������Ƚ����и��ڵ��ֵ��ʹ�õ��Ƽ��ɵ��Ͻ����½磬�����ʵ�ַǳ����
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
