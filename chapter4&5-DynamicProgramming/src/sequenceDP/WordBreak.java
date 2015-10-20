/*Word Break
question: http://www.lintcode.com/en/problem/word-break/
answer:  http://www.jiuzhang.com/solutions/word-break/

Given a string s and a dictionary of words dict, determine if s can be break into a s
pace-separated sequence of one or more dictionary words.

Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".
*/
package sequenceDP;

import java.util.Set;
import java.util.TreeSet;

public class WordBreak {
	public static boolean canbreak(String s, Set<String> dic){
		if (s == null ||s.length() == 0){
			return true;//why true??
		}
		if (dic.size() == 0 || dic == null){
			return false;
		}
		int maxLength = getMaxlength(dic);
		//1. state: canSegment[i] means if we can break the first i chars from dic
		boolean[] canSegment = new boolean[s.length() + 1];//why not s.length()?
		//2. initialization
		canSegment[0] = true;
		//in order to kown if the first s.length() char can be cut or not
		//3. function
		for (int i = 1; i < s.length() + 1; i++){
			//initialization
			canSegment[i] = false;
			//j means the the last word length
			for (int j = 1; j <= maxLength && j <= i; j++){
				//dp[i - j] means first i-j chars can be cut
				//dic.contains wants to know the second part
				String word = s.substring(i - j, i);
				//substring : [startindex, endindex) startindex is inclusive, endindex is exclusive
				if (canSegment[i - j] && dic.contains(word)){//canSegment[i - j] not canSegment[j]
					canSegment[i] = true;
					break;
				}
			}
		}
		//4. answer
		return canSegment[s.length()];
		
	}
	//optimize
	private static int getMaxlength(Set<String> dic) {
		// TODO Auto-generated method stub
		int maxLength = 0;
		//get the max length of dic
		for (String word: dic){
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Lintcode";
		Set dic = new TreeSet();
		dic.add("Lint");
		dic.add("code");
		System.out.println(canbreak(s, dic));
	}
}
