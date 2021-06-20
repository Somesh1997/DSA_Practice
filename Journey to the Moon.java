import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
     
     public static class Edge{
         int sr;
         int dt;
         public Edge(int sr,int dt){
             this.sr=sr;
             this.dt=dt;
         }
     }
    
    public static void getConnected(ArrayList<Edge> graph[],int src,ArrayList<Integer> list,boolean vtces[]){
        
        vtces[src]=true;       
        list.add(src);
        for(Edge e: graph[src]){
            if(vtces[e.dt]==false){
                getConnected(graph,e.dt,list,vtces);
            }
        }
        
    }

    public static int journeyToMoon(int n, List<List<Integer>> graph) {
    // Write your code here
    ArrayList<Edge> g[]=new ArrayList[n]; 
    
    for(int i=0;i<n;i++){
        g[i]=new ArrayList<Edge>();
    }
    for(int i=0;i<graph.size();i++)
    {
        int sr=graph.get(i).get(0);
        int dt=graph.get(i).get(1);
        
        Edge e1=new Edge(sr,dt);
        Edge e2=new Edge(dt,sr);
        g[sr].add(e1);
        g[dt].add(e2);
        
    }
    boolean arr[]=new boolean[n];
    ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
    
    for(int i=0;i<n;i++)
    {
        if(arr[i]==false){
        ArrayList<Integer> comp=new ArrayList<Integer>();
        getConnected(g,i,comp,arr);
        comps.add(comp);
       
        }
    }
    System.out.println(comps);
    
    int sum=0;
    
    for(int i=0;i<comps.size();i++)
    {
        for(int j=i+1;j<comps.size();j++){
            sum=sum+comps.get(i).size()*comps.get(j).size();
        }
    }
    
       
return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
