//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

class Solution {
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[3];
        int[] ksum=new int[n];
        
        int i=0,j=0;
        
        for(;i<k;i++){
            ksum[j]+=nums[i];
        }
        while(i<n){
            ksum[j+1]=ksum[j]-nums[j++]+nums[i++];
        }
        
        int max=Integer.MIN_VALUE;
        
        int r[]=new int[n];
        int l[]=new int[n];
 
        r[n-k-1]=n-k;
        
        for(i=n-k-2;i>=0;--i){
            
            if(ksum[i+1]>=ksum[r[i+1]]){
                r[i]=i+1;
                
            }else{
                r[i]=r[i+1];
            }
            
        }
        
        l[k]=0;
        
        for(i=k+1;i<=n-2*k;++i){
            
            if(ksum[i-k]>ksum[l[i-1]]){
                l[i]=i-k;
            }else{
                l[i]=l[i-1];
            }
            
        }
        
        for(i=k;i<=n-2*k;i++){
            
             if(ksum[i]+ksum[l[i]]+ksum[r[i+k-1]]>max){
                max=ksum[i]+ksum[l[i]]+ksum[r[i+k-1]];
                ans=new int[]{l[i],i,r[i+k-1]};
            }
            
                
                
            
        }
        return ans;
    }
}
