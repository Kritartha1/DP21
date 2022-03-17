//leetcode.com/problems/longest-increasing-subsequence/

//Approach1: LCS O(n^2) space
class Solution {
    public int lengthOfLIS(int[] nums) {
        int m=nums.length;
        int[] nums2=new int[m];
        for(int i=0;i<m;i++){
            nums2[i]=nums[i];
        }
        Arrays.sort(nums2);
        int n=removeDuplicates(nums2);
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
        
    }
    
    public int removeDuplicates(int[] X){
        int j=0;
        for(int i=0;i<X.length;i++){
            if(X[i]!=X[j]){
                X[++j]=X[i];
            }
        }
        
        return j+1;//length of increasing array 
    }
}


///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\\///\\///\\\///\\\///\\\///\

//Approach 2:
//LCS approach..O(n) space complexity
class Solution {
    public int lengthOfLIS(int[] nums) {
        int m=nums.length;
        
        int[] nums2=new int[m];
        for(int i=0;i<m;i++){
            nums2[i]=nums[i];
        }
        Arrays.sort(nums2);
        int n=removeDuplicates(nums2);
        
        int[] dp=new int[n+1];
        int prev=0;
        
        for(int i=1;i<=m;i++){
            prev=0;//since, the first row and the first col is obviously 0..
            
            for(int j=1;j<=n;j++){
                int temp=dp[j];//this dp[j] is pf (i-1)th row..which will act as upper left diagonal element for ith row, (j+1)th element
                if(nums[i-1]==nums2[j-1]){
                    dp[j]=1+prev;
                }else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                
                prev=temp;
            }
        }
        
        return dp[n];
        
    }
    
    public int removeDuplicates(int[] X){
        int j=0;
        for(int i=0;i<X.length;i++){
            if(X[i]!=X[j]){
                X[++j]=X[i];
            }
        }
        
        return j+1;//length of increasing array 
    }
}
