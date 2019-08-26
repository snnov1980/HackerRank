package main.java.Practice.InterviewPreparationKit.WarmupChallenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {
	
	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long count = 0;        	
    	String finalString = s;
    	
		if((s.length()==1) && s.equalsIgnoreCase("a")) {
			count = n;
		}else if((s.length()==1) && !(s.equalsIgnoreCase("a"))) {
			count = 0;
		}else {
			for(long i=0; finalString.length()<(long)n; i++) {
				finalString += finalString.valueOf(i);
			}
			Pattern pattern = Pattern.compile("a");
			Matcher matcher = pattern.matcher(finalString);
			while(matcher.find()) {
				count++;						
			}			
		}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }

}
