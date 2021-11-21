class Solution {
    int maxSum;
    int[] dp;
    public int maxSubArray(int[] nums) {
        
        dp =new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        maxSum=dp[0];
        
        s(nums,0);
        return maxSum;
        
    }
    public int s(int[] nums,int i){
        if(i==nums.length){
            return 0;
        }else if(dp[i]!=Integer.MIN_VALUE){
            return dp[i];
        }else{
            dp[i]=Math.max(nums[i],nums[i]+s(nums,i+1));
            maxSum=Math.max(dp[i],maxSum);
            return dp[i];
        }
    }
}
