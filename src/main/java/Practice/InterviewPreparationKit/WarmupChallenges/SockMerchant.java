package main.java.Practice.InterviewPreparationKit.WarmupChallenges;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        HashSet<Integer> colors = new HashSet<>();
        for(int i=0; i<n; i++){
            colors.add(ar[i]);
        }
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(Integer color : colors){
        	int count = 0;
        	for(int i=0; i<n; i++) {
        		if(color == ar[i]) {
        			count++;
        		}
        	}
        	hmap.put(color, count);
        }
        for(Integer temp : hmap.keySet()) {
        	Integer count = hmap.get(temp);
        	if (count > 1) {
        		int pair = count/2;
        		pairs += pair;
        	}
        	//System.out.println("Color: " + temp + ", count: " +  count);
        }
		return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //String OUTPUT_PATH = ""
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
