import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (int i = N; i <= M; i++) {
			String n = i + ""; 
			String str = number[n.charAt(0) - '0'] + ""; 
			if (n.length() > 1) str += " " + number[n.charAt(1) - '0']; 
			list.add(str); 
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			st = new StringTokenizer(list.get(i)); 
			while (st.hasMoreTokens()) {
				int n = seach(st.nextToken());
				sb.append(n);
			}
			if ((i + 1) % 10 == 0) sb.append("\n"); 
			else sb.append(" ");
		}
		System.out.println(sb);

	}

	private static int seach(String nextToken) { 
		for (int i = 0; i < number.length; i++) {
			if (number[i].equals(nextToken)) return i;
		}
		return -1;
	}
}
