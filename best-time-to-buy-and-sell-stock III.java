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
