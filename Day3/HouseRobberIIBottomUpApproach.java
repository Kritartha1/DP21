class Solution {
    int[] dp;
    int[] dp2;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        dp2=new int[n+1];
        dp[1]=nums[0];
        dp2[1]=0;
        if(n>1){
           
            for(int i=2;i<=n;i++){
                dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]);
            }
            for(int i=2;i<=n;i++){
                dp2[i]=Math.max(nums[i-1]+dp2[i-2],dp2[i-1]);
            }
            return Math.max(dp[n-1],dp2[n]);
            
            
        }
        return dp[n];
        
        
    }
  

}
