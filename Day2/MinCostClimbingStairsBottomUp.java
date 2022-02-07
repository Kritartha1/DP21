class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length+1];
        int n=cost.length;
        
        for(int i=0;i<=n;i++){
            if(i<2){
                dp[i]=0;
            }
            else{
                dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
            }
        }
        return dp[n];
        
        
    }
   
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    //O(1) space
    //O(n) time complexity
    public int minCostClimbingStairs(int[] cost) {
        
        int a=0;
        int b=0;
        int n=cost.length;
        
        for(int i=2;i<=n;i++){
            int temp=Math.min(b+cost[i-1],a+cost[i-2]);
            a=b;
            b=temp;
        }
        return b;
    
        
    }
   
}
