package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyQueries {
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> output = new ArrayList<Integer>();
		Map<Integer, Integer> dataMap = new HashMap<>();
		Map<Integer, Integer> freq = new HashMap<>();
		for (List<Integer> temp : queries) {
			if ((temp.get(0)) == 1) {
				Integer currFreq = dataMap.get(temp.get(1));
				if(currFreq==null) {
					currFreq = 0;
				}
				dataMap.put(temp.get(1), currFreq+1);
				if(currFreq+1>1) {
					freq.put(currFreq, freq.get(currFreq)-1);
				}
				
				Integer newFreqCount = freq.get(currFreq + 1);
	            freq.put(currFreq + 1, newFreqCount == null ? 1 : newFreqCount + 1);
				
			} else if ((temp.get(0)) == 2) {
				
				Integer currFreq = dataMap.get(temp.get(1));
				if (currFreq != null && currFreq > 0) {
					dataMap.put(temp.get(1), currFreq - 1);

	                if (currFreq - 1 > 0) {
	                    freq.put(currFreq - 1, freq.get(currFreq - 1) + 1);
	                }

	                freq.put(currFreq, freq.get(currFreq) - 1);
	            }
				
			} else if ((temp.get(0)) == 3) {
				
				Integer count = freq.get(temp.get(1));
				if(count != null && count >0) output.add(1);
				else output.add(0);
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
