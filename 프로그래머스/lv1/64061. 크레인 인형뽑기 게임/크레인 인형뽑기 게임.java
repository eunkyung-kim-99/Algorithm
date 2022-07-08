import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < moves.length; i++) {
			int n = 0;
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					n = board[j][moves[i] - 1];
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
			if (n != 0) {
				if (tmp.size() != 0 && tmp.get(tmp.size() - 1) == n) {
					tmp.remove(tmp.size() - 1);
					answer += 2;
				} else {
					tmp.add(n);
				}
			}
		}
		return answer;
	}
}