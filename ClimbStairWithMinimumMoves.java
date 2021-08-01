/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of 
     staircase.
Note -> If there is no path through the staircase print null.
10
3
3
0
2
1
2
4
2
0
0

O/P
4

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
         Scanner sc=new Scanner(System.in);
        
        int size=sc.nextInt();
        
        int arr[]=new int[size];
        
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        
        int dp[]=new int[size];
        
        dp[size-1]=0;
        
        for(int i=size-2;i>=0;i--){
            int data=arr[i];
            
           
                int min=(int)1e9;
                for(int j=1;j<=arr[i] && j+i<=size-1;j++){
                    min=Math.min(min,dp[i+j]);
                }
                 dp[i]=min+1;
                 
                 if(min==1e9){
                     dp[i]=(int)1e9;
                 }
                 else{
                     dp[i]=min+1;
                 }
            
           
            
            
           
          
        }
        System.out.println(dp[0]);
        
    }

}
