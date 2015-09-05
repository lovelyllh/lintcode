package binarySearchAndSortedArray;

/*Find Minimum in Rotated Sorted Array II
QUESTION: http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array-ii/
ANSWER: http://www.jiuzhang.com/solutions/find-minimum-in-rotated-sorted-array-ii/

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
Example
Given [4,4,5,6,7,0,1,2] return 0*/

public class FindMinimumInRotatedSortedArrayII {
	public static int findMinimum(int[] nums){
		if (nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]){//the left part is ascending
				start = mid;
			}else if (nums[mid] < nums[end]){
				end = mid;
			}else{
				end--;
			}
		}
		if (nums[start] < nums[end]){
			return nums[start];
		}else{
			return nums[end];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,4,5,6,7,0,1,2};
		System.out.println(findMinimum(A));

	}

}
