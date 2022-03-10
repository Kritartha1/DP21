https://leetcode.com/problems/triangle/
//Approach 1 and approach 2 are discussed

//Approach 1: time complexity more..

class Solution {
    int infinity=(int)1e9;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        //at each box,we will store the min falling sum upto that box
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int k=triangle.get(i).get(j);
                triangle.get(i).set(j,k+Math.min(Dist(i-1,j,n,i,triangle),Dist(i-1,j-1,n,i,triangle)));
                
            }
        }
        
        int ans=infinity;
        for(int a:triangle.get(n-1)){
            ans=Math.min(a,ans);
        }
        return ans;
        
    }
    
    public int Dist(int r,int c,int n,int m,List<List<Integer>> triangle){
        if(r<0||c<0||c>r){
            return infinity;
        }
        return triangle.get(r).get(c);
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Approach 2:least time complexity

class Solution {
   
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        //at each box,we will store the min falling sum upto that box
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int k=triangle.get(i).get(j);
                triangle.get(i).set(j,k+Math.min(Dist(i+1,j,n,i,triangle),Dist(i+1,j+1,n,i,triangle)));
                
            }
        }
        
       return triangle.get(0).get(0);
        
    }
    
    public int Dist(int r,int c,int n,int m,List<List<Integer>> triangle){

        return triangle.get(r).get(c);
    }
}
