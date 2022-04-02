//leetcode.com/problems/wiggle-subsequence/
// Algorithm

// Any element in the array could correspond to only one of the three possible states:

// up position, it means nums[i] > nums[i-1]nums[i]>nums[i−1]
// down position, it means nums[i] < nums[i-1]nums[i]<nums[i−1]
// equals to position, nums[i] == nums[i-1]nums[i]==nums[i−1]
// The updates are done as:

// If nums[i] > nums[i-1]nums[i]>nums[i−1], that means it wiggles up. 
//The element before it must be a down position. So up[i] = down[i-1] + 1up[i]=down[i−1]+1, down[i]down[i] remains the same as down[i-1]down[i−1].
//If nums[i] < nums[i-1]nums[i]<nums[i−1], that means it wiggles down. The element before it must be a up position.
//So down[i] = up[i-1] + 1down[i]=up[i−1]+1, up[i]up[i] remains the same as up[i-1]up[i−1]. 
//If nums[i] == nums[i-1]nums[i]==nums[i−1], that means it will not change anything becaue it didn't wiggle at all.
//So both down[i]down[i] and up[i]up[i] remain the same as down[i-1]down[i−1] and up[i-1]up[i−1].

// At the end, we can find the larger out of up[length-1]up[length−1] and down[length-1]down[length−1] to find the max.
//wiggle subsequence length, where lengthlength refers to the number of elements in the given array.


//Approach1: O(n) space
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        
        if(n>0){
            
            int ans=0;
            
            int[] up=new int[n];
            int[] down=new int[n];
            
            up[0]=1;
            down[0]=1;
            
            for(int i=1;i<n;i++){
                
                if(nums[i]>nums[i-1]){
                    up[i]=down[i-1]+1;
                    down[i]=down[i-1];
                }
                else if(nums[i]<nums[i-1]){
                    down[i]=up[i-1]+1;
                    up[i]=up[i-1];
                }
                else{
                    down[i]=down[i-1];
                    up[i]=up[i-1];
                }
            }
            
            ans=Math.max(up[n-1],down[n-1]);
            return ans;
            
        }
        return 0;
    }
}


///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Approach 2: O(1) space

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        
        if(n>1){
            
            int ans=0;
            
            int up=1;
            int down=1;
            
           
            for(int i=1;i<n;i++){
                
                if(nums[i]>nums[i-1]){
                    up=down+1;
                    
                }
                else if(nums[i]<nums[i-1]){
                    down=up+1;
                    
                }
                
            }
            
            ans=Math.max(up,down);
            return ans;
            
        }
        return n;
    }
}

///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
//look at approach 5 at : https://leetcode.com/problems/wiggle-subsequence/solution/

//Approach 3: no dp solution.

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        
        if(n>1){
            
            
            int prevDiff=nums[1]-nums[0];
            int count=prevDiff==0?1:2;
            
            for(int i=2;i<n;i++){
                int diff=nums[i]-nums[i-1];
                if((diff>0&&prevDiff<=0)||(diff<0&&prevDiff>=0)){
                    ++count;
                    prevDiff=diff;
                }
            }
            return count;
            
        }
        return n;
    }
}
