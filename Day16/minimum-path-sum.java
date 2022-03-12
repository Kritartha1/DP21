//leetcode.com/problems/minimum-path-sum/
class Solution {

    int inf=Integer.MAX_VALUE;
    
    public int minPathSum(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            
                if(i!=0||j!=0){
                   grid[i][j]+=Math.min(prev(i-1,j,grid,m,n),prev(i,j-1,grid,m,n)); 
                }
                
                
            }
        }
        
        return grid[m-1][n-1];
        
    }
    public int prev(int r,int c,int[][] grid,int m,int n){
        return (r<0||c<0||r>=m||c>=n)?inf:grid[r][c];
    }
}
