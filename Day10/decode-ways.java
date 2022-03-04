//leetcode.com/problems/decode-ways/submissions/
//Top down approach:

class Solution {
    int[] dp;
    public int numDecodings(String s) {
        
        int n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        solve(s,0,n);
        
        return dp[0];
    }
    
    public boolean isValid(int c){
        return c>0&&c<=26;
    }
    
    public int solve(String s,int i,int n){
        
        if(i>=n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int curr=Integer.parseInt(s.substring(i,Math.min(i+2,n)));
        
        dp[i]=(s.charAt(i)!='0')?
            solve(s,i+1,n)+(isValid(curr)&&(i+2)<=n?solve(s,i+2,n):0)
            :0;
        
        return dp[i];
    }
}
//**************************************************************************************************************************************************************************
