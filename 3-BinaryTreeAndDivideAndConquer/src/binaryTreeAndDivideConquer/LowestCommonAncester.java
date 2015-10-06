/*Lowest Common Ancestor

Given the root and two nodes in a Binary Tree. Find the lowest common 
ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is 
the ancestor of both nodes.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
*/
/*Follow Up Question 1: ������е�ÿ���ڵ�洢���Լ���parent�ڵ㣬�㷨Ӧ����ʲô���ģ�
Follow Up Question 2: ������е�ÿ���ڵ�û�д洢�Լ���parent�ڵ㣬��������ö������ĸ��ڵ㣬�㷨Ӧ����ʲô���ģ�
*/

/*1.��root��ʼ���������n1��n2�е���һ����rootƥ�䣬��ôroot����LCA��
2.�������ƥ�䣬��ֱ�ݹ�����������
 (1)�����һ�� key��n1��n2����������������������һ��key(n1��n2)����������������root����LCA.  
 (2)�������key������������������˵��LCA���������У�������������*/
 
package binaryTreeAndDivideConquer;

public class LowestCommonAncester {
	public static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2){
		if (root == null){
			return null;
		}
		if (node1 == root || node2 == root){//remember this condition
			return root;
		}
		//divide
		TreeNode left = LCA(root.left, node1, node2);
		TreeNode right = LCA(root.right, node1, node2); 
		
		//conquer
		if (left != null && right != null){
			return root;
		}
		if (left != null){
			return left;
		}
		if (right != null){
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*4
		 / \
		3   7
		   / \
		  5   6
		LCA(3, 5) = 4

		LCA(5, 6) = 7

		LCA(6, 7) = 7*/
		
		TreeNode r1 = new TreeNode(4);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(7);
		TreeNode r4 = new TreeNode(5);
		TreeNode r5 = new TreeNode(6);
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
		/*LCA(3, 5) = 4*/
		/*System.out.println(LCA(r1, r2, r4));*/
		/*LCA(5, 6) = 7*/
		/*System.out.println(LCA(r1, r4, r5));
		/*LCA(6, 7) = 7*/
		System.out.println(LCA(r1, r5, r3).value);
	}

}
