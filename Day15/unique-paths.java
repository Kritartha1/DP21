//leetcode.com/problems/unique-paths/

//Approach 1: Math approach O(n)
class Solution {
   
    public int uniquePaths(int m, int n) {
        double ans=1;
        //factorial it is..
        for(int i=1;i<n;i++){
            ans*=(m+n-1-i);
            ans/=i;
            
        }
        
        return (int)(Math.round(ans));
    }
    
}
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

//Approach 2: O(m+n)
class Solution {
    public int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=solve(0,0);
        return ans;
    }
    public int solve(int i,int j){
        if(i==dp.length||j==dp[0].length){
            return 0;
        }
        else if(i==dp.length-1||j==dp[0].length-1){
           
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=solve(i,j+1)+solve(i+1,j);
        
        return dp[i][j]=ans;
    }
}
//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\


//Approach 3: Space efficient

class Solution {
   
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
                //same as dp[i][j]=dp[i-1][j]+dp[i][j-1]
                //[i-1][j] means previous value of j or value of j from the previous layer.
                //dp[i][j-1] means of the same layer value of the predecessor of j
            }
        }
        
        return dp[n-1];
    }
    
}

