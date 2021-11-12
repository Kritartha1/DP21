class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length+1];
        int n=cost.length;
        return Math.min(minCost(n-1,cost),minCost(n-2,cost));
        
    }
    //n is index postn
    public int minCost(int n,int[] cost){
        if(n<=1){
            return cost[n];
        }
        else if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=cost[n]+Math.min(minCost(n-1,cost),minCost(n-2,cost));
        
    }
}
