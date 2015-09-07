package binarySearchAndSortedArray;

/*search 2D Matrix II
question: http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/
answer:
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.
Example
Consider the following matrix:
[
    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]
]
Given target = 3, return 2.
Challenge
O(m+n) time and O(1) extra space

*/
public class Search2DMatrixII {
	public static int searchMatrix(int[][] matrix, int target){
		int ocurrence = 0;
		if (matrix == null || matrix.length == 0){
			return ocurrence;
		}
		if (matrix[0] == null || matrix[0].length == 0){
			return ocurrence;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		int collum = n - 1;
		int current;
		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]){
			return 0;
		}
		//from top right, search the diagonal
		while (row >= 0 && row < m && collum >=0 && collum < n){
			current = matrix[row][collum];
			if (current == target){
				ocurrence++;
				collum--;
				row++;
			}else if (current < target){
				row++;
			}else{
				collum--;
			}
		}		
		return ocurrence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3,5,7}, {2,4,7,8},{3,5,9,10}};
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}

}
