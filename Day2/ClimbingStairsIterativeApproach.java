class Solution {
    
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int a=1,b=2;
        while(n-->2){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
        
    }
}
