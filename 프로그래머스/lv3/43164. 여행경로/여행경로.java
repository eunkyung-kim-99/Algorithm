import java.util.*;
class Solution {
    ArrayList<String> answer = null;
    public ArrayList<String> solution(String[][] tickets) {
        boolean[] v = new boolean[tickets.length];
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                ArrayList<String> ticket = new ArrayList<>();
                v[i] = true;
                ticket.add(tickets[i][0]);
                ticket.add(tickets[i][1]);
                dfs(tickets, ticket, v, 1);
                v[i] = false;
            }
        }
        return answer;
    }
    public void dfs(String[][] tickets, ArrayList<String> ticket, boolean[] v, int size) {
        // System.out.println(size);
        // System.out.println(ticket);
        // System.out.println(Arrays.toString(v));
       ArrayList<String> tmp = new ArrayList<>();
       tmp.addAll(ticket);
       if(size == tickets.length){
           // System.out.println("==> "+size);
           if(answer == null){
             answer = tmp;  
           } else {
               String answerStr = "";
               for(int i = 0; i < answer.size(); i++){
                  answerStr += answer.get(i);  
               }
               String tmpStr = "";
               for(int i = 0; i < tmp.size(); i++){
                  tmpStr += tmp.get(i);  
               }
               if(tmpStr.compareTo(answerStr) < 0){
                  answer = tmp;  
               }
            }
           // System.out.println(tmp);
           return;
       }
       for(int i = 0; i < tickets.length; i++){
            if(v[i]) continue;
            if(tickets[i][0].equals(tmp.get(ticket.size()-1))){
                v[i] = true;
                tmp.add(tickets[i][1]);
                dfs(tickets, tmp, v, size+1);
                tmp.remove(tmp.size()-1);
                v[i] = false;
            }
        }
        
        
    }
}