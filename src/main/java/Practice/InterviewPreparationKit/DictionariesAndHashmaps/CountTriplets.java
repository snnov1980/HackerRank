package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {
	static long countTriplets(List<Long> arr, long r) {
		long count = 0;
		
		Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> rMap = new HashMap<>();
        
        for(long n:arr) {
        	if(n%r == 0) {
        		long pre = n/r;
        		Long cnt2 = rMap.get(pre);
        		if(cnt2 != null) count += cnt2;
        		
        		Long cnt1 = map.get(pre);
        		if(cnt1!=null) rMap.put(n, rMap.getOrDefault(n, 0L)+cnt1);
        	}
        	map.put(n, map.getOrDefault(n, 0L)+1);
        }
		
		/*
		 * Collections.sort(arr);
		 * 
		 * 
		 * for (int i=0; i<arr.size()-2; i++) { for(int j=i+1; j<arr.size()-1;j++) {
		 * for(int k =j+1; k<arr.size(); k++) { if(arr.get(j)==arr.get(i)*r &&
		 * arr.get(k)==arr.get(j)*r) { count++; } System.out.println(arr.get(i) + " " +
		 * arr.get(j) + " " + arr.get(k)); } } }
		 */
		return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong).collect(toList());
        
        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
