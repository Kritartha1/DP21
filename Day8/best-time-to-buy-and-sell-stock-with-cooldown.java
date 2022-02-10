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

//****************************************************************************************************************************************************************************
//Best approach:O(n)

class Solution {
    public int maxProfit(int[] prices) {
        //Explanation://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
        int b0=0,b1=1,s0=0,s1=0,s2=0;
        //b0=buy at i or eqv
        //b1=buy at i-1 or eqv
        //s0=sell at i or eqv
        //s1 =sell at i-1 or eqv
        //s2=sell at i-2 or eqv
        b0=-prices[0];
        b1=b0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            b0=Math.max(b1,s2-prices[i]);
            s0=Math.max(s1,b1+prices[i]);
            s2=s1;
            s1=s0;
            b1=b0;
        }
        
        return s0;
    }
}
