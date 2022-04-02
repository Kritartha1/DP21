//for more explanation: check notes spiral notebook.
//leetcode.com/problems/edit-distance/

//Approach 1: O(n) space...best solution.
class Solution {
    public int minDistance(String word1, String word2) {
        
        int m=word1.length();
        int n=word2.length();
        
        
        int[] dp=new int[n+1];
        
        for(int i=0;i<=n;i++){
            dp[i]=i;
        }
        
        int prev=0;//for dp[i-1][j-1]
        int prev2=0;//for dp[i][j-1]
        
        for(int i=1;i<=m;i++){
            
            prev=i-1;
            prev2=i;
            
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[j]=prev;
                }
                else{
                    dp[j]=1+Math.min(prev2,Math.min(dp[j],prev));
                }
                prev=temp;
                prev2=dp[j];
                
            }
        }
        
        return n==0?(m==0?0:1):dp[n];
    }
}

//Approach 2: O(n^2) space. brute force
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        
        return dp[m][n];
    }
}
