//leetcode.com/problems/minimum-falling-path-sum/
class Solution {
    int infinity=(int)1e9;
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //at each box,we will store the min falling sum upto that box
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]+=Math.min(Dist(i-1,j-1,n,m,matrix),Math.min(Dist(i-1,j,n,m,matrix),Dist(i-1,j+1,n,m,matrix)));
                
            }
        }
        
        int ans=infinity;
        for(int j=0;j<m;j++){
            ans=Math.min(matrix[n-1][j],ans);
        }
        return ans;
        
    }
    
    public int Dist(int r,int c,int n,int m,int[][] matrix){
        if(r<0||r>=n||c<0||c>=m){
            return infinity;
        }
        return matrix[r][c];
    }
}
