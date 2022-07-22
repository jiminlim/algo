import java.util.*;

public class pro_오픈채팅방 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
    public static String[] solution(String[] record) {
        int record_len = record.length;
        HashMap<String,String> map = new HashMap<String, String>() ;
        //아이디별 닉네임
        for(int i=0; i < record_len; i++){
            //System.out.println(record[i]);
            String[] rec = record[i].split(" ");

            if(!rec[0].equals("Leave") ){
                map.put(rec[1],rec[2]);
            }
        }
        //result 출력
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i < record_len; i++){
            String[] rec = record[i].split(" ");
            String result =map.get(rec[1]);

            if(rec[0].equals("Leave") ){
                result += "님이 나갔습니다.";
            }else if(rec[0].equals("Enter")){
                result += "님이 들어왔습니다.";
            }else{
                continue;
            }
            list.add(result);
        }

        return list.toArray(new String[list.size()]);
    }
}
