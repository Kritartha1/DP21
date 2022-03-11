//leetcode.com/problems/unique-paths-ii/

//two approaches are discussed here..O(m*n) space and O(n) space

//Approach 1: O(m*n) space:

class Solution {
    int[][] dp;
    
    //only difference from unique paths 1 is that..in unique path 1, if we reach the mth row or nth row , we found one of the way.
    //but here, reaching the mth row or nth col doesn't necessarily lead to an unique path..there may be obstacles in the last row or col..
    //so we have to check fot that 
    //leetcode.com/problems/unique-paths/
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        int ans=solve(0,0,obstacleGrid);
        return ans;
    }
    public int solve(int i,int j,int[][] grid){
        if(i==grid.length||j==grid[0].length||grid[i][j]==1){
            return 0;
        }
        //
        else if((i==grid.length-1&&j==grid[0].length-1)&&grid[i][j]==0){
            
            return 1;
        }
        
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int ans=solve(i+1,j,grid)+solve(i,j+1,grid);
        return dp[i][j]=ans;
    }
}

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\


//Approach 2:O(n) space:
class Solution {
    
    
    //only difference from unique paths 1 is that..in unique path 1, if we reach the mth row or nth row , we found one of the way.
    //but here, reaching the mth row or nth col doesn't necessarily lead to an unique path..there may be obstacles in the last row or col..
    //so we have to check fot that 
    
    
    //The O(n) space solution is a bit ticky one..
    //we can't move here layer to layer..
    //we have to move here row to row.
    //first row--->then second row--> and so on..
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[] dp=new int[n];
        dp[0]=(1-obstacleGrid[0][0]);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                    
                }else if(j>0){
                    dp[j]=(obstacleGrid[i][j]!=1)?dp[j]+dp[j-1]:0;
                }
               
            }
        }
        
        return dp[n-1];
        
    }
   
}
