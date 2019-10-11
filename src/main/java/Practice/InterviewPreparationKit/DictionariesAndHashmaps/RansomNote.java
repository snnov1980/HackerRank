package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RansomNote {
	static void checkMagazine(String[] magazine, String[] note) { 
		//HashMap<String, Integer> canReplicate =  new HashMap<>();
		//Hashtable<String, Integer> canReplicate =  new Hashtable<>();
		TreeMap<String, Integer> canReplicate = new TreeMap<>();
		
		for(String temp: note) {
			canReplicate.put(temp, 1);
		}
		
		System.out.println(canReplicate);
		
		for(String temp: magazine) {
			if(canReplicate.containsKey(temp)) {
				canReplicate.replace(temp, 0);
			}
		}
		
		String sCanReplicate = "";
		for(Map.Entry<String, Integer> entry : canReplicate.entrySet()) {
			if(entry.getValue()==0) {
				sCanReplicate = "Yes"; 
			}else sCanReplicate = "No";
		}
		
		System.out.println(sCanReplicate);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
