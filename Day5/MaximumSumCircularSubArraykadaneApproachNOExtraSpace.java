class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      //same approach as negative kedane one..
      //but now we didn't make the nums[i] opposite sign..
      //because now we found out min sum of positive elements
        int currSum=0;
        int maxSum=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            currSum=nums[i]+(currSum<0?0:currSum);
            maxSum=Math.max(currSum,maxSum);
            
        }
       
        
        currSum=0;
        int maxSum2=Integer.MIN_VALUE;
        for(int i=1;i<nums.length-1;i++){
            currSum=nums[i]+Math.min(currSum,0);
            maxSum2=Math.max(sum-currSum,maxSum2);
        }
        return Math.max(maxSum2,maxSum);
        
        
    }
}
