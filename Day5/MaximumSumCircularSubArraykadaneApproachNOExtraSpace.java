class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currSum=0;
        int maxSum=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            currSum=nums[i]+(currSum<0?0:currSum);
            maxSum=Math.max(currSum,maxSum);
            nums[i]=-1*nums[i];
        }
        //till here, we found max sum for non circular array...
        //now we will find max sum for circular array..
        //two interval subarray be like: 
        //S'=(nums[0]+...nums[i])+(nums[j]+....nums[n-1])----(1)
        //obviously j>=i+2..
        //from (1)..we have to maximize S'...
        //S=nums[0]+......nums[n-1]..
        //So, S'=S-(nums[i+1]+...nums[j-1]);
        //So to maximize S', (nums[i+1]+...nums[j-1]) --minimum.
        //i.e///(-nums[i+1]-nums[i+2]-...-nums[j-1])---maximum..
        //idea is ..if we make all the elements of nums array opposite sign..
        //i.e nums[k]= -nums[k]..
        //then finding negativekadane's will give us max subarray sum..
        //which will be the max sum of the opposite sign num elements..
        //which inturn is the min of (nums[i+1]+...nums[j-1]){original    elements..}
        //so..S+negativekadane((opposite sign num elements))=max(S')
        //to be circular array..min case is ([a, b,e,f c ,d]..): {a}+{d}
        //so min sum from [b,e,f,c] will give the negativeKedaneMax..
        //so S+negativeKedaneMax=max(S')
        //
        currSum=0;
        int maxSum2=Integer.MIN_VALUE;
        for(int i=1;i<nums.length-1;i++){
            currSum=nums[i]+(currSum<0?0:currSum);
            maxSum2=Math.max(sum+currSum,maxSum2);
        }
        return Math.max(maxSum2,maxSum);
        
        
    }
}
