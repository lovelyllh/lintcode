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
//optimization: use three variable sf
public class ClimbingStairs2 {
	public static int climbingstairs(int m){
		if (m <= 1){
			return m;
		}
		int last = 1;
		int lastlast = 1;
		int now = 0;
		for (int i = 2; i < m + 1; i++){
			now = last + lastlast;
			lastlast = last;
			last = now;
		}
		return now;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		System.out.println(climbingstairs(m));

	}

}
