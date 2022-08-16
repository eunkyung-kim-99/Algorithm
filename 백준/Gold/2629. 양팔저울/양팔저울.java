import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] w = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(bf.readLine());
		int[] wb = new int[M];
		int min = 0;
		int max = 40000;
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			wb[i] = Integer.parseInt(st.nextToken());
		}
		int[] memo = new int[max + 1];
		for (int i = 0; i < w.length; i++) {
			if(w[i]<=max && memo[w[i]] == 0 ) memo[w[i]] = i+1;
			for (int j = 0; j < memo.length; j++) {
				if (w[i] == j && memo[w[i]] ==i+1) continue;
				if (memo[j]!=0 && memo[j] != i+1) {
					if (w[i] + j <= max && memo[w[i] + j]==0) memo[w[i] + j] = i+1;
					if (Math.abs(w[i] - j)<=max && Math.abs(w[i] - j) >= min && memo[Math.abs(w[i] - j)]==0) memo[Math.abs(w[i] - j)] = i+1;
				}
			}
		}
		for (int i = 0; i < wb.length; i++) {
			System.out.print((memo[wb[i]] != 0 ? "Y" : "N") + " ");
		}
	}
}
