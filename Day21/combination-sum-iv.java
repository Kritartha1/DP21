//leetcode.com/problems/combination-sum-iv/
//Appraoch 1: O(n^2) time

class Solution {
    //leetcode.com/problems/combination-sum-iv/
    int[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp=new int[202][1001];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        int ans=solve(0,target,nums);
        return ans;
    }
    
    public int solve(int i,int j,int[] nums){
        if(j==0){
            return 1;
            
        }
        else if(j<0){
            return 0;
        }
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=0;
        
        for(int k=0;k<nums.length;k++){
            res+=solve(k,j-nums[k],nums);
            
        }
        
        return dp[i][j]=res;
        
        
    }
}

//Approach 2:O(n) spae complexity


class Solution {
    
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp=new int[1001];
        Arrays.fill(dp,-1);
        
        
        int ans=solve(0,target,nums);
        return ans;
    }
    
    public int solve(int i,int j,int[] nums){
        if(j==0){
            return 1;
            
        }
        else if(j<0){
            return 0;
        }
        else if(dp[j]!=-1){
            return dp[j];
        }
        int res=0;
        
        for(int k=0;k<nums.length;k++){
            res+=solve(k,j-nums[k],nums);
            
        }
        
        return dp[j]=res;
        
        
    }
}
