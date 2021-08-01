import java.io.*;
import java.util.*;

public class Main{
    
    
    public static int fibR(int n){
        if(n==0 || n==1){
            return n;
        }
        
        int fib1=fibR(n-1);
        int fib2=fibR(n-2);
        
        return fib1+fib2;
    }
   public static int fibDP(int n,int dp[]){
        if(n==0 || n==1){
            dp[n]=n;
            return dp[n];
        }
        if(dp[n]!=0){
            return dp[n];
        }
        
        int fib1=fibDP(n-1,dp);
        int fib2=fibDP(n-2,dp);
        
        int fibn=fib1+fib2;
        dp[n]=fibn;
        return dp[n];
    }

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    int dp[]=new int[n+1];
    System.out.println(fibDP(n,dp));
 }

}
