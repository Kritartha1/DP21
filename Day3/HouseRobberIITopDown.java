class Solution {
    int[] dp;
    
    public int rob(int[] nums) {
        
         int n=nums.length;
        if(n==1){
            return nums[0];
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
      
      //int a=robbery excluding house indexed n-1
		  //int b=robbery including house indexed n-1
      
        int a=r(nums,n-2);
      
      //solving house robber from index (n-2)..then circular thing won't interfere.
        nums[0]=0;
      
      //it is done bcoz, if robbery starts from house indexed (n-1), 
      //house number 0 shouldn't interfere in the final result.If it gets added, it could have interfered, so replaced nums[0] as 0..
      //.then , it's addition won't affect the circularity constraint
      
        Arrays.fill(dp,-1);//to solve the r() function freshly once again.
        int b=r(nums,n-1);//robbery starting from house indexed (n-1
        return Math.max(a,b);
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
