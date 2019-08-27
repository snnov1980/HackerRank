package main.java.Practice.InterviewPreparationKit.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArrayDS {
	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int sum = -99999;
    	
    	int[][] hourglasses = new int[4][4];
    	for (int i=0; i<4; i++) {
    		for (int j=0; j<4; j++) {
    			hourglasses[i][j] = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
    		}
    	}
    	
    	for (int i=0; i<4; i++) {
    		for (int j=0; j<4; j++) {
    			if(sum < hourglasses[i][j]) {
    				sum = hourglasses[i][j];    				
    			}
    		}
    	}
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

        scanner.close();
    }
}
