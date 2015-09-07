package binarySearchAndSortedArray;

import java.util.ArrayList;

/*search 2d matrix

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example
Consider the following matrix:
[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.
Challenge
O(log(n) + log(m)) time
time complexity of this algorithm: O(logn+ logm)

*/
public class Search2DMatrix {
	//binary search once, recommend this method
	public static boolean searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0){
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0){
			return false;
		}
		int row = matrix.length; //row length
		int collum = matrix[0].length; //collum length
		int start = 0;
		int end = row * collum - 1;
		int mid;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			int number = matrix[mid / collum][mid % collum]; 
			if (number == target){
				return true;
			}else if (number < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (matrix[start / collum][start % collum] == target){
			return true;
		}else if (matrix[end / collum][end % collum] == target){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 5;
		System.out.println(searchMatrix(matrix, target));

	}

}
