

import java.util.*;

class Studdent{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	Studdent(){
		
	}
	
	Studdent(String name,int exam1,int exam2,int exam3)throws Exception{
		this.name=name;
		if(validateMarks(exam1)&&validateMarks(exam2)&&validateMarks(exam3)){
			this.exam1=exam1;
			this.exam2=exam2;
			this.exam3=exam3;
		}
		else{
			System.out.print("Exam scores must be between 0 and 100.");
			throw new Exception("Invalid Marks");
		}
	}
	
	String getName(){
		return name;
	}
	
	int getExam1(){
		return exam1;
	}
	
	int getExam2(){
		return exam2;
	}
	
	int getExam3(){
		return exam3;
	}
	
	public boolean validateMarks(int marks){
		if(marks<=100 && marks>=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public double averageCal(int exam1,int exam2,int exam3){
		int sum=exam1+exam2+exam3;
		double avg=sum/3;
		return avg;
	}
	
}

class Main{
	public static void main(String[] args){
		Studdent s1,s2;
		try{
			s1=new Studdent("Adam",100,80,55);
			s2=new Studdent("Edam",99,88,75);
			System.out.println("Name of the student 1 is "+s1.getName());
			System.out.println("Student 1's Exam1 result is "+s1.getExam1());
			System.out.println("Student 1's Exam2 result is "+s1.getExam2());
			System.out.println("Student 1's Exam3 result is "+s1.getExam3());
			System.out.println("Student 1's Exam average is "+s1.averageCal(s1.getExam1(),s1.getExam2(),s1.getExam3()));
			
			System.out.println("Name of the student 2 is "+s2.getName());
			System.out.println("Student 2's Exam1 result is "+s2.getExam1());
			System.out.println("Student 2's Exam2 result is "+s2.getExam2());
			System.out.println("Student 2's Exam3 result is "+s2.getExam3());
			System.out.println("Student 2's Exam average is "+s2.averageCal(s2.getExam1(),s2.getExam2(),s2.getExam3()));
		
		}
		catch(Exception e){
			System.out.println("Exception is "+e.getMessage());
		}
		
		
	}
}
