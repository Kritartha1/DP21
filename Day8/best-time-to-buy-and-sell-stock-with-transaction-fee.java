class Solution {
    public int maxProfit(int[] prices, int fee) {
        //Explanation at solution: //leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
        int s0=0,b0=0;
        //s0=sell at i,
        //b0=but at i ,
        
        b0=-prices[0]-fee;
        
        
        int n=prices.length;
        
        //at day i, we either buy, sell or be idle
        //case buy: at day i we either buy a new stock if if already have completed atransaction ..or don't don anything 
        //b0 :sit idle..
        //s0-prices[i]-fee: buy stock at day i
        
        //case sell: we either sell at day i or just sit idle..
        //sell at day i:b0+prices[i]
        //hold it :s0..s0 is the transaction of the previous state
        
        for(int i=1;i<n;i++){
            
            b0=Math.max(b0,s0-prices[i]-fee);
            s0=Math.max(b0+prices[i],s0);
            
            
            
        }
        
        return s0;
    }
}
