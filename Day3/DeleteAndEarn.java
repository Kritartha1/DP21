class Solution {
    public int deleteAndEarn(int[] nums) {
        //problem is same as house robber..
        //if i take nums[i], I can't take num[i]-1 and nums[i]+1..
        //so, it's like can't rob adjacent houses..
        //to get everything adjacent wise..
        //we are storing it as bucket or frequency..
        //
        /
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];//to get the max number of nums to make the bucket
            }
        }
        int freq[]=new int[max+1];
        int n=freq.length;
        for(int k:nums){
            freq[k]+=k;//bcoz if we take nums[i]..we have to take all it's copies..
            //so storing it's copies as a sum..
        }
        int a=0;//take freq[i-1]
        int b=0;//skip freq[i-1] 
        int i=0;
        while(n-->0){
            int c=freq[i]+b;//take freq[i]..which will be prev answer of (i-1) skipping freq[i-1]
            int d=Math.max(a,b);//skip freq[i]and take the previous best of (i-1) taking or skipping freq[i-1]
            a=c;//setting it up for the next loop..for next loop freq[i] will be freq[i-1].since, i will get incremented
            b=d;//setting for next loop..............................................
            i++;
        }
        return Math.max(a,b);
        
        
    }
}
