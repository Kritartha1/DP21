class Solution {
    public int getMaxLen(int[] nums) {
        int pos=0;//to get contigous current length of positive prod
        int neg=0;//tp get contiguous current length of negative prod
        int maxLen=0;//to get max length of positive product subarray
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                pos=0;
                neg=0;
            }else if(nums[i]>0){
                pos++;
                neg=neg==0?0:neg+1;
            }else{
                
                int temp=pos;
                pos=neg==0?0:neg+1;
                neg=temp+1;
            }
            maxLen=Math.max(pos,maxLen);
        }
        return maxLen;
    }
}
