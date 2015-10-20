/*Minimum Path Sum
question: http://www.lintcode.com/en/problem/minimum-path-sum/
answer:  http://www.jiuzhang.com/solutions/minimum-path-sum/

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom 
right which minimizes the sum of all numbers along its path.

Have you met this question in a real interview? Yes
Example
Note
You can only move either down or right at any point in time.
*/
package matrixDP;

public class MinimumPathSum {
	public static int minimumPathsum(int[][] grid){
		if (grid == null || grid.length == 0 || grid[0].length == 0){
			return -1;
		}
		int m = grid.length;
		int n = grid[0].length;
		//1. state: path[i][j] means the minimum path sum from 0,0 to i,j
		int[][] path = new int[m][n];
		path[0][0] = grid[0][0]; 
		//2. initializationn: (1) row (2) collum
		for (int i = 1; i < m; i++){
			path[i][0] = grid[i][0] + path[i - 1][0];
		}
		for (int i = 1; i < n; i++){
			path[0][i] = grid[0][i] + path[0][i - 1];
		}
		//3. function
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
			}
		}
		//4. answer
		return path[m - 1][n - 1];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[3][5];
		System.out.println(minimumPathsum(grid));

	}

}
