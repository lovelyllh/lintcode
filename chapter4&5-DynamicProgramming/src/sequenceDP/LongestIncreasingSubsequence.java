/*Longest Increasing Subsequence
question: http://www.lintcode.com/en/problem/longest-increasing-subsequence/
answer:  http://www.jiuzhang.com/solutions/longest-increasing-subsequence/

Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?

    * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.  

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
*/
package sequenceDP;

public class LongestIncreasingSubsequence {
	public static int longestincreasingsub(int[] nums){
		if (nums == null || nums.length == 0){
			return 0;
		}
		int n = nums.length;
		//1. state: maxlength[i] means the longest increasing subsequence ends with i.
		int[] maxlength = new int[n];	
		//2. initialization
		int max = 0;
		//3. function
		for (int i = 0; i < n; i++){
			//initilazation, worst case, maxlength is 1
			maxlength[i] = 1;
			//j is the previous element
			for (int j = 0; j < i; j++){
				if (nums[j] <= nums[i]){
					maxlength[i] = Math.max(maxlength[j] + 1, maxlength[i]);
				}
			}
			//important, maxlength[i] means the max length of the sequence ends with i, but we
			//need the max length of the whole array.
			if (maxlength[i] > max){
				max = maxlength[i];
			}
		}
		//4. answer
		return max;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,1,2,3};
		int[] nums1 = {4,2,4,5,3,7};
		System.out.println(longestincreasingsub(nums));
		//System.out.println(longestincreasingsub(nums1));
	}
}
