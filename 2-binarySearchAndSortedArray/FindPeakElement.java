package binarySearchAndSortedArray;

/*Find Peak Element
Question: http://www.lintcode.com/en/problem/find-peak-element/
Answer: http://www.jiuzhang.com/solutions/find-peak-element/

There is an integer array which has the following features:
The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:
A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]
Return index 1 (which is number 2) or 6 (which is number 7)
Note
The array may contains multiple peeks, find any of them.
Challenge
Time complexity O(logN)
*/

public class FindPeakElement {
	public static int findPeak(int[]nums){
		if (nums == null || nums.length == 0){
			return -1;
		}
		int start = 1;
		int end = nums.length - 2;
		int mid;
		//The valid peek would be between [1, A.length ¨C 2]. Binary search the peek.
		while (start + 1 < end){
			mid = start + (end - start ) / 2;
			if (nums[mid] < nums[mid-1]){
				end = mid;
			}else if(nums[mid] == nums[mid-1]){
				end = mid;
			}else{
				start = mid;
			}
			
		}
		if (nums[start] > nums[end]){
			return start;
		}else{
			return end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1,3,4,5,7,6};
		System.out.println(findPeak(nums));
	}

}
