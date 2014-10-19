package assignment1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SimulationDriver {
	public static void main(String[] args) throws InterruptedException {
		Random studentNumber = new Random ();
		Questions qs=new Questions();
		int numb=studentNumber.nextInt(100);
		long SID =9000000;
		boolean cont = true;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> a=new ArrayList<Character>();
		a.add('a');
		qs.add("this is a question?", a);
		while (cont){
			ArrayList<Student> students = new ArrayList<Student>();
			for(int i =0; i<numb; i++){
				students.add(new Student(SID+i));
				students.get(i).randAnswer();
			}
			iClick service = new iClick();
			service.setStudents(students);
			service.setQA(qs.getARandQ());
			service.run();
			System.out.println("Do you want to ask another Q?");
			String continu = sc.next().toLowerCase();
			if(continu.contains("n")){
				cont=false;
			}
		}
		
	}
}