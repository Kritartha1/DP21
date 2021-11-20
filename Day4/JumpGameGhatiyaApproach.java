

public class Solution {
//ghatiya approach
    int dp[];
    public boolean canJump(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);

        boolean k=jump(0,nums);
        return k;

    }
    public boolean jump(int i,int[] nums){
        if(i==nums.length-1){//when reached end...return true
            return true;
        }
        
        
        for(int j=1;(j<=nums[i])&&(i+j)<nums.length;j++){//eg..nums[2]=5...so...we can have step=1 or 2 or 3 or 4 or 5 at a time..so we are checking each steps for ans
          //also (i+j)<nums.length to make sure that index doesn't exceed the limit of nums[] array
            boolean t=false;
            if(dp[i + j + 1] == -1){
                t=jump(i+j,nums);
                dp[i+j+1]=(t?1:0);//dp[]=1--->true,dp[]=0--------->false.
            }
            else{
                t=(dp[i + j + 1] == 1);//d[[]=1 means true...else false
            }

            if(t){//if we get returned true, then we can reach to end..so return true..
                
                return true;
            }
        }
      //after loooping if we can't reach to end, we will get returned false..
        
        return false;
    }
}
