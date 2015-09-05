/*Search Insert Position
 * 
 * Question: http://www.lintcode.com/en/problem/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.
Example
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Challenge
O(log(n)) time
Answer:
http://www.jiuzhang.com/solutions/search-insert-position/

time: (O(log(n))
*/

package binarySearchAndSortedArray;

public class SearchInsertPositionBinarySearch {
	
	public static int searchInsertBinary(int[] A, int target){
		if (A == null || A.length == 0){
			return 0;
		}
		//find the last position < target, return +1
		int start = 0;
		int end = A.length -1;
		//binary search, find the last position < target
		while (start < end){
			int mid = (start + start)/2;
			if (A[mid] == target){
				return mid;
			}else if(A[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}//binary search: 就是当循环结束时，如果没有找到目标元素，那么left (start)一定停在恰好比目标大的index上，right (end)一定停在恰好比目标小的index上
		if (target > A[start]){
			return start + 1;
		}else{
			return start;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[] A = {1,3,5,6};
				int target = 5;
				int target2 = 2;
				int target3 = 7;
				int target4 = 0;
				System.out.println(searchInsertBinary(A, target));
				System.out.println(searchInsertBinary(A, target2));
				System.out.println(searchInsertBinary(A, target3));
				System.out.println(searchInsertBinary(A, target4));

	}

}
