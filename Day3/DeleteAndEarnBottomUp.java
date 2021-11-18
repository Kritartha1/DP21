
    class Solution {
    int[] dp;
     public int deleteAndEarn(int[] nums) {
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];//to get the max number of nums to make the bucket
            }
        }
        int freq[]=new int[max+1];
        int n=freq.length;
        
        for(int k:nums){
            freq[k]+=k;//bcoz if we take nums[i]..we have to take all it's copies..
            //so storing it's copies as a sum..
        }
        dp=new int[n+1];
        dp[1]=freq[0];
        if(n>1){
            for(int i=2;i<=n;i++){
                dp[i]=Math.max(freq[i-1]+dp[i-2],dp[i-1]);
            }
        }
        return dp[n];
        
    }
  

}
