package binarySearchAndSortedArray;

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
time complexity of this algorithm: O(logn + logm)
*/

public class Search2DMatrix2 {
	//binary search twice
	public static boolean searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0){
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0){
			return false;
		}
		int row = matrix.length;
		int collum = matrix[0].length;
		//binary search 1, find the row index, the last number <= target
		int start = 0;
		int end = row - 1;
		int mid;
		int number;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			//row and collum both are not found, so we use matrix[mid][0]
			if (matrix[mid][0] == target){
				return true;
			}else if (matrix[mid][0] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (matrix[start][0] <= target){
			row = start; 
		}else if (matrix[end][0] <= target){
			row = end;
		}else{
			return false;
		}
		
		//find the index of the collum, which has the number equal to target
		start = 0;
		end = collum - 1;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			 //row number is ound, so we use matrix[row][mid]
			if (matrix[row][mid] == target){
				return true;
			}else if (matrix[row][mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (matrix[row][start] == target){
			return true;
		}else if (matrix[row][end] == target){
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
