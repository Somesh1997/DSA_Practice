import java.io.*;
import java.util.*;

public class Main {
    
    
    public static class Edge{
        int sr;
        int dt;
        Edge(int sr,int dt){
            this.sr=sr;
            this.dt=dt;
        }
    }
       public static void check(ArrayList<Edge> graph[],int src,boolean vh[],ArrayList<Integer> list){
       
       vh[src]=true;
       list.add(src);
       
       for(Edge e:graph[src]){
           if(vh[e.dt]==false)
           check(graph,e.dt,vh,list);
       }
       
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      
      ArrayList<Edge> graph[]=new ArrayList[n];
      
      for(int v=0;v<n;v++)
      {
          graph[v]=new ArrayList<Edge>();
      }
      
     for(int i=0;i<k;i++)
     {
         String str=br.readLine();
         int sr=Integer.parseInt(str.split(" ")[0]);
         int dt=Integer.parseInt(str.split(" ")[1]);
         Edge e1=new Edge(sr,dt);
         Edge e2=new Edge(dt,sr);
         graph[sr].add(e1);
         graph[dt].add(e2);
         
     }
          ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      

     // System.out.println(comps);
      boolean vh[]=new boolean[n];
      for(int i=0;i<n;i++)
      {
          if(vh[i]==false){
              ArrayList<Integer> list=new ArrayList<Integer>();
              check(graph,i,vh,list);
              comps.add(list);
          }
      }
      
      int pf=0;
      for(int i=0;i<comps.size();i++)
      {
          for(int j=i+1;j<comps.size();j++)
          {
              int count=comps.get(i).size()*comps.get(j).size();
              pf+=count;
          }
      }
    System.out.println(pf);
     
      
      
      
      
      
   }

}
