import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Horse {
		int p, s, e;

		public Horse(int p, int s, int e) {
			super();
			this.p = p;
			this.s = s;
			this.e = e;
		}
	}

	static int[] map = new int[41];
	static int[] arr = new int[10];

	static int max, count;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		Horse[] horse = new Horse[4];
		for (int i = 0; i < horse.length; i++) {
			horse[i] = new Horse(0, 0, 0);
		}

		map[10] = 13;
		map[13] = 16;
		map[16] = 19;
		map[19] = 25;
		map[20] = 22;
		map[22] = 24;
		map[24] = 25;
		map[30] = 28;
		map[28] = 27;
		map[27] = 26;
		map[26] = 25;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		play(horse, 0, 0);
		System.out.println(max);

	}
	private static void play(Horse[] horse, int index, int sum) {
		if (index == arr.length) {
			max = Math.max(max, sum);
			return;
		}

		int origin_p = 0;
		int origin_s = 0;
		int origin_e = 0;

		for (int i = 0; i < horse.length; i++) {
			if (horse[i].p == -1)
				continue;
			origin_p = horse[i].p;
			origin_s = horse[i].s;
			origin_e = horse[i].e;
			for (int j = 1; j <= arr[index]; j++) {
				if (horse[i].s == 0) {
					if (horse[i].e == 1) {
						horse[i].p += 5;
					} else {
						horse[i].p += 2;
					}
				} else {
					horse[i].p = map[horse[i].p];
					if (horse[i].p == 25) {
						horse[i].s = 0;
						horse[i].e = 1;
					}
				}
				if (horse[i].p > 40) {
					horse[i].p = -1;
					break;
				}
			}

			boolean state = true;
			if (horse[i].p == 10 || horse[i].p == 20 || horse[i].p == 30) {
				if (horse[i].e != 1)
					horse[i].s = 1;
			}
			if (horse[i].p != -1) {
				for (int j = 0; j < horse.length; j++) {
					if (i == j)
						continue;
					if (horse[j].p == horse[i].p) {
						if (horse[j].s == horse[i].s && horse[j].e == horse[i].e) {
							state = false;
							break;
						}
						if (horse[i].p == 40) {
							state = false;
							break;
						}
					}
				}
			}
			if (state) {
				play(horse, index + 1, horse[i].p == -1 ? sum : sum + horse[i].p);
			}
			horse[i].p = origin_p;
			horse[i].s = origin_s;
			horse[i].e = origin_e;
		}
	}
}
