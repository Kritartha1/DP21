class Solution {
  //O(n^2) time chala jaayega yeh..
  //and space O(n)..
  //kharab hai yeh
    
    int[] dp;
    public int jump(int[] nums) {
        dp=new int[nums.length+1];
        if(nums.length==1){
            return 0;
        }
        Arrays.fill(dp,-1);
        dp[0]=0;
       
        return j(nums,nums.length-1);
    }
    public int j(int[] nums,int n){
        if(n<=0){
            return 0;
        }else if(dp[n]!=-1){
            return dp[n];
        }else{
            int k=n-1;
            int x=Integer.MAX_VALUE;
            while(k>=0){//eg: 8 2 5 7 9..so yha pe lets say n=4..that is arr[n]=9..
              // Step: 1 //so, 9 tak pahuchne k liye hum 7 tak jump kar sakte hai...so ans=1+j(arr,n-2)
              // Step: 2 //ya 5 tak jump karo,,5 se jump karo 9 tak...ans=1+j(arr,n-3)
              // Step: 3 //2 se jump nhi kar sakte..kyuki (n-4=1 hai) nums[n-4]+(n-4) karne se index (n-1) tak nhi jaa sakta...that is 9 tak jump nhi kar sakte..
              // Step: 4 //8 se jump kar sakte hai..ans=1+j(arr,0)....and base case hai yeh toh j(arr,0)=0 hai...
              // Step: 5 //so jitne baar iterate kiya abhi unka min value hoga ans..
              
                if((k+nums[k])>=n){//jaise step 3 me hua tha..2 se jump nhi kar sakte..so unko ignore k liye yeh condition lagaya hai
                    
                    x=Math.min(1+j(nums,k),x);
                }
                k--;
            }
            return dp[n]=x;
        }
    }
}
