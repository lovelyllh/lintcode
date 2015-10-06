package binarySearchAndSortedArray;

/*Rotate String
Given a string and an offset, rotate string by offset. (rotate from left to right)
Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
Challenge
Rotate in-place with O(1) extra memory.
 
*/

public class RotateString {
	public static void roateteString(char[] str, int offset){
		if (str == null || str.length == 0){
			return;
		}
		int size = str.length;	
		offset = offset % size;
		//seperate the string as two part: {0, size - offset -1}, {size - offset, size - 1}
		int left = size - offset - 1;
		int right = size - offset;
		//first reverse the left part
		reverse(str, 0, left);
		//then reverse the right part
		reverse(str, right, size - 1);
		//last, reverse the whole string
		reverse(str, 0, size - 1);
		for (int i = 0; i < str.length; i++){
			System.out.println(str[i]);
		}
	}

	public static void reverse(char[] str, int start, int end){
		int i;
		int j;
		for (i = start, j = end; i < j; i++, j--){
			swap(str, i, j);
		}
		
	}
	
	public static void swap(char[] str, int i, int j){
		char temp;
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;	
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a','b','c','d','e','f','g'};
		int offset = 3;
		roateteString(str, offset);
	}

}
