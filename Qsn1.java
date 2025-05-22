
class Student{
	private int studentId;
	private String name;
	private int daysAttended;
	
	Student(int studentId,String name,int daysAttended){
		this.studentId=studentId;
		this.name=name;
		this.daysAttended=daysAttended;
	}
	
	int getStudentId(){
		return studentId;
	}
	
	String getName(){
		return name;
	}
	
	int getDaysAttended(){
		return daysAttended;
	}
	
	public void setDaysAttended(int daysAttended){
		this.daysAttended=daysAttended;
	}
	
	public void displayDetails(){
		System.out.println(studentId+"\t\t"+name+"\t\t"+daysAttended);
	}
	
}

class Classroom{
	private Student[] students;
	private static int StudentCount;
	
	public Classroom(){
		this.students = new Student[10];
		this.StudentCount=0;
		}
		
	
	public void addStudent(Student student){
		if(StudentCount<10){
			students[StudentCount++]=student;
			System.out.println(student.getName()+" added to the classroom.");
		}
		else{
			System.out.println("Student registry is full.");
		}
	}
	
	public void updateAttendence(int studentId,int newAttendance){
		System.out.println(" ");
		for(int i=0;i<StudentCount;i++){
			if(students[i].getStudentId()==studentId){
				students[i].setDaysAttended(newAttendance);
				System.out.println("Student attendence updated");
				return;
			}
		}
		System.out.println("Student ID "+studentId+" not found.");
	}
	
	public void displayAllStudents(){
		if(StudentCount==0){
			System.out.println("No students in the classroom yet.");
		}
		else{
			System.out.println("\n               Student details");
			System.out.println("StudentID\tStudent Name \t   Attendance");
			for(int i=0;i<StudentCount;i++){
				students[i].displayDetails();
			}
		}
	}
}
	

class Main{
	public static void main(String[] args){
		Classroom c1=new Classroom();
		c1.addStudent(new Student(101,"Alice Smith",12));
		c1.addStudent(new Student(102,"Bob Jones",15));
		c1.addStudent(new Student(103,"Carol Lee",10));
		c1.updateAttendence(102,16);
		c1.updateAttendence(104,20);
		c1.displayAllStudents();
	}
}
