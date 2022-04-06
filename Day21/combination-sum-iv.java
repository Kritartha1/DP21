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


//Approach 3: O(n) space (similar as coin change 2)---> just order of loop changes
class Solution {
    
    
    public int combinationSum4(int[] nums, int target) {
        int m=nums.length;
        int n=target;
        
        int dp[] =new int[n+1];
        dp[0]=1;
        
        
        for(int j=1;j<=n;j++){
            for(int i=0;i<m;i++){
                if(nums[i]<=j){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        
        return dp[target];
    }
    
    
}
