package assignment1;

import assignment1.Questions.node;

import java.util.ArrayList;

public class iClick {
	private ArrayList<Student> students;
	private String question;
	private ArrayList<Character> answer;
	public void setStudents(ArrayList<Student> ids){
		students= ids;
	}
	public void setQA(node x){
		setQuestion(x.getQuestion());
		answer=x.getAnswer();
	}
	public void run(){
		int right=0;
		for (int i=0; i<students.size();i++){
			if(students.get(i).getAnswer().equals(answer)){
				right++;
			}
		}
		System.out.println(right +" students were correct out of "+students.size());
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
}
