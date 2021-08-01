/*
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1


23


*/



import java.io.*;
import java.util.*;

public class Main {
    public static int ansM(int arr[][], int x, int y,int dp[][]) {

		if (arr.length - 1 == x && arr[0].length - 1 == y) {
			return dp[x][y]=arr[x][y];
		}

		if (dp[x][y] != 0) {
			return dp[x][y];
		}

		int minCost = (int) 10e9;
		
			if (y + 1 < arr[0].length) {
			minCost = Integer.min(minCost, ansM(arr, x, y + 1, dp));
		}

		if (x + 1 < arr.length) {
			minCost = Integer.min(minCost, ansM(arr, x + 1, y, dp));

		}
	

		return dp[x][y] = minCost + arr[x][y];
	 

	}
    
    

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int dp[][] = new int[m][n];
        System.out.println(ansM(arr,0,0,dp));
      
    }

}
