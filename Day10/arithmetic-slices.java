//leetcode.com/problems/arithmetic-slices/submissions/

//************************************************************************************************************************************************************************
//Approach 1:
//Top down approach:
class Solution {
    int ans=0;
    int[] dp;
    public int numberOfArithmeticSlices(int[] nums) {
     int n=nums.length;
     if(n<3){
         return 0;
     }
    dp=new int[n+1];
    solve(2,nums,nums[1]-nums[0]);
    return ans;
        
    }
    
    public void solve(int i,int[] nums,int diff){
        if(i==nums.length){
            return ;
        }
        
        if(nums[i]-nums[i-1]==diff){
            
            dp[i]=dp[i-1]+1;
            ans+=dp[i];
        }else{
            
            dp[i]=0;
            diff=nums[i]-nums[i-1];
        }
        solve(i+1,nums,diff);
    
    }
}

//************************************************************************************************************************************************************************
//Approach 2:
//Top down memory efficient

class Solution {
    int ans=0;
    int curr=0;
    public int numberOfArithmeticSlices(int[] nums) {
     int n=nums.length;
     if(n<3){
         return 0;
     }
        
   
        
    solve(2,nums,nums[1]-nums[0]);
        
    return ans;
        
    }
    
    public void solve(int i,int[] nums,int diff){
        if(i==nums.length){
            return ;
        }
        
        if(nums[i]-nums[i-1]==diff){
            curr=curr+1;
            ans+=curr;
        }else{
            
            curr=0;
            diff=nums[i]-nums[i-1];
        }
        solve(i+1,nums,diff);
    
    }
}

//************************************************************************************************************************************************************************

//Approach 3:
//Bottom up or iterative approach
class Solution {
    
    public int numberOfArithmeticSlices(int[] nums) {
        
       int ans=0;
       int curr=0;//curr will store the current length of the AP.
        //if a different difference is found out,curr will be set to 0..means current AP subsequence length is 0 
        
       int n=nums.length;
        
       if(n<3){
           return 0;
       }
       int diff=nums[1]-nums[0];
        
       for(int i=2;i<n;i++){
           
          if(nums[i]-nums[i-1]==diff){
            curr=curr+1;
              //+1 added bcoz when new element is added , the new element with the previous 2 elements will form a new subsequence of AP.
              //the right side curr is the length of the AP ending at the previous element...with same c.d as nums[i]-nums[i-1]
            ans+=curr;
        }else{
            
            curr=0;
            diff=nums[i]-nums[i-1];
        }
           
      }  
        
      return ans;
        
    }
    
}

//************************************************************************************************************************************************************************
