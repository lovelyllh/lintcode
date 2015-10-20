/*Palindrome Partitioning II
question: http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
answer: http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/

Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example
For example, given s = "aab",

Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
package sequenceDP;

public class PalindromePartitioningII {
	public static int minicut(String s){
		if (s == null || s.length() == 0){
			return 0; //null is also a palindrome
		}
		//1. state: mincut[i] means the minimum number of string from 0 to i
		int[] mincut = new int[s.length() + 1];
		//2. initialization
		mincut[0] = 0;
		//3. function
		for (int i = 1; i < s.length() + 1; i++){
			//worst case
			mincut[i] = Integer.MAX_VALUE;
			//j is the length of last word
			for (int j = 1; j <= i; j++){
				String word = s.substring(i - j, i);
				if (isPalindrome(word)){//i-j to i is a palindrome
					mincut[i] = Math.min(mincut[i - j] + 1, mincut[i]);
				}
			}
		}//注意最后返回mincut[s.length()]-1. mincutc[i]代表了第i-1位最少的palindrome个数，cut数= 个数-1.
		//4. answer
		return mincut[s.length()] - 1;
		
	}

	private static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		if (s == null || s.length() == 0){
			return false;
		}
		int n = s.length();
		for (int i = 0, j = n - 1; i < j; i++, j--){
			if (s.charAt(i) != s.charAt(j)){
				return false;
			}
		}	
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println(minicut(s));
	}
}
