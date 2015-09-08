package binarySearchAndSortedArray;
/*Reverse Words in a String
question: http://www.lintcode.com/en/problem/reverse-words-in-a-string/
answer: http://www.jiuzhang.com/solutions/reverse-words-in-a-string/

Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".

Example
Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word.

Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.

How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

public class ReverseWordsInaString {
	public static String reverseWord(String str){
		if (str == null || str.length() == 0){
			return ""; //why not null?
		}
		//use split function to create a string array
		String[] array = str.split(" ");
		StringBuilder sb = new StringBuilder();
		//add the string array element to stringbuilder descendently.
		for (int i = array.length - 1; i >= 0; i--){
			if(!array[i].equals("")){ //why not " "?
				sb.append(array[i]).append(" ");
			}		
		}
		//remove the last space
		if (sb.length() == 0){
			return "";
		}else{
			sb.substring(0, sb.length() - 1);
		}	
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  the sky is  blue  ";
		System.out.println(reverseWord(s));
	}
}
