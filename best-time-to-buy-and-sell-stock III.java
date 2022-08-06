//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int k=2;
        int[]dp=new int[n+1];
       
        int min;
        int temp;
        
        for(int j=1;j<=2;j++){
            temp=0;
            min=prices[0];
            for(int i=2;i<=n;i++){
                int new_temp=dp[i];
                //System.out.println("i:"+i+dp[i]+"  "+dp[i-1]);
                dp[i]=Math.max(dp[i-1],dp[i]);
                dp[i]=Math.max(prices[i-1]-min,dp[i]);
                
                min=Math.min(prices[i-1]-temp,min);
                temp=new_temp;
            }
            
        }
        
        return dp[n];
        
    }
}



//Approach 2:
//Since, k=2, i.e we looped two times only, so we can take variables to save time.
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
       
        int ans=0;
        int firstBuy=Integer.MIN_VALUE;
        int firstSell=0;
        int secondBuy=Integer.MIN_VALUE;
        int secondSell=0;
        for(int i=0;i<n;i++){
           firstBuy=Math.max(firstBuy,-prices[i]);
           firstSell=Math.max(firstBuy+prices[i],firstSell);
           secondBuy=Math.max(secondBuy,firstSell-prices[i]);
           secondSell=Math.max(secondSell,secondBuy+prices[i]);
            
        }
        
        return secondSell;
        
    }
}
