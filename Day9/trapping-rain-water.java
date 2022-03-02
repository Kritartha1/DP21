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
//2.Two pointers approach:
class Solution {
    public int trap(int[] height) {
        
        int n=height.length;
        
        int l=0;
        int r=n-1;
        
        int l_max=height[0];
        int r_max=height[n-1];
        
        int ans=0;
        //logic:
        //if left height or current height is less than right height..
        //then answer will depend on the left_max height..
        //it can fill the max upto maximum left tower height..
        //which will obviously be less than right max if left tower height<right tower height is obtained...
        //SImilarly we can say it for the right side ..
        
        //for more insights,check Approach 4 pointers approach leetcode solution
        
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=l_max){
                    l_max=height[l];
                }else{
                    ans+=(l_max-height[l]);
                }
                ++l;
            }else{
                if(height[r]>=r_max){
                    r_max=height[r];
                }else{
                    ans+=(r_max-height[r]);
                }
                --r;
            }
        }
        return ans;
    }
}

//***********************************************************************************************************************************************************************
//Brute force approach:
int trap(vector<int>& height)
{
    if(height.empty())
        return 0;
    int ans = 0;
    int size = height.size();
    vector<int> left_max(size), right_max(size);
    left_max[0] = height[0];
    for (int i = 1; i < size; i++) {
        left_max[i] = max(height[i], left_max[i - 1]);
    }
    right_max[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
        right_max[i] = max(height[i], right_max[i + 1]);
    }
    for (int i = 1; i < size - 1; i++) {
        ans += min(left_max[i], right_max[i]) - height[i];
    }
    return ans;
}
