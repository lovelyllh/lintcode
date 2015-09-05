/*Search Insert Position
 * 
 * Question: http://www.lintcode.com/en/problem/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.
Example
[1,3,5,6], 5 �� 2
[1,3,5,6], 2 �� 1
[1,3,5,6], 7 �� 4
[1,3,5,6], 0 �� 0

Challenge
O(log(n)) time
Answer:
http://www.jiuzhang.com/solutions/search-insert-position/
*/
package binarySearchAndSortedArray;

public class SearchInsertPosition {
	
	public static int searchInSert(int[] A, int target){
		if (A == null || A.length == 0){
			return 0;
		}
		int index = -1;
		for (int i = 0; i < A.length; i++){
			if (A[i] != target){
				if (A[i] < target){
					continue;
				}
				index = i;
				break;
			}
			if (A[i] == target){
				index = i;
				break;
			}
		}
		if (A[A.length - 1] < target){
			index = A.length;
		}
		return index;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,6};
		int target = 5;
		int target2 = 2;
		int target3 = 7;
		int target4 = 0;
		System.out.println(searchInSert(A, target));
		System.out.println(searchInSert(A, target2));
		System.out.println(searchInSert(A, target3));
		System.out.println(searchInSert(A, target4));
	}

}
