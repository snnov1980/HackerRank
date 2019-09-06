package main.java.Practice.InterviewPreparationKit.Arrays;

import java.io.IOException;
import java.util.Scanner;

public class NewYearChaos {
	static void minimumBribes(int[] q) {
		int toatlBribe = 0;
		for (int i= q.length-1; i>=0; i--) {
			if(q[i]-(i+1)>2) {
				System.out.println("Too chaotic");
				return;
			}
			for(int j= Integer.max(0, q[i]-2); j<i; j++) {
				if(q[j]>q[i]) toatlBribe++;
			}
		}
		System.out.println(toatlBribe);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];
			
			String[] qItems = scanner.nextLine().split(" ");
			//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}
		scanner.close();
	}

}
