//leetcode.com/problems/coin-change-2/
//unbounded knapsack---aditya verma...dp notebook 2

//Appraoch 1: O(n^2) space..

class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;
        
        int dp[][] =new int[m+1][n+1];
        for(int j=1;j<=n;j++){
            dp[0][j]=0;
            
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
            
        }
        
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}


//Appraoch 2: O(n) space..
class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int n=amount;
        
        int dp[] =new int[n+1];
        dp[0]=1;
        
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1]<=j){
                    dp[j]=dp[j-coins[i-1]]+dp[j];
                }else{
                    dp[j]=dp[j];
                }
            }
        }
        
        return dp[n];
    }
}
