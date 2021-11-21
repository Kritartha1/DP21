class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(currSum<nums[i]){
                currSum=nums[i];
            }
            sum=Math.max(sum,currSum);
        }
        return sum;
        
    }
}
