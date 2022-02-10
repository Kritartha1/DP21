 //Explanation:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/240097/Come-on-in-you-will-not-regret-most-general-java-code-like-all-other-DP-solutions
        

//Approach 1: O(n^2)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int prev[]=new int[n];
        prev[0]=0;
        
        for(int i=1;i<n;i++){
            prev[i]=prev[i-1];
            
            for(int j=0;j<i;j++){
                prev[i]=Math.max(prev[i],(j-2>=0?prev[j-2]:0)+prices[i]-prices[j]);
                
            }
        }
        return prev[n-1];
    }
}

//****************************************************************************************************************************************************************************


//Approach2:O(n)
class Solution {
    public int maxProfit(int[] prices) {
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
        } return prev[n-1];
    }
}
