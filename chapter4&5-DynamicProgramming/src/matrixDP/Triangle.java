/*triangle
question: http://www.lintcode.com/en/problem/triangle/
answer: http://www.jiuzhang.com/solutions/triangle/

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to 
adjacent numbers on the row below.

Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/
package matrixDP;

import java.util.ArrayList;
//version1: bottom-up
public class Triangle {
	public static int minimumTotal(int[][] triangle){
		if (triangle == null || triangle.length == 0){
			return -1;
		}
		if (triangle[0] == null || triangle[0].length == 0){
			return -1;
		}
		int n = triangle.length;
		//1. state: minsum[i][j] means the minimum path sum from i,j to 0,0
		int[][] minsum = new int[n][n];
		//2. initialization : the last row
		for (int i = 0; i < n; i++){
			minsum[n - 1][i] = triangle[n - 1][i];
		}
		//3. functioin: bottom-up
		for (int i = n - 2; i >= 0; i--){
			for (int j = 0; j <= i; j++){
				minsum[i][j] = Math.min(minsum[i + 1][j], minsum[i + 1][j + 1]) + triangle[i][j];
			}
		}
		//4. answer:
		return minsum[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = new int[4][4];
		triangle[0][0] = 2;
		triangle[1][0]= 3;
		triangle[1][1]= 4;
		triangle[2][0]= 6;
		triangle[2][1]= 5;
		triangle[2][2]= 7;
		triangle[3][0]= 4;
		triangle[3][1]= 1;
		triangle[3][2]= 8;
		triangle[3][3]= 3;
		System.out.println(minimumTotal(triangle));
	}

}
