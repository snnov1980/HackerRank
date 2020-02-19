package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class TwoStrings {
	static String twoStrings(String s1, String s2) {
		String result = "No";
		HashSet<String> s1Set = new HashSet<>();
		HashSet<String> s2Set = new HashSet<>();
				
		for(String temp : s1.split("")) {
			s1Set.add(temp);
		}
		
		for(String temp: s2.split("")) {
			s2Set.add(temp);
		}
		
		for(String temp1:s2Set) {
			if(result.equalsIgnoreCase("Yes")) {
				break;
			}else {
				for(String temp2:s1Set) {
					if(temp1.equalsIgnoreCase(temp2)) {
						result = "Yes";
						break;
					}
				}
			}
		}

		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
