class Solution {
    public boolean canJump(int[] nums) {
      //O(n) time..
      //O(1) space
      
        int maxReachableIndex=0;//initializing
      
        int i=0;
      
        for(i=0;i<nums.length&&i<=maxReachableIndex;++i){
          
            maxReachableIndex=Math.max(i+nums[i],maxReachableIndex);
            //we are doing this bcoz agar maxReachableindx>=n-1 aya matlab woh last tak jaa sakta hai..
            //agar maxReachableIndex bich me atak gaya..
            //that is loop khatm hone tak(i==n-1) agar maxReachableIndex bich me hi saturated ho gaya then we can't reach last index anyway..
            //and since yeh condn (i<=maxReachableIndex) lagaya hai..agar maxReachableIndex bich me hi saturated ho gaya ..then i can never reach to last index..
            //so return (i==nums.length) check karna jaruri hoga end me
        }
      
        return i==(nums.length);//bcoz jab loop khatm hoga..i=n ho jaayega..
    }
}
