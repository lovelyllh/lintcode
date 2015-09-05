package binarySearchAndSortedArray;

/*Find Minimum in Rotated Sorted Array II
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
Example
Given [4,4,5,6,7,0,1,2] return 0*/

public class FindMinimumInRotatedSorteArrayII2 {
	public static int findMinimum(int[] nums){
		if (nums == null || nums.length == 0){
			return -1;
		}
		int min = nums[0];
		for (int i = 0 ;i < nums.length; i++){
			if (nums[i] <= min){
				min = nums[i];
			}	
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,4,5,6,7,0,1,2};
		System.out.println(findMinimum(A));
	}

}
