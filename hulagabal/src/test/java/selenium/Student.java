package selenium;

public class Student {
	int rollno;
	String name;
	String city;
	
	public Student(int rollno,String name, String city) {
		this.rollno=rollno;
		this.name=name;
		this.city=city;
	
	}
	
	public void divide(){
		int x = 0;
		try {
			x = 100/10;
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
		System.out.println(x);
	}
	
	public String toString(){
		return rollno+" "+name+" "+city;
	}
	
	public static void main(String[] args) {
		Student student=new Student(1, "Muttu", "Vijayapura");
		student.divide();
	}

}
