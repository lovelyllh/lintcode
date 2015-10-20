/*Unique Paths
question: http://www.lintcode.com/en/problem/unique-paths/
answer:http://www.jiuzhang.com/solutions/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to 
reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Example
1,1		1,2		1,3		1,4		1,5		1,6		1,7		
2,1
3,1												3,7
How many possible unique paths are there?
Above is a 3 x 7 grid. How many possible unique paths are there?

Note
m and n will be at most 100.
*/


package matrixDP;

public class UniquePath {
	public static int uniquePath(int m, int n){
		if (m == 0 || n == 0){
			return 0;
		}
		//1. state: count[i][j] means the count of unique paths from 0,0 to i,j
		int[][] count = new int[m][n];
		//2. initialization: (1) row (2) collum
		for (int i = 0; i < m; i++){
			count[i][0] = 1;
		}
		for (int i = 0; i < n; i++){
			count[0][i] = 1;
		}
		//3. function
		for (int i = 1; i < m; i++){//bug1: i = 1 not i = 0
			for (int j = 1; j < n; j++){
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			}
		}
		//4. answer
		return count[m - 1][n - 1]; // the last element index is m-1, n-1
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 10;
		System.out.println(uniquePath(m, n));

	}

}
