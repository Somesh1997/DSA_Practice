class Pair{
  int x;
  int y;
  int wt;
  Pair(int x,int y,int wt){
    this.x=x;
    this.y=y;
    this.wt=wt;
  }
}
class Solution {
    public int orangesRotting(int[][] grid) {
      Queue<Pair> q=new LinkedList<>();
      int max=0;
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
          if(grid[i][j]==2){
            q.add(new Pair(i,j,0));
          }
        }
      }
     
      
      int arr[][]={{1,0},{-1,0},{0,1},{0,-1}};
      int ans=0;
      int last=0;
      while(q.size()>0){
        
        Pair p=q.poll();
        int l=p.wt;
        last=p.wt;
        for(int i=0;i<arr.length;i++){
          int x1=p.x+arr[i][0];
          int y1=p.y+arr[i][1];
          
          if(x1>=0 && y1>=0 && x1 <grid.length&& y1<grid[0].length && grid[x1][y1]==1){
            grid[x1][y1]=2;
            q.add(new Pair(x1,y1,l+1));
          }
          
        }
      }
      boolean p=true;
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
          if(grid[i][j]==1){
            last=-1;
            p=false;
            break;
          }
        }
      }
      if(last==-1 && q.size()>0)
      {
        return -1;
      }
      
      
        return last;
    }
}
