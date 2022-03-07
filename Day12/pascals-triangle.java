class Solution {
//leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        
        temp.add(1);
        ans.add(temp);
        //In Pascal's triangle, each number is the sum of the two numbers directly above 
        for(int i=1;i<numRows;i++){
            temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    temp.add(1);
                    continue;
                }
                int num=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                
                temp.add(num);
                
            }
            ans.add(temp);
        }
        return ans;
        
        
    }
}
