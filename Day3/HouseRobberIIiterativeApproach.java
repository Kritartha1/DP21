class Solution {
    
     public int rob(int[] nums) {
        int n=nums.length;
        int n1=n;
		//////////////////
		//a=0 implies n<0 case of the top down approach.
		//b=0 implies nums[0]=0 to avoid adding house number 0
       int a=0,b=0;
        int i=1;
        while(n-->1){
            int temp=b;
          
            b=Math.max(nums[i]+a,temp);
            a=temp;
            i++;
        }
		
		/////////////////
		
		//////////////////////////
		//c=0 implies n<0 case of the top down approach.
		//d=nums[0] implies house 0 is taken..it's value should be taken into account..
		//but this time, the last house that gets robbed is house n-2..
		//so the loop is made to run n-2 times
        i=1;
         int c=0,d=nums[0];
        while(n1-->2){
            int temp=d;
          
            d=Math.max(nums[i]+c,temp);
            c=temp;
            i++;
        }
		////////////////////////////
        return Math.max(b,d);
        
    }
}



