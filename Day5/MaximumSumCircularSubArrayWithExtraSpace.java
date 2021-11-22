class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int currSum=0;
        int maxSum=nums[0];
        for(int i=0;i<n;++i){
            currSum=nums[i]+Math.max(currSum,0);
            maxSum=Math.max(currSum,maxSum);
        }
        int rightSum[]=new int[n];
        rightSum[n-1]=nums[n-1];
        for(int i=n-2;i>=0;--i){
            rightSum[i]=rightSum[i+1]+nums[i];
        }
        
        int[] maxRight=new int[n];
        maxRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;--i){
            maxRight[i]=Math.max(maxRight[i+1],rightSum[i]);
        }
        int leftSum=0;
        for(int i=0;i<n-2;++i){
            leftSum+=nums[i];
            maxSum=Math.max(maxSum,leftSum+maxRight[i+2]);
        }
        return maxSum;
    }
}
