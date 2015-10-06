/*Wood Cut
question: http://www.lintcode.com/en/problem/wood-cut/

answer:  http://www.jiuzhang.com/solutions/wood-cut/

Given n pieces of wood with length L[i] (integer array). Cut them into small 
pieces to guarantee you could have equal or more than k pieces with the same
length. What is the longest length you can get from the n pieces of wood? 
Given L & k, return the maximum length of the small pieces.

Example
For L=[232, 124, 456], k=7, return 114.

Note
You couldn't cut wood into float length.

Challenge
O(n log Len), where Len is the longest length of the wood.
*/
package binarySearchAndSortedArray;

public class WoodCut {
	public static int woodCut(int[] L, int k){
		if (L == null || L.length == 0 || k < 0){
			return 0;
		}
		int max = 0;
		for (int i = 0; i < L.length; i++){
			max = Math.max(max, L[i]);
		}
		//find the largest length that can cut more than k pieces of wood
		int start = 1;
		int end = max;
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			if (count(L, mid) >= k){
				start = mid; //mid sould be bigger so that count(L, mid) == k
			}else{
				end = mid;
			}
		}
		if (count(L, start) >= k){
			return start;
		}else if (count(L, end) >= k){
			return end;
		}else{
			return 0;
		}
	}
	
	public static int count(int[] L, int length){
		int sum = 0;
		for (int i = 0; i < L.length; i++){
			sum += L[i] / length;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] L = {232, 124, 456};
		int k = 7;
		System.out.println(woodCut(L, k));

	}

}
