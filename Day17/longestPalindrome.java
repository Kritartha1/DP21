//leetcode.com/problems/longest-palindromic-substring/
///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
//Approach 1: O(1 ) space
class Solution {
    //Time: O(n^2) approach..
    public String longestPalindrome(String s) {
        
        int start=0;
        int end=0;
        
        for(int i=0;i<s.length();i++){
            int len=Math.max(expandAroundCenter(s,i,i),
                             expandAroundCenter(s,i,i+1));
            
            //expandAroundCenter(s,i,i) means i th element is mid element of palindrome
            //expandAroundCenter(s,i,i+1) means i and i+1 element are the mid elements of palindrome.
            
            if(len>end-start+1){
                start=i-(len-1)/2;
                end=i+(len)/2;
            }
        }
        
        return s.substring(start,end+1);
        
    }
    
    public int expandAroundCenter(String s,int i,int j){
        
        int l=i;
        int r=j;
        int n=s.length();
        
        while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
            --l;
            ++r;
        }
        
        return r-l-1;
    }
}
///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\

//Aproach 2:dp O(n^2)=time=space solution.
class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length();
        String ans="";
        boolean[][] dp=new boolean[n][n];
        int max=0;
        
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                
                dp[i][j]=(s.charAt(i)==s.charAt(j))&&(j-i>2?dp[i+1][j-1]:true);
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    ans=s.substring(i,j+1);
                }
            }
        }
        
        return ans;
    }
}
