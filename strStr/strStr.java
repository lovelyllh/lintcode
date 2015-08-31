import java.util.Scanner;

/*Example
If source = "source" and target = "target", return -1.
If source = "abcdabcdefg" and target = "bcd", return 1
 * */

public class Solution_for_strStr {
	/**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

	public static int strStr(String source, String target){
		if(source == null || target == null){
			//corner case: null
			return -1;
		}
		int i;
		int j;
		// double loop for scan o(n^2)
		for(i = 0; i < source.length() - target.length()+1; i++){
			for(j = 0; j < target.length(); j++){
				if(source.charAt(i + j) != target.charAt(j)){
					break; 
				}//if
			}//for j
			if(j == target.length()){
				return i;
			}

		}//for i;
		//didn't find the target
		return -1;
	}

	public static void main(String args[]){
		System.out.println("please enter the source string:");
		Scanner src = new Scanner(System.in);
		String source = src.nextLine();
		System.out.println("the source string you entered is: " + source);

		System.out.println("please enter the target string:");
		Scanner tgt = new Scanner(System.in);
		String target = src.nextLine();
		System.out.println("the source string you entered is: " + target);

		int a;

		a = strStr(source, target);

		System.out.println("the index of the first occurence of target in source is:  " + a);
	}
}
