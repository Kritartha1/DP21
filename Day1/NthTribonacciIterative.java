class Solution {
    public int tribonacci(int n) {
        
        if(n<=1){
            return n;
        }
        
        int a=0,b=1,c=1;
        while(n-->2){
          int temp=a+b+c;
          a=b;
          b=c;
          c=temp;
        }
        return c;
        
    }
}
