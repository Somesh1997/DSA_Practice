class Solution {
    public int findCenter(int[][] trust) {
         ArrayList<ArrayList<Integer>> s=new ArrayList<>();
       
      for(int i=0;i<=trust.length+1;i++){
            s.add(new ArrayList<>());
        }
        for(int  i=0;i<trust.length;i++){
            int a=trust[i][0];
            int b=trust[i][1];
            s.get(a).add(b);
            s.get(b).add(a);
           
          
        }
        
       for(int i=0;i<s.size();i++)
       {
         if(s.get(i).size()==trust.length){
           return i;
         }
       }
      return -1;
    }
}

/*
    
    O(1) Solution
public int findCenter(int[][] e) {
    return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
}
  */
