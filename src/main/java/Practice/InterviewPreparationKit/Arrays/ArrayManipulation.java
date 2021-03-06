package main.java.Practice.InterviewPreparationKit.Arrays;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ArrayManipulation {
	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long largestArrayValue = Long.MIN_VALUE;
		long sum = 0;

		long[] arrayOfZeros = new long[n+1];

		for (int i = 0; i < queries.length; i++) {
			int leftIndex = queries[i][0];
			int rightIndex = queries[i][1];
			int summand = queries[i][2];
			
			arrayOfZeros[leftIndex-1] += summand;
			arrayOfZeros[rightIndex] -= summand;
			
		}

		for (int i = 0; i < n; i++) {
			sum += arrayOfZeros[i];
			largestArrayValue = Math.max(sum, largestArrayValue);
		}

		return largestArrayValue;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
