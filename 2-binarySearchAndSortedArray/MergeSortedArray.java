/*Merge Sorted Array
 * 1. question:  http://www.lintcode.com/en/problem/merge-sorted-array/#
 Given two sorted integer arrays A and B, merge B into A as one sorted array.
Example
A = [1, 2, 3, empty, empty], B = [4, 5]
After merge, A will be filled as [1, 2, 3, 4, 5]
Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?
Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional 
elements from B. The number of elements initialized in A and B are m and n respectively.

 * 2. Answer:
 * http://www.jiuzhang.com/solutions/merge-sorted-array/
 * 复杂度分析

最坏情况下需要遍历两个数组中所有元素，时间复杂度为 O(n). 空间复杂度 O(1).
 * 
 * */


package binarySearchAndSortedArray;

public class MergeSortedArray {
	public static void mergeSortedArray(int[] A, int m, int[] B, int n){
		int aIndex = m - 1;
		int bIndex = n - 1;
		int rIndex = m + n - 1;
		int[] C = new int[m + n];
		//compare A[aindex] and B[bIndex} and add the larger one to the last index of the result set.
		while (aIndex >= 0 && bIndex >= 0){
			if (A[aIndex] < B[bIndex]){
				C[rIndex] = B[bIndex];
				rIndex--;
				bIndex--;
			}else{
				C[rIndex] = A[aIndex];
				rIndex--;
				aIndex--;
			}
		}
		//add the left numbers
		while (aIndex >= 0){
			C[rIndex] = A[aIndex];
			rIndex--;
			aIndex--;
		}
		while (bIndex >= 0){
			C[rIndex] = B[bIndex];
			rIndex--;
			bIndex--;
		}
		for(int i = 0; i < m + n; i++){
			System.out.println(C[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayA = {1,2,3};
		int[] arrayB = {4,5};
		mergeSortedArray(arrayA, arrayA.length, arrayB, arrayB.length);
	}

}
