class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0; //세로
        while(true){
            ++x;
            if(yellow % x != 0) continue;
            int y = yellow / x; //가로
            if(brown == (y + 2) * 2 + (2 * x)){
                int[] answer = {y + 2, x + 2};
                return answer;
            }
        }
    }
}