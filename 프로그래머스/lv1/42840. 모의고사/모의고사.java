import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[][] people = {{1, 2, 3, 4, 5},
                          {2, 1, 2, 3, 2, 4, 2, 5},
                          {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        ArrayList<Integer> answer = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < people.length; i++){
            int p = 0;
            int count = 0;
            for(int j = 0; j < answers.length; j++){
                p %= people[i].length;
                if(answers[j] == people[i][p]){
                    count++;
                }
                p++;
            }
            if(count > max){
                max = count;
                answer.clear();
                answer.add(i+1);
            } else if (count == max){
                answer.add(i+1);
            }
        }
        if(answer.size() > 1){
            Collections.sort(answer);
        }
        return answer;
    }
}