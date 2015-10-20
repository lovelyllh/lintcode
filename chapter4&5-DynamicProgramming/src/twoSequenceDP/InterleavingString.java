/*Interleaving String
question:http://www.lintcode.com/en/problem/interleaving-string/
answer:  http://www.jiuzhang.com/solutions/interleaving-string/

Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
Challenge
O(n2) time or better
*/
package twoSequenceDP;

public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3){
		if (s1.length() + s2.length() != s3.length()){
			return false;
		}
		int n = s1.length();
		int m = s2.length();
		//1.state:boolean[i][j] means if the first (i + j) of s3 can be formed by the first i 
		//of s1 and the first j of s2
		boolean[][] interleaved = new boolean[n + 1][m + 1];
		//2. initialization
		interleaved[0][0] = true;
		for (int i = 1; i < n + 1; i++){
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && interleaved[i - 1][0]){
				interleaved[i][0] = true ;
			}		
		}
		for (int j = 1; j < m + 1; j++){
			if (s2.charAt(j - 1) == s3.charAt(j - 1) && interleaved[0][j - 1]){
				interleaved[0][j] = true;
			}
		}
		//3. function
		for (int i = 1; i < n + 1; i++){
			for (int j = 1; j < m + 1; j++){
				//the default of boolean is false;
				boolean case1 = false;
				boolean case2 = false;
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]){
					case1 = true;				
				}
				if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleaved[i][j - 1]){
					case1 = true;				
				}
				interleaved[i][j] = case1 || case2;
			}
		}	
		//4. answer
		return interleaved[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
		System.out.println(isInterleave(s1, s2, s4));
	}
}
