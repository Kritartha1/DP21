class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxR=prices[n-1];
        int ans=0;//bcoz there always have to be atleat zero or more profit always
        for(int i=n-2;i>=0;--i){
            maxR=Math.max(maxR,prices[i+1]);
          //maxR contains maxPrice from index (i to (n-1))
          //ans=Max(prices[j]-prices[i]) and i<j
          //so we need prices[j] to be max 
          //and with each iteration if we have the max prices[j]..
          //at one step we will get the least prices[i]to make max profit which will fetch our answer..
          //so we are checking for difference at every step 
            ans=Math.max(maxR-prices[i],ans);
        }
        return ans;
        
    }
}
