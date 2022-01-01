class Solution {
    public int maxProduct(int[] nums) {
        int l=1;
        int r=1;
        int ans=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            l=l==0?1:l;
            r=r==0?1:r;
            l*=nums[i];
            r*=nums[n-i-1];
            ans=Math.max(Math.max(l,r),ans);
        }
        return ans;
        
    }
}
