/*Longest Common Subsequence
question: http://www.lintcode.com/en/problem/longest-common-subsequence/
answer:  http://www.jiuzhang.com/solutions/longest-common-subsequence/

Given two strings, find the longest common subsequence (LCS).
Your code should return the length of LCS.

Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
For "ABCD" and "EACB", the LCS is "AC", return 2.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
*/
package twoSequenceDP;

public class LongestCommonSubsequnce {
	public static int longestCommonSubsequence(String A, String B){
		if (A == null || A.length() == 0){
			return 0;
		}
		if (B == null || B.length() == 0){
			return 0;
		}
		int n = A.length();
		int m = B.length();
		//1. state: sum[i][j] means the number of the common sub-strings of first i in A and first j in B
		int[][] sum = new int[n + 1][m + 1];
		//2. initializaion
		for (int i = 0; i < n + 1; i++){
			sum[i][0] = 0;
		}
		for (int j = 0; j < m + 1; j++){
			sum[0][j] = 0;
		}
		//3. function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < m + 1; j++){
				if (A.charAt(i - 1) != B.charAt(j - 1)){//index starts at 0
					//can't match, pick the previous larger one
					sum[i][j] = Math.max(sum[i - 1][j], sum[i][j - 1]);
				}else{
					//match: just add 1
					sum[i][j] = sum[i - 1][j - 1] + 1;
				}
			}
		}
		//4. answer
		return sum[n][m];			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "bedaacbade";
		String B = "dccaeedbeb";
		String C = "EACB";
		System.out.println(longestCommonSubsequence(A,B));
		System.out.println(longestCommonSubsequence(A,C));

	}

}
