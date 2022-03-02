//leetcode.com/problems/trapping-rain-water/solution/


//1. Stack solution:

//****************************************************************************************************************************************************************************
class Solution {
    public int trap(int[] height) {
        
        int i=0;
        int n=height.length;
        int ans=0;
        
        Stack<Integer> s=new Stack<>();
        
        while(i<n){
            
            while(!s.isEmpty()&&height[i]>height[s.peek()]){
                int curr=s.pop();
                
                if(s.isEmpty()){
                    break;
                }
                
                int ht=Math.min(height[s.peek()],height[i])-height[curr];
                int width=i-s.peek()-1;
                
                ans+=(ht*width);
                
            }
            s.push(i++);
        }
        
        return ans;
    }
}
//******************************************************************************************************************************************************************************
