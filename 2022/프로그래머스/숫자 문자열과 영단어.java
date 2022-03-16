class Solution {
    public static String[] number_list = 
    {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public int solution(String s) {
        int number_len = s.length();
        String result = "";
        String str_temp ="";
        for(int i=0; i< number_len ; i++){
            char char_temp = s.charAt(i);
            //System.out.println(char_temp);
            if(char_temp > 64){
                str_temp+=char_temp;
               // System.out.println("-----------------str_temp ----- "+str_temp);
                for(int j=0; j< 10;j++){
                    if(str_temp.equals(number_list[j])){  
                         //System.out.println("str_temp ----- "+str_temp);
                        result+=j;
                        str_temp = "";
                        break;
                    }
                }
                
            }else{
                 //System.out.println("char_temp ------ "+char_temp);
                result+=char_temp;
            }
            
        }
        
        System.out.println(result);
        int answer = Integer.parseInt(result);
        return answer;
    }
}




