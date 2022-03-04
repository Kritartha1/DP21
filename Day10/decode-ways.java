//leetcode.com/problems/decode-ways/submissions/
//Top down approach:

class Solution {
    int[] dp;
    public int numDecodings(String s) {
        
        int n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        solve(s,0,n);
        
        return dp[0];
    }
    
    public boolean isValid(int c){
        return c>0&&c<=26;
    }
    
    public int solve(String s,int i,int n){
        
        if(i>=n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int curr=Integer.parseInt(s.substring(i,Math.min(i+2,n)));
        
        dp[i]=(s.charAt(i)!='0')?
            solve(s,i+1,n)+(isValid(curr)&&(i+2)<=n?solve(s,i+2,n):0)
            :0;
        
        return dp[i];
    }
}
//**************************************************************************************************************************************************************************
//Bottom up:
class Solution {
    public int numDecodings(String s) {
        
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        
        for(int i=n-1;i>=0;i--){
          
            if(s.charAt(i)!='0'){
                dp[i]=dp[i+1];
                if((i<n-1)&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')){
                    dp[i]+=dp[i+2];
                }
                
            }
        }
        
        return dp[0];
        
    }
}
//***************************************************************************************************************************************************************************
//Iterative approach: Space efficient:
class Solution {
    public int numDecodings(String s) {
        
        int n=s.length();
        
        int a=1;
        int b=0;
        int temp=0;
        
        for(int i=n-1;i>=0;i--){
            
            temp=0;
            if(s.charAt(i)!='0'){
                temp=a;
                if((i<n-1)&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')){
                    temp+=b;
                }
                
                
            }
            b=a;
            a=temp;
        }
        
        return a;
        
    }
}
