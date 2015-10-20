/*Distinct Subsequences
question: http://www.lintcode.com/en/problem/distinct-subsequences/
answer: http://www.jiuzhang.com/solutions/distinct-subsequences/

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting 
some (can be none) of the characters without disturbing the relative positions of the remaining 
characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
Given S = "rabbbit", T = "rabbit", return 3.

Challenge
Do it in O(n2) time and O(n) memory.

O(n2) memory is also acceptable if you do not know how to optimize memory.
*/
package twoSequenceDP;

public class DistinctSubsequences {
	public static int distinctsubsequence(String A, String B){
		if (A == null || A.length() == 0 || B == null || B.length() > A.length()){
			return 0;
		}
		int n = A.length();
		int m = B.length();
		//1. state: dp[i][j] means the number of distinct subsequence of  first j of B in first i of A 
		int[][] dp = new int[n + 1][m + 1];
		//2.initialization:
		for (int i = 0; i < n + 1; i++){
			dp[i][0] = 1;
		}
		for (int j = 1; j < m + 1; j++){
			dp[0][j] = 0;
		}
		//3. function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < m + 1; j++){
				//first get j forward, get the answer
				if (A.charAt(i - 1) == B.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}else{
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "rabbbit";
		String B = "rabbit";
		System.out.println(distinctsubsequence(A,B));

	}

}
