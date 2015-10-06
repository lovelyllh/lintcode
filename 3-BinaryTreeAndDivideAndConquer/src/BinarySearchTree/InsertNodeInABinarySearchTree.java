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

/*��� - �ݹ�

����������ʹ�õݹ���Ȼ��������ģ�����Ҳ����׶���ȱ����ǵݹ����ʱջ�ռ������������ʵ��ʵ����һ��ʹ�õ�������ݹ飬���ܸ����
����������ȱ����Ǵ�������(��)���߼�Ҳ���ܲ�����ô�ö���
��Ȼȷ��ʹ�õݹ飬��ô��������Ӧ�ÿ��Ǿ����ʵ�������ˡ��ڵݹ�ľ���ʵ���У���Ҫ�����������㣺 
1. ��������/��ֹ���� - ����ֵ�����á� 2. �ݹ鲽/�����ݹ� - ��ʹԭʼ����������
���������ҵݹ鲽�����ݶ���������Ķ��壬������ڵ��ֵ�����ڵ�ǰ�ڵ��ֵ��������뵱ǰ�ڵ����������ֵ���бȽϣ�
��֮������뵱ǰ�ڵ����������ֵ���бȽϡ���Ŀ��Ҫ���Ƿ������ն����������ĸ��ڵ㣬�����ϵݹ鲽���������ƺ������Զ�Ӧ��ʵ�ʴ��룬
��ʱ������������ֹ������

2. ���˵ݹ鲽����ֹ����Ҳ��ˮ�������ˣ�����ǰ�ڵ�Ϊ��ʱ�������ؽ���������ǡ�������ʲô�����
��ǰ�ڵ�Ϊ��ʱ��˵��Ӧ�ý�������ڵ㡹���뵽��һ�������ڵ�����ӽڵ�����ӽڵ㡣
��Ӧ����������м�Ϊroot->right = node����root->left = node. 
Ҳ����˵�ݹ鲽ʹ��root->right/left = func(...)���ɡ�
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
