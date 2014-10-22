package assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
/*
 * Sets the questions and answers by file or user input
 */
public class Questions {
	private ArrayList<state> QA = new ArrayList<state>();
	/*
	 * state has a question and answer
	 */
	class state{
		private String question;
		private ArrayList<Character> answers;
		public state(String questions, ArrayList<Character> answers){
			this.question=questions;
			this.answers=answers;
		}public String getQuestion(){
			return question;
		}
		public ArrayList<Character> getAnswer(){
			return answers;
		}
		}
		private String filename = "QAs.txt";
		public void add(String question, ArrayList<Character> answers){
			if(question!=null&&answers!=null){
				QA.add(new state(question, answers));
				try
				{
				    FileWriter fw = new FileWriter(filename,true); 
				    fw.write("\n"+question+"\n"+answers);
				    fw.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
			}
		}
		
	@SuppressWarnings({ "unused" })
	public Questions(){
		String q=null, a=null;
		BufferedReader br;
		try{
			br = new BufferedReader(new FileReader(filename));
			q = br.readLine();
			while (notAsked(q)&&!(q==null)) {
				a = br.readLine();
				StringTokenizer st = new StringTokenizer(a);
				ArrayList<Character> answers = new ArrayList<Character>();
				int index=0;
				while(st.hasMoreTokens()){

					StringTokenizer st2 = 
							new StringTokenizer(st.nextToken(), "[],");
					answers.add(st2.nextToken().charAt(0));
				}
				if(q!=null && answers!=null){
				QA.add(new state(q, answers));}
				q=br.readLine();
			}
		}
		catch (IOException e){
			e.getMessage();
		}
	}
	private Boolean notAsked(String readLine) {
		if(QA.contains(readLine)){
			return false;
		}
		return true;
	}
	public state getARandQ(){
		state q=null;
		Random rn = new Random(System.currentTimeMillis());
		q=QA.get(rn.nextInt(QA.size()));
		return q;
	}
}
