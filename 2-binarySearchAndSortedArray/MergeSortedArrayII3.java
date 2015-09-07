package binarySearchAndSortedArray;
/*Merge Sorted Array II
Question: http://www.lintcode.com/en/problem/merge-sorted-array-ii/#

Merge two given sorted integer array A and B into a new sorted integer array.
Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?

Answer: http://www.cnblogs.com/EdwardLiu/p/4340934.html

*/

public class MergeSortedArrayII3 {
	public static void mergeArray(int[] A, int[] B){
		if (A == null || A.length == 0){
			return;
		}
		if (B == null || B.length == 0){
			return;
		}
		if ((A == null || A.length == 0) && (B == null || B.length == 0)){
			return;
		}
		int aIndex = A.length - 1;
		int bIndex = B.length - 1;
		int rIndex = A.length + B.length - 1;
		int[] C = new int[A.length + B.length];
		while (aIndex >= 0 && bIndex >= 0){
			if (A[aIndex] > B[bIndex]){
				C[rIndex--] = A[aIndex--];
			}else{
				C[rIndex--] = B[bIndex--];
			}
		}
		while (aIndex >= 0){
			C[rIndex--] = A[aIndex--];
		}
		while (bIndex >= 0){
			C[rIndex--] = B[bIndex--];
		}
		for (int i = 0; i < A.length + B.length; i++){
			System.out.println(C[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		int[] B = {2,4,5,6};
		mergeArray(A, B);
	

	}

}
