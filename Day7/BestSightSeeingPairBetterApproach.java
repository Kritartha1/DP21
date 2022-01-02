class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n=values.length;
        
        int maxR=values[values.length-1]-(values.length-1);
        int ans=0;
        for(int j=values.length-2;j>=0;j--){
            maxR=Math.max(maxR,values[j+1]-j-1);
            ans=Math.max(maxR+values[j]+j,ans);
            
        }
        return ans;
        
        
        
    }
}
