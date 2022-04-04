//leetcode.com/problems/coin-change/

//unbounded knapsack

//Approach 1: O(n^2) space
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;
        int inf=Integer.MAX_VALUE-1;
        int dp[][] =new int[m+1][n+1];
        for(int j=1;j<=n;j++){
            dp[0][j]=inf;
            dp[1][j]=((j%coins[0])==0?(j/coins[0]):inf);
        }
        
        for(int i=2;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[m][n]==inf?-1:dp[m][n];
        
        
        
    }
}


///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/

//Approach 2: O(n) space

class Solution {
    public int coinChange(int[] coins, int amount) {
        //unnbounded knapsack problem
        int m=coins.length;
        int n=amount;
        
        int inf=Integer.MAX_VALUE-1;
        
        int dp[] =new int[n+1];
        
        for(int j=1;j<=n;j++){
            // dp[0][j]=inf;
            dp[j]=((j%coins[0])==0?(j/coins[0]):inf);
        }
        
        for(int i=2;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1]<=j){
                    dp[j]=Math.min(1+dp[j-coins[i-1]],dp[j]);
                }else{
                    dp[j]=dp[j];
                }
            }
        }
        
        return dp[n]==inf?-1:dp[n];
        
        
        
    }
}
