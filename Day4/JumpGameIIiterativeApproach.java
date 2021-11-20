class Solution {
    public int jump(int[] nums) {
        int currLevel=0;
        int maxReachableIndex=0;int jump=0;
        for(int i=0;i<nums.length-1;i++){
            
            maxReachableIndex=Math.max(i+nums[i],maxReachableIndex);
            if(i==currLevel){
                jump++;
                currLevel=maxReachableIndex;
            }
            
        }
        return jump;
        
    }
}
