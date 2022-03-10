//leetcode.com/problems/range-sum-query-2d-immutable/
//same approach as the last qsn
//range Sum/prefix sum approach
class NumMatrix {
    
    private int[][] rangeSum;

    public NumMatrix(int[][] matrix) {
        
        matrixBlockSum(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
               
        return (this.rangeSum[row2+1][col2+1]-this.rangeSum[row1][col2+1]-this.rangeSum[row2+1][col1]+this.rangeSum[row1][col1]);
        
    }
    
    private void matrixBlockSum(int[][] matrix) {
    
        int m=matrix.length;
        int n=matrix[0].length;
        
        this.rangeSum=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                this.rangeSum[i][j]=this.rangeSum[i-1][j]+this.rangeSum[i][j-1]-this.rangeSum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
