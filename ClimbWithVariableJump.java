package dp;

import java.util.Scanner;

public class ClimbWithVariableJump {

	public static int varJump(int inp[], int n) {

		int dp[] = new int[n + 1];

		for (int i = n; i >= 0; i--) {
			if (i == n) {
				dp[i] = 1;
				continue;
			}
			int c = 0;
			for (int j = 1; j <= inp[i] && j + i <= n; j++) {

				c += dp[j + i];

			}
			dp[i] = c;
		}

		return dp[0];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int dp[] = new int[size];

		// System.out.println(climbStairDP(size, dp));
		for (int i = 0; i < size; i++) {
			dp[i] = sc.nextInt();
		}
		System.out.println(varJump(dp, size));
	}

}
