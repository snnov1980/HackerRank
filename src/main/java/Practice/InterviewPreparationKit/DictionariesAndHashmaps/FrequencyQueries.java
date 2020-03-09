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


public class FrequencyQueries {
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> tempArray = new ArrayList<Integer>();
		for(List<Integer> temp : queries) {
			if((temp.get(0))==1) {
				tempArray.add(temp.get(1));
			}else if((temp.get(0))==2) {
				tempArray.remove(temp.get(1));
			}else if((temp.get(0))==3) {
				if(tempArray.size()>0) {
					Set<Integer> distinct = new HashSet<>(tempArray);
					output.add(0);
					for(Integer i : distinct) {
						if(Collections.frequency(tempArray, i)==temp.get(1)) {
							output.remove(output.size()-1);
							output.add(1);
							break;
						}
					}	
				}else {
					output.add(0);
					continue;
				}
			}
		}
		
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
