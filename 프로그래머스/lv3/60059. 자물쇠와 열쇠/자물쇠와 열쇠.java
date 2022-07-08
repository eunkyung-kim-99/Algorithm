import java.util.ArrayList;

class Solution {
    	public boolean solution(int[][] key, int[][] lock) {
		int cnt = 0;
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				if (lock[i][j] == 0)
					cnt++;

			}
		}
		if (cnt == 0)
			return true;

		for (int n = 0; n < 4; n++) {
			ArrayList<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < key.length; i++) {
				for (int j = 0; j < key.length; j++) {
					if (key[i][j] == 1)
						list.add(new int[] { i, j });
				}
			}

			for (int i = 0; i < lock.length; i++) {
				for (int j = 0; j < lock.length; j++) {
					if (lock[i][j] == 1)
						continue;
					if (solve_left(i, j, list, lock, cnt)) {
						return true;
					}
				}
			}

			// 90도 회전
			key = moving_90(key);

		}

		return false;
	}

	public boolean solve_left(int i, int j, ArrayList<int[]> list, int[][] lock, int cnt) {
		for (int k = 0; k < list.size(); k++) {
			int sum = 1;
			for (int z = 0; z < list.size(); z++) {
				int nr = i;
				int nc = j;
				if (k == z)
					continue;
				if (k < z) {
					nr += list.get(z)[0] - list.get(k)[0];
					nc += list.get(z)[1] - list.get(k)[1];
				} else {
					nr -= list.get(k)[0] - list.get(z)[0];
					nc -= list.get(k)[1] - list.get(z)[1];
				}
 				if (nr < 0 || nr >= lock.length || nc < 0 || nc >= lock.length)
					continue;
				if (lock[nr][nc] == 0)
					sum++;
				else
					break;
			}
			if (cnt == sum) {
				return true;
			}
		}
		return false;
	}

	public int[][] moving_90(int[][] key) {
		int[][] tmp = new int[key.length][key.length];
		int n = key.length - 1;
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				tmp[j][n] = key[i][j];
			}
			n--;
		}
		return tmp;
	}

}