//leetcode.com/problems/perfect-squares/

class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        solve(n);
        
        return dp[n];
    }
    
    
    int solve(int n){
        if(n==0){
            return dp[n]=0;
        }
        
        if(n<0){
            return Integer.MAX_VALUE ;
            
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        
        int ans=n;
        for(int i=1;i*i<=n;i++){
            if(i*i==n){
                ans=1;
                break;
            }
            int temp=solve(n-i*i);
            ans=(temp==Integer.MAX_VALUE)?ans:Math.min(ans,1+temp);
            
        }
       
        dp[n]=ans;
        return dp[n];
        
        
    }
}
