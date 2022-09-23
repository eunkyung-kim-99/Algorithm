import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int maxSizeOfOneArea = 0;
    boolean[][] v;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int[] answer = new int[2];
     	v = new boolean[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[0].length; j++) {
				if (picture[i][j] != 0 && !v[i][j]) {
					numberOfArea++;
					bfs(i, j, picture[i][j], picture);
				}
			}
		}
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void bfs(int r, int c, int size, int[][] picture){
Queue<int[]> queue = new LinkedList<int[]>();
		int count = 1;
		queue.add(new int[] { r, c });
		v[r][c] = true;

		while (!queue.isEmpty()) {
			int[] cu = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cu[0] + dx[d];
				int nc = cu[1] + dy[d];
				if (nr >= 0 && nr < picture.length && nc >= 0 && nc < picture[0].length) {
					if (picture[nr][nc] == size && !v[nr][nc]) {
						count++;
						v[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}
		maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
    }
}