import java.io.*;
import java.util.*;

public class Main {
    
    public static int Island(int arr[][],boolean visi[][]){
        
        int counter=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0  && visi[i][j]==false){
                    island1(arr,i,j,visi);
                    counter++;
                }
            }
        }
        return counter;
        
    }
    
    public static void island1(int arr[][],int i,int j,boolean visi[][]){
        
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || visi[i][j]==true){
            return;
        }
        
        visi[i][j]=true;
        island1(arr,i+1,j,visi);
        island1(arr,i-1,j,visi);
        island1(arr,i,j-1,visi);
        island1(arr,i,j+1,visi);
        
        
    }
    
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      boolean visi[][]=new boolean[m][n];
      
      System.out.println(Island(arr,visi));
   }

}








