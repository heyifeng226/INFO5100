
public class Question1 {
	public static void main(String[]args) {
		Course c1=new Course("Java");
		Student s1=new Student("Stu1",1);
		Student s2=new Student("Stu2",2);
		Student s3=new Student("Stu3",3);
		Student s4=new Student("Stu4",4);
		Student s5=new Student("Stu5",5);
		Student s6=new Student("Stu6",6);
		Student s7=new Student("Stu7",7);
		Student s8=new Student("Stu8",8);
		Student s9=new Student("Stu9",9);
		Student s10=new Student("Stu10",10);
		Student s11=new Student("Stu11",11);
		c1.registerStudent(s1);
		c1.registerStudent(s2);
		c1.registerStudent(s3);
		c1.registerStudent(s4);
		c1.registerStudent(s5);
		c1.registerStudent(s6);
		c1.registerStudent(s7);
		c1.registerStudent(s8);
		c1.registerStudent(s9);
		c1.registerStudent(s10);
		//test course is full situation
		c1.registerStudent(s11);
		
		
	}

}

class Student{
	String name;
	int id;
	
	//constructor
	Student(String name,int id){
		this.name=name;
		this.id=id;		
	}
	//set up name
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name=name;
	}
	//set up id
	int getID() {
		return id;
	}
	void setID(int id) {
		this.id=id;
	}
	
}

class Course{
	String title;
	int numberOfStudent;
	/*
	 * store registered students in students which is an array
	 * A course can have a maximum number of 10 students
	 */
	Student[]students=new Student[10];
	
	//constructor
	Course(String title) {
		this.title=title;
	}
	//set up title
	String getTitle() {
		return title;
		}
	void setTitle(String title) {
		this.title=title;
	}
	//set up numberOfStudent
	int getnumberOfStudent() {
		return numberOfStudent;
	}
	void setnumberOfStudent(int numberOfStudent) {
		this.numberOfStudent=numberOfStudent;
	}

	public Student[]getStudents(){
		return students;
	}
		
	public boolean isFull() {
		if(numberOfStudent==10) {
			return true;
		}else {
			return false;
		}
	}
	
	public void registerStudent(Student student) {
		if(!isFull()) {
			for (int i=0; i<students.length;i++)
			students[i]=student;
			numberOfStudent++;
			System.out.println(student.getName()+" successfully redistered "+getTitle());
			
		}else {
			System.out.println("Cousre is full!");
		}
	}
	
}