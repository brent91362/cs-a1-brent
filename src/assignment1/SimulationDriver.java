package assignment1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
 * randomly generates the number of students
 * gets a question and answer and sets it in iclick service
 * to be compared against students answers
 */
public class SimulationDriver {
	public static void main(String[] args) throws InterruptedException {
		Random studentNumber = new Random ();
		Questions qs=new Questions();
		int numb=studentNumber.nextInt(100);
	//starts student ids at 9000000 to 90000XXX
		long SID =9000000;
		boolean cont = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> a=new ArrayList<Character>();
		a.add('a');
	//add a question and answer to file
		//qs.add("this is a question?", a);
	//runs the service until user is done
		while (cont){
			ArrayList<Student> students = new ArrayList<Student>();
			for(int i =0; i<numb; i++){
				students.add(new Student(SID+i));
				students.get(i).randAnswer();
			}
			iClick service = new iClick();	
			service.setQA(qs.getARandQ());
		//sets student ids
			service.setStudents(students);
			System.out.println(service.getQuestion());
		//this student chooses an answer
			ArrayList<Character> ans = new ArrayList<Character>();
			ans.add('b');ans.add('d');
			students.get(0).setAnswer(ans);
		//sets the student's answers to service
			service.run();
			System.out.println("Do you want to ask another Q?");
			String continu = sc.next().toLowerCase();
			if(continu.contains("n")){
				cont=false;
			}
		}
		
	}
}