package main.java.Practice.InterviewPreparationKit.Sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BubbleSort {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
    	int numSwaps = 0;
    	int firstElement;
    	int lastElement;
    	
    	for (int i = 0; i < a.length; i++) {
    		firstElement = a[i];
    		lastElement = a[a.length-1];
    	    for (int j = 0; j < a.length - 1; j++) {
    	        if (a[j] > a[j + 1]) {
    	        	
    	        	
    	        }
    	    }
    	    
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
