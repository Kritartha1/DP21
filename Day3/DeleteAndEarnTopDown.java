
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
        Arrays.fill(dp,-1);
        int a=r(freq,n-1);
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
