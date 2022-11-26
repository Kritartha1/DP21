//leetcode.com/problems/maximum-profit-in-job-scheduling/
class Solution {
    
    int[] dp;
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n=profit.length;
        ArrayList<int[]> l=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            l.add(new int[]{startTime[i],endTime[i],profit[i]});
            
        }
        
        
        Collections.sort(l,new Comparator<>(){
            public int compare(int[] o,int[] p){
                return o[0]-p[0];
            }
        });
        
       
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(l,0);
    }
    
    int solve(ArrayList<int[]> l,int i){
        if(i>=l.size()){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        int temp=0;

          temp=Math.max(l.get(i)[2]+solve(l,findNext(l.get(i)[1],l,i)),solve(l,i+1))  ;
            
       
        return dp[i]=temp;
        
    }
    int findNext(int end,ArrayList<int[]> l,int i){
        int L=i+1;
        int j=l.size();
        while(L<j){
            int mid=L+(j-L)/2;
            if(l.get(mid)[0]>=end){
                j=mid;
            }else{
                L=mid+1;
            }
        }
        return L;
        
        // for(int j=i+1;j<l.size();j++){
        //     if(l.get(j)[0]>=end){
        //         return j;
        //     }
        // }
        // return l.size();
    }
}
