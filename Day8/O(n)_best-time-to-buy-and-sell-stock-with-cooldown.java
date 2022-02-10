class Solution {
    public int maxProfit(int[] prices) {
        //Explanation:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/240097/Come-on-in-you-will-not-regret-most-general-java-code-like-all-other-DP-solutions
        int n=prices.length;
        int prev[]=new int[n];
        int maxDiff=0;
        
        prev[0]=0;
        
        if(n>1){
            
            prev[1]=Math.max(prices[1]-prices[0],prev[0]);
            
            maxDiff=Math.max(-prices[1],-prices[0]);
        
        for(int i=2;i<n;i++){
            
            
            prev[i]=Math.max(prev[i-1],maxDiff+prices[i]);
            
            maxDiff=Math.max(maxDiff,prev[i-2]-prices[i]);
            
                
            }
        }
        
        
        
       
        
        
        return prev[n-1];
    }
}
