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
   
   public static boolean checkConnectd(ArrayList<Edge>[] graph,boolean p[]){
       
       p[0]=true;
       
       checkGraph(graph,0,p);
       
       for(int i=0;i<p.length;i++){
           if(p[i]==false){
               return false;
           }
       }
       
       
       return true;
       
   }
   
   public static void checkGraph(ArrayList<Edge>[] graph,int src,boolean p[]){
       
       p[src]=true;
       for(Edge e: graph[src]){
           if(p[e.nbr]==false){
               checkGraph(graph,e.nbr,p);
           }
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
      boolean p[]=new boolean[vtces];
     System.out.println(checkConnectd(graph,p));
     
   }
}
