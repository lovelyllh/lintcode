package binarySearchAndSortedArray;

/*Median of two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
Given A=[1,2,3] and B=[4,5], the median is 3.
Challenge
The overall run time complexity should be O(log (m+n)).
*/

public class MedianOfTwoSortedArray {
	public static double findMedianOfTwoSortedArray(int[]A, int[]B){
		//corner check
		if ((A == null || A.length == 0) && (B == null || B.length == 0)){
			return 0;
		}
		int len = A.length + B.length;
		//if the length is even, get the average number of  len/2 and len/2 + 1. else, get the 
		if (len % 2 == 0){
			return (findKth(A, 0, B, 0,len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
			//e.g Given A=[1,2] and B=[4,5], the median is 3.
		}else{
			return findKth(A, 0, B, 0, len / 2 + 1); //e.g Given A=[1,2,3] and B=[4,5], the median is 3.
		}	
	}
	
	//find kth number of two sorted array
	public static double findKth(int[]A, int A_start, int[] B, int B_start, int k){
		//corner check
		//if A is null
		if (A_start >= A.length){
			return B[B_start + k - 1];
		}
		//if B is null
		if (B_start >= B.length){
			return A[A_start + k - 1];
		}
		//if A is 1
		if (k == 1){
			return Math.min(A[A_start], B[B_start]);
		}
		//if one array is too short
		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
		//compare A_key > B_key，取小的折半递归调用findKth。
		if (A_key < B_key){
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		}else{
			return findKth(A, A_start, B, B_start + k/2, k - k / 2);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6};
		int[] B = {2,3,4,5};
		System.out.println(findMedianOfTwoSortedArray(A,B));

	}

}
