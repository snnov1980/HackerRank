package main.java.Practice.InterviewPreparationKit.WarmupChallenges;

public class Hello {

	public static void main(String[] args) {
		
		String s = "Hello";
		
		String p = s;
		for(int i=0; i<4; i++ ) {
			System.out.println(p);
			p += " " + s;
		}

	}

}
