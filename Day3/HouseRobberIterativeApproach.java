class Solution {
    
    public int rob(int[] nums) {
        int n=nums.length;
       int a=0,b=nums[0];
        int i=1;
        while(n-->1){
            int temp=b;
          //we can see from the bottom up approach that to compute dp[n], dp[n-1] and dp[n-2] are needed
          //that is,,,only previous two states are stored..
          //we are storing previous states in int a and int b..
          //int a----->dp[n-2]......int b----->dp[n-1]
            b=Math.max(nums[i]+a,temp);
            a=temp;
            i++;
        }
        return b;
        
    }

}
