import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner sc=new Scanner(System.in);
        
        int k=sc.nextInt();
        
        int arr[]=new int[k+1];
        
        
        for(int i=0;i<=k;i++){
            if(i-3>=0){
                arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
            }
            else if(i-2>=0){
                arr[i]=arr[i-1]+arr[i-2];
            }
            else if(i-1>=0){
                arr[i]=arr[i-1];
            }
            else{
                arr[i]=1;
            }
        }
        System.out.println(arr[k]);
        
        
    }

}
