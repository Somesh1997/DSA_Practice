import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
    public static class DPair implements Comparable<DPair>{
       int wsf;
       int vtx;
       String psf;
       DPair(int vtx,String psf,int wsf){
           this.vtx=vtx;
           this.wsf=wsf;
           this.psf=psf;
       }
       
       public int compareTo(DPair dp){
           return this.wsf-dp.wsf;
       }
       
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      
      PriorityQueue<DPair> q=new PriorityQueue<>();
      
      q.add(new DPair(src,""+src,0));
      
      boolean visi[]=new boolean[vtces];
      
      while(q.size()>0){
          
          DPair dp=q.poll();
          
          if(visi[dp.vtx]==true){
              continue;
          }
         
              visi[dp.vtx]=true;
              System.out.println(dp.vtx+" via "+dp.psf+" @ "+dp.wsf);
              for(Edge e:graph[dp.vtx]){
                  if(visi[e.nbr]==false)
                  q.add(new DPair(e.nbr,dp.psf+e.nbr,dp.wsf+e.wt));
              }
          
          
          
          
      }
      
      
      
   }
}
