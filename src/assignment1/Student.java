package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Student {
	private long students;
	private ArrayList<Character> answers;
	public Student(long students){
		this.students=students;
	}
	public void setStudents(long ids){
		students= ids;
	}
	public long getIds(){
		return students;
	}
	public void setAnswer(ArrayList<Character> ans){
		answers=ans;
	}
	public ArrayList<Character> getAnswer(){
		return answers;
	}
	public void randAnswer() {
		Random rn = new Random(System.currentTimeMillis());
		ArrayList<Character> answer=new ArrayList<Character>();
			rn = new Random();
			int numberof=rn.nextInt(4)+1, index=0;
			while(index<numberof){
				rn = new Random();
				int random= rn.nextInt(5)+'a';
				while(answer.contains((char)random)){random = rn.nextInt(5)+'a';}
				answer.add((char) random);
				index++;
				
			}
			Collections.sort(answer);
			setAnswer(answer);System.out.println(answer);
		
	}
	
}
