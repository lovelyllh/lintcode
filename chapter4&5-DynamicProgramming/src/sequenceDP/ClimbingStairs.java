/*Climbing Stairs
question: http://www.lintcode.com/en/problem/climbing-stairs/
answer:  http://www.jiuzhang.com/solutions/climbing-stairs/

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example
Given an example n=3 , 1+1+1=2+1=1+2=3
return 3
*/
package sequenceDP;

public class ClimbingStairs {
	public static int climbingStairs(int m){
		if (m < 1){
            return 0;
        }
		//1. state: count[i] means distinct ways from stair 0 to stair i 
		int[] count = new int[m + 1];
		//2. initialization
		count[0] = 1;
		count[1] = 1;
		//3. function
		for (int i = 2; i < m+1; i++){
			count[i] = count[i - 1] + count[i - 2];
		}
		//4. answer
		return count[m]; //the last element index is m
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		System.out.println(climbingStairs(m));
	}

}
