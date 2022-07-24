import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = 0;
		if (a > 0) {
			if (b > 0) {
				n = 1;
			} else {
				n = 4;
			}
		} else {
			if (b > 0) {
				n = 2;
			} else {
				n = 3;
			}
		}
		System.out.println(n);
	}
}
