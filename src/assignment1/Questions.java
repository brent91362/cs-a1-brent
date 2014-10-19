package assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Questions {
	private ArrayList<node> QA = new ArrayList<node>();
	class node{
		private String question;
		private ArrayList<Character> answers;
		public node(String questions, ArrayList<Character> answers){
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
				QA.add(new node(question, answers));
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
		
	@SuppressWarnings({ "unused", "null" })
	public Questions(){
		String q=null, a=null;
		BufferedReader br;
		try{
			br = new BufferedReader(new FileReader("questions.txt"));
			while (notAsked(br.readLine())) {
				q = br.readLine();
				a = br.readLine();
				StringTokenizer st = new StringTokenizer(a);
				ArrayList<Character> answers = null;
				int index=0;
				while(st.hasMoreTokens()){
					answers.add(st.nextToken().charAt(0));
				}
				if(q!=null && answers!=null){
				QA.add(new node(q, answers));}
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
	public node getARandQ(){
		node q=null;
		Random rn = new Random(System.currentTimeMillis());
		q=QA.get(rn.nextInt(QA.size()));
		return q;
	}
}
