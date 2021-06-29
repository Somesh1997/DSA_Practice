package dp;

import java.util.Scanner;

public class Climb {

	public Climb() {
		// TODO Auto-generated constructor stub
	}

	public static int climbStairRe(int n) {
		if (n == 0) {
			return 1;

		}
		int count = 0;
		for (int i = 1; i <= 3; i++) {
			if (n - i >= 0) {
				count = count + climbStair(n - i);
			}
		}
		return count;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(climbStairRe(sc.nextInt()));
	}

}
