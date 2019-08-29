package main.java.Practice.InterviewPreparationKit.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {
	static void minimumBribes(int[] q) {
		int totalBribesOcc = 0;		
		int temp;
		for(int i=0; i<q.length; i++) {
			int memBribe = 0;
			for(int j=i+1; j<q.length; j++) {
				if(q[i]>q[j]) {
					memBribe++;
					continue;
				}
			}
			if(memBribe<3) {
				for(int o =i+1; o<q.length; o++) {
					if(q[i]>q[o]) {
						totalBribesOcc++;
						temp = q[i];
						q[i] = q[o];
						q[o] = temp;						
					}
				}
			} else {
				i = q.length;
				System.out.println("Too chaotic");
			}
		}
		System.out.println(totalBribesOcc);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}

}
