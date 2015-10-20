/*Longest Common Substring
question: http://www.lintcode.com/en/problem/longest-common-substring/
answer: http://www.jiuzhang.com/solutions/longest-common-substring/

Given two strings, find the longest common substring.

Return the length of it.

Example
Given A = "ABCD", B = "CBCE", return 2.

Note
The characters in substring should occur continuously in original string. This is different with subsequence.

Challenge
O(n x m) time and memory.
*/

package twoSequenceDP;

public class LongestCommonSubstring {
	public static int longestcommonsubstring(String A, String B){
		if (A == null || A.length() == 0){
			return 0;
		}
		if (B == null || B.length() == 0){
			return 0;
		}
		int n = A.length();
		int m = B.length();
		//1. state: f[i][j] means longest common substring of first ith in A and first jth in B
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		//2. initialization:
		for (int i = 0; i < n + 1; i++){
			dp[i][0] = 0;
		}
		for (int j = 0; j < m + 1; j++){
			dp[0][j] = 0;
		}
		//3. function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < m + 1; j++){
				if (A.charAt(i - 1) == B.charAt(j - 1)){ // dp starts with 1, A and B starts at 0
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				if (dp[i][j] > max){
					max = dp[i][j];
				}
			}
		}
		//4. answer
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ABCD";
		String B = "CDCE";
		System.out.println(longestcommonsubstring(A,B));
	}
}
