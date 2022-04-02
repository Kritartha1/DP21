class Solution {
//leetcode.com/problems/longest-common-subsequence/
    public int longestCommonSubsequence(String text1, String text2) {
    
        int m=text1.length();
        int n=text2.length();
        
        int ans=0;
        
        int[]dp=new int[n+1];
        int prev=0;
        
        for(int i=1;i<=m;i++){
            prev=0;
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[j]=1+temp;
                }else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                
                prev=temp;//dp[i-1][j-1]
            }
        }
        
        return dp[n];
    }
}
