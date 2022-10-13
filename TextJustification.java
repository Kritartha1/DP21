//Logic: no of spaces in a sentence must be greater than or equal to (number of words in the sentence -1 )

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        solve(words,0,maxWidth,ans);
        return ans;
    }
    
    void solve(String[] words,int i,int maxWidth,List<String> ans){
        if(i==words.length){
            return;
        }
        
        int len=0;
        int j;
        int prev=0;
        boolean flag=true;
        for(j=i;j<words.length;j++){
            prev=len;
            len+=words[j].length();
            if(maxWidth-len<(j-i)){
                flag=false;
                break;
            }
        }
        
        if(!flag){
              len=prev; 
        }       
        String a="";
        if(j==words.length){
            for(int k=i;k<j-1;++k){
                a+=words[k]+" ";
            }
            a+=words[j-1];
            len=maxWidth-a.length();
            while(len--!=0){
                a+=" ";
            }
        }
        else{
            int r;
            int space;
            if(j==i+1){//means only one word in the sentence
                space=(maxWidth-len);
            }else{
                space=(maxWidth-len)/((j-i)-1);
            }
            
           
            String s="";
            for(int t=0;t<space;++t){ 
                   s+=" ";
            }
            if(j!=(i+1)){
                
               r=(maxWidth-len)%((j-i)-1);
               int t=0;
               for(int k=i;k<j-1;k++){
                   
                   a+=words[k]+s;
                   if(t<r){
                       a+=" ";
                   }
                   ++t;
               }
                a+=words[j-1];
            }else{
                a+=words[j-1]+s;
            }  
           }
           
        //System.out.println(a);
           ans.add(a);
           solve(words,j,maxWidth,ans);
        
    }
}
