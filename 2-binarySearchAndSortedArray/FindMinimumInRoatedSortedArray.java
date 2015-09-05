package binarySearchAndSortedArray;

/*Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
Example
Given [4, 5, 6, 7, 0, 1, 2] return 0
Note
You may assume no duplicate exists in the array.
*/

public class FindMinimumInRoatedSortedArray {
	public static int findMinimum(int[] nums){
		if (nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			//{4,5,6,7,0,1,2}, if nums[mid] >= nums[end]=> the left part is ascending, the 
			if (nums[mid] >= nums[end]){
				start = mid;		
			}else{//if nums[mid] < nums[end]=> the right part is ascending, the smallest number is in the left part
				//{6.7.0.1.2.4}
				end = mid;
			}
		}
		if (nums[end] < nums[start]){
			return nums[end];
		}else{
			return nums[start];
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(findMinimum(nums));
	}

}
