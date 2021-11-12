class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        dp[1]=nums[0];
        if(n>1){
            for(int i=2;i<=n;i++){
                dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]);
            }
        }
        return dp[n];
        
    }
  

}
//dp[0] means 0 element in nums..
      //so it will return 0 or null
      //dp[1] means 1 element in nums..so, it will return the only element nums[0]
      //dp[2] means 2 element in nums..
      //now the recursion tree or logic will follow
      //eg: 5 elelments..
      // a b c d e 
      //starting from the last element..it has two options..either we may take that or reject that..
      //if we take e, we can't take d..
      //if we don't take e, d can have 2 options like e..either take it or reject it..
      //so, starting from e...or last index..
      //if we take it..dp[5]//5 elements
      
      //dp[5]=Math.max(x,y)
      //x---->last element is taken..so x=nums[n-1]+dp[n-2]//dp[n-2] bcoz...e is taken, so d can't be chosen..so we are left with 5-2 =3 elements..so, dp will handle for a b c
      //y---->last element not taken..so, y=dp[n-1]//e is not taken..so we are left with 5-1=4=n-1 elements a b c d..so, dp[n-1] will handle it
      //and base cases, if no elelments, total cost =0..dp[0]=0
      //base case 2: if only one element ..total cost =that element cost only..nums[0]
