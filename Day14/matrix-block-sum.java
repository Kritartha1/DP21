//leetcode.com/problems/matrix-block-sum/
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        //Explanation:
        //leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
        int m=mat.length;
        int n=mat[0].length;
        int[][] rangeSum=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                rangeSum[i][j]=rangeSum[i-1][j]+rangeSum[i][j-1]-rangeSum[i-1][j-1]+mat[i-1][j-1];
            }
        }
        
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                int r1=Math.max(1,i+1-k),c1=Math.max(1,j+1-k);
                int r2=Math.min(i+k+1,m),c2=Math.min(j+k+1,n);
                ans[i][j]=rangeSum[r2][c2]-rangeSum[r1-1][c2]-rangeSum[r2][c1-1]+rangeSum[r1-1][c1-1];
                
            }
        }
        
        return ans;
        
    }
}
