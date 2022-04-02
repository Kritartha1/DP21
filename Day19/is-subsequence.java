//leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i_s=0;
        int i_t=0;
        
        int m=s.length();
        
        if(m==0){
            return true;
        }
        int n=t.length();
       
        for(int i=0;i<n;i++){
            if(s.charAt(i_s)==t.charAt(i_t)){
                i_s++;
                if(i_s==m){
                    return true;
                }
            }
            i_t++;
        }
        
        return false;
    }
}
