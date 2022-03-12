//leetcode.com/problems/maximal-square/

//Approach1: space inefficient O(m*n) spcae

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int max=0;
        
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(matrix[i][j]=='1'){//don't skip this condition..
                    //confused? (visualize graph in a white paper):chill .
                    
                    dp[i+1][j+1]=1+Math.min(Math.min(dp[i+1][j],dp[i][j]),dp[i][j+1]);
                max=Math.max(dp[i+1][j+1],max);
                    
                }
                
                
            }
        }
        
        return max*max;
    }
}

///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/

//Approach 2: Space efficient. O(n) space

class Solution {
    //leetcode.com/problems/maximal-square/solution/
    public int maximalSquare(char[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int max=0;
        
        int[] dp=new int[n+1];
        
        int prev=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                int temp=dp[j+1];
                //this temp dp[j+1] is j+1th dp val of previous row..
                //this will act as the immediate uper left diagonal or previous element for the next iteration...
                
                if(matrix[i][j]=='1'){//don't skip this condition..
                    //confused? (visualize graph in a white paper):chill .
                    dp[j+1]=1+Math.min(Math.min(prev,dp[j]),dp[j+1]);
                max=Math.max(dp[j+1],max);
                    
                }else{
                    dp[j+1]=0;
                }
                
                prev=temp;
                
                
            }
        }
        
        return max*max;
    }
}
