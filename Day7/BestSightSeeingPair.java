class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int[] maxL=new int[n];
        
        maxL[0]=0;
        for(int i=0;i<n-1;i++){
            maxL[i+1]=Math.max(maxL[i],values[i]+i);
        }
      //maxL[i] contains the previous max of the 0to (i-1) elements of values[k]+k terms
        int maxR=values[n-1]-(n-1);
        int ans=0;
        for(int j=n-1;j>0;j--){
            maxR=Math.max(maxR,values[j]-j);
          //at j th index maxR contains max(values[j]-j) from index(j to (n-1))
          //and maxL[j]=max(from 0 to (j-1) elements of the values[k]+k terms, where k belongs to (0 to (j-1))
          //since i<j given..
          //so at idx j, ans ={max(values[k]+k) of elements form 0 to j-1}+{max(values[k]-k) of elements from j to n-1}
            ans=Math.max(maxR+maxL[j],ans);
            
        }
        return ans;
        
        
        
    }
}
