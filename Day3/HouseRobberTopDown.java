class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int a=r(nums,n-1);
        return a;
    }
    public int r(int[] nums,int n){
        if(n<0){
            return 0;
        }else if(n==0){
            return nums[n];
        }
        else if(dp[n]!=-1){
            return dp[n];
        }
        
        return dp[n]=Math.max(nums[n]+r(nums,n-2),r(nums,n-1));
    }
}
