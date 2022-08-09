//leetcode.com/problems/binary-trees-with-factors/
class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int numFactoredBinaryTrees(int[] arr) {
        
        int n=arr.length;
        Arrays.sort(arr);
        
        HashSet<Integer> st=new HashSet<>();
        
        for(int i=0;i<n;i++){
            st.add(arr[i]);
        }
        
        HashMap<Integer,ArrayList<Pair>> m=new HashMap<>();
        
        
        int mod=1000000007;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(1l*arr[i]*arr[j]<=1e9){
                     int prod=arr[i]*arr[j];
                     if(st.contains(prod)){
                       
                         Pair temp=new Pair(i,j);
                         m.putIfAbsent(prod,new ArrayList<Pair>());
                         m.get(prod).add(temp);
                         
                     }
                }
            }
            
        }
        
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        
        for(int i=1;i<n;i++){
             if(m.containsKey(arr[i])){
                 for(Pair it:m.get(arr[i])){
                     int t=2;
                     if(it.first==it.second){
                         t=1;
                     }

                     int temp=(int)((1l*dp[it.first]*dp[it.second])%mod);
                     temp=(int)((1l*t*temp)%mod);
                     dp[i]=(int)((1l*dp[i]+1l*temp)%mod);

                 }
             }
             ans=(int)((1l*ans+dp[i])%mod);
        }
        
        return ans%mod;
    }
}
