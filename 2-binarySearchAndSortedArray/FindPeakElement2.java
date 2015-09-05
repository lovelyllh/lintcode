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
Time complexity O(N)
*/
public class FindPeakElement2 {
	//o(n)
	public static int findPeak2(int[] nums){
		if (nums == null || nums.length == 0){
			return -1;
		}
		if (nums.length == 1){
			return 0;
		}
		for (int i = 1; i < nums.length -2; i++){
			if (nums[i] > nums[i-1] && nums[i] > nums[i + 1]){
				return i;
			}		
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,1,3,4,5,7,6};
		System.out.println(findPeak2(nums));
	}

}
