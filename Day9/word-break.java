//Top down approach
//leetcode.com/problems/word-break/
class Solution {
    
    HashSet<String> Set;
    int dp[];
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set=new HashSet<>(wordDict);
        
        int n=s.length();
        
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(s,0,n);
        
    }
    public boolean solve(String s,int i,int n){
        
        if(i>=n){//means the whole string is already calculated..so we are left with no remains of the string..which will fetch a true..
            return true;
        }
        
        else if(dp[i]!=-1){
            return dp[i]==1;
        }
        
        boolean ans=false;
        
        for(int j=i+1;j<=n;j++){
            ans|=Set.contains(s.substring(i,j))&solve(s,j,n);
        }
        dp[i]=(ans)?1:0;
        return ans;
    }
}
