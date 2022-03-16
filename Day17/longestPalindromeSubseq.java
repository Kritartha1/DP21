//leetcode.com/problems/longest-palindromic-subsequence/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String revS=(new StringBuilder()).append(s).reverse().toString();
        int ans=LCS(s,revS,n,n);
        return ans;
    }
    
    public int LCS(String a ,String b,int m,int n){
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
        
    }
}
