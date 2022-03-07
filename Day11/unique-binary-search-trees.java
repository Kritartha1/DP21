class Solution {
    public int numTrees(int n) {
        //leetcode.com/problems/unique-binary-search-trees/submissions/
        //Explanation://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
        
        //BST: all nodes in the left sub tree is smaller than the root node.
        //all nodes to the right is greater than the root..
        //similar can be said to all the parent nodes.
        int[] BST=new int[n+1];
        BST[0]=1;
        BST[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                //root at j
                BST[i]+=(BST[j-1])*BST[i-j];
            }
        }
        
        return BST[n];
    }
}
