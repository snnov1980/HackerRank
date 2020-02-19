package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RansomNote {
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> noteMap = new TreeMap<>();
		Map<String, Integer> magazineMap = new TreeMap<>();
		String sCanReplicate = "Yes";

		for (String temp : magazine) {
			int count = 0;
			if (magazineMap.containsKey(temp)) {
				count = magazineMap.get(temp);
				count++;
				magazineMap.put(temp, count);
			} else {
				count++;
				magazineMap.put(temp, count);
			}
		}
		
		System.out.println(magazineMap);
		
		for (String temp : note) {
			Integer count = magazineMap.get(temp);
			if (count == null || magazineMap.get(temp) == 0) {
				sCanReplicate = "No";
				break;
			} else {
				magazineMap.put(temp, count-1);
			}
		}

		System.out.println(noteMap);


		/*
		 * Set<Map.Entry<String, Integer>> noteSet = noteMap.entrySet();
		 * Set<Map.Entry<String, Integer>> magazineSet = magazineMap.entrySet();
		 * 
		 * if (magazineSet.containsAll(noteSet)) {
		 * 
		 * sCanReplicate = "Yes"; } else { sCanReplicate = "No"; }
		 */

		/*
		 * for(Map.Entry<String, Integer> noteEntry : noteSet) {
		 * if(sCanReplicate.equalsIgnoreCase("Yes")) { for(Map.Entry<String, Integer>
		 * magazineEntry : magazineSet) {
		 * if(noteEntry.getKey().equals(magazineEntry.getKey()) && noteEntry.getValue()
		 * == magazineEntry.getValue()) { sCanReplicate = "Yes"; continue; }else {
		 * sCanReplicate = "No"; continue; } } }else { break; } }
		 */

		System.out.println(sCanReplicate);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please enter 1st line data:");
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];
		System.out.println("Please enter 2nd line data:");
		String[] magazineItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];
		System.out.println("Please enter 3rd line data:");
		String[] noteItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		Instant first = Instant.now();

		checkMagazine(magazine, note);

		Instant second = Instant.now();

		long duration = Duration.between(first, second).toMinutes();
		System.out.println(duration);

		scanner.close();
	}
}
