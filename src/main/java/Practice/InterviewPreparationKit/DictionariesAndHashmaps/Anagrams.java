package main.java.Practice.InterviewPreparationKit.DictionariesAndHashmaps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
	
	static boolean check(String a,String b)
    {
        int ch[]=new int[26];
        for(int i=0;i<a.length();i++)
            ch[a.charAt(i)-97]++;
        for(int i=0;i<a.length();i++)
            ch[b.charAt(i)-97]--;
        for(int i=0;i<26;i++)
            if(ch[i]!=0)return false;
        return true;
    }
    
	static int sherlockAndAnagrams(String s) {
		int l=s.length(),c=0;
        for(int i=0;i<l;i++)
        {
            for(int j=i+1;j<=l;j++)
            {
                String a=s.substring(i,j);
                int la=a.length();
                for(int k=0;k<=l-la;k++)
                {
                    if(k!=i)
                    if(check(a,s.substring(k,k+la)))c++;
                }
            }
        }
        return c/2;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();
			int result = sherlockAndAnagrams(s);
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}
		
		bufferedWriter.close();
		scanner.close();
	}
}
