//leetcode.com/problems/pascals-triangle-ii/submissions/

//Extra space approach:

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer>temp=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();
        temp2.add(1);
        
        temp.add(1);
        
        //In Pascal's triangle, each number is the sum of the two numbers directly above 
        for(int i=1;i<=rowIndex;i++){
            
            temp=new ArrayList<>(temp2);
            temp2=new ArrayList<>();
            
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    temp2.add(1);
                    continue;
                }
               
                int num=temp.get(j-1)+temp.get(j);
                
                temp2.add(num);
                
            }
             
        }
        return temp2;
        
    }
}

//*******************************************************************************************************************************************************************************
//Best appraoch:
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        
        ans.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=i-1;j>=1;j--){
                ans.set(j,ans.get(j)+ans.get(j-1));
            }
            ans.add(1);
        }
        return ans;
        
    }
}
