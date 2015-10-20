/*Unique Paths II
question: http://www.lintcode.com/en/problem/unique-paths-ii/
answer:  http://www.jiuzhang.com/solutions/unique-paths-ii/

Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note
m and n will be at most 100.
*/

package matrixDP;

public class UniquePathII {
	public int uniquePathwithObstancles(int[][] obstanclegrid){
		if (obstanclegrid == null || obstanclegrid.length == 0 || obstanclegrid[0] == null){
			return 0;
		}//bug1: remember to list obstanclegrid[0]
		int m = obstanclegrid.length;
		int n = obstanclegrid[0].length;
		//1. state: path[i][j] means the count of unique paths from 0,0 to i,j
		int[][] count = new int[m][n];
		//2. initialization: (1)row (2)collum
		for (int i = 0; i < m; i++){
			if (obstanclegrid[i][0] == 1){
				break;
			}else{
				count[i][0] = 1;
			}	
		}
		for (int i = 0; i < n; i++){
			if (obstanclegrid[0][i] == 1){
				break;
			}else{
				count[0][i] = 1;
			}
		}
		//3. function
		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; i++){
				if (obstanclegrid[i][i] == 1){
					count[i][j] = 0;
				}else{
					count[i][j] = count[i - 1][j] + count[i][j-1];	
				}		
			}
		}
		//4.answer
		return count[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstanclegrid = new int[3][3];
		obstanclegrid[0][0] = 0;
		obstanclegrid[0][1] = 0;
		obstanclegrid[0][2] = 0;
		
		obstanclegrid[1][0] = 0;
		obstanclegrid[1][1] = 1;
		obstanclegrid[1][2] = 0;
		
		obstanclegrid[2][0] = 0;
		obstanclegrid[2][1] = 0;
		obstanclegrid[2][2] = 0;
		
		
	}

}
