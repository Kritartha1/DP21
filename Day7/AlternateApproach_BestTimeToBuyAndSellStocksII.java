class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int i=0;
        int valley=prices[0];
        int peak=prices[0];
        int n=prices.length;
        while(i<n-1){
            while(i<n-1&&prices[i]>=prices[i+1]){
                i++;
            }
            valley=prices[i];
            while(i<n-1&&prices[i]<=prices[i+1]){
                i++;
            }
            peak=prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}
