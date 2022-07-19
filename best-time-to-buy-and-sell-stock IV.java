//leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

//Approach 1: Recursive +dp
class Solution {
    int[][] dp;
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[n+1][k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(k,0,prices);
    }
    int helper(int k,int i,int[] prices){
        if(k==0||i>=prices.length){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        
        int buy=prices[i];
        int ans=0;
        ans=Math.max(ans,helper(k,i+1,prices));
        for(int j=i+1;j<prices.length;j++){
            if(prices[j]>=buy){
                ans=Math.max(ans,prices[j]-buy+helper(k-1,j+1,prices));
            }
        }
        return dp[i][k]=ans;
    }
}

//Approach 2: Top down
class Solution {
    int[][] dp;
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[n+1][k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(k,n,prices);
    }
    int helper(int k,int n,int[] prices){
        if(k<=0||n<=0){
            return 0;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        
        int sell=prices[n-1];
        int ans=0;
        ans=Math.max(ans,helper(k,n-1,prices));
        for(int j=n-1;j>=1;--j){
            if(prices[j-1]<=sell){
                ans=Math.max(ans,sell-prices[j-1]+helper(k-1,j-1,prices));
            }
        }
        return dp[n][k]=ans;
    }
}

//Approach 3: Bottom up
class Solution {
    
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][k+1];
//         for(int i=0;i<=n;i++){
//             dp[i][0]=0;//k=0
            
//         }
//         for(int j=0;j<=k;j++){
//             dp[0][j]=0;//containing 0 element 
//             dp[1][j]=0;//containing one element
//         }
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j];
                for(int t=i-1;t>=1;--t){
                    if(prices[t-1]<=prices[i-1]){
                        dp[i][j]=Math.max(prices[i-1]-prices[t-1]+dp[t-1][j-1],dp[i][j]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
}
