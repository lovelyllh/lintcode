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

//version3: top-down
public class Triangle3 {
	public static int minpathsum(int[][] triangle){
		if (triangle == null || triangle.length == 0){
			return -1;
		}
		if (triangle[0] == null || triangle[0].length == 0){
			return -1;
		}
		//1. state: minsum[x][y] means minimum path sum from 0,0 to x,y
		int n = triangle.length;
		int[][] minsum = new int[n][n];
		//2. initialization: (1) 0,0 (2) row (3) collum
		minsum[0][0] = triangle[0][0];
		for (int i = 1; i < n; i++){
			//需要考虑最左边和最右边的边界
			minsum[i][0] = minsum[i - 1][0] + triangle[i][0]; //left
			minsum[i][i] = minsum[i - 1][i - 1] + triangle[i][i];//right
		}
		//3. function: topdown
		for (int i = 1; i < n; i++){
			for (int j = 1; j < i; j++){ //not j <= i , because we already initilized minsum[i][0] and minsum[i][i] 
				minsum[i][j] = Math.min(minsum[i - 1][j], minsum[i - 1][j - 1]) + triangle[i][j];	
			}	
		}
		//4. answer:
		int best = minsum[n - 1][0];
		for (int i = 1; i < n; i++){
			//we have n - 1 answer on the last level, so we need to compare again
			best = Math.min(minsum[n - 1][i], best);
		}
		return best;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]*/
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
		System.out.println(minpathsum(triangle));
	}
}
