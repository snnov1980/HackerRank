package main.java.Practice.InterviewPreparationKit.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {
	static int[] rotLeft(int[] a, int d) {
		
		int[] temp =new int[d];
		
		for (int i=0; i<d; i++) {
			temp[i] = a[i];
		}

		for (int i = 0; i < a.length-d; i++) {
			a[i] = a[i+d];
		}
		
		for(int i =0; i<temp.length; i++) {
			a[i+(a.length-d)] = temp[i];
		}
		
		return a;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);

		for (int i = 0; i < result.length; i++) {
			System.out.print(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}

		scanner.close();
	}
}
