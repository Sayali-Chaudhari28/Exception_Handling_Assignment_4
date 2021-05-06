import java.util.Scanner;
import java.lang.Math;

//--------------------CUSTOM EXCEPTION CLASS-------------------
class Eligible extends Exception{
	public Eligible(String s) {
		super(s);
	}
}

//---------------------STUDENT CLASS---------------------------
class Student{
	Scanner sc = new Scanner(System.in);
	float sub1,sub2,sub3;
	int roll_no;
	String stud_name;
//-----------------------ACCEPTING DATA-------------------------
	void accept() {
		System.out.print("Enter roll no: ");
		roll_no=sc.nextInt();
		System.out.print("Enter sub 1 marks: ");
		sub1=sc.nextInt();
		System.out.print("Enter sub 2 marks: ");
		sub2=sc.nextInt();
		System.out.print("Enter sub 3 marks: ");
		sub3=sc.nextInt();
	}
//----------------------CALCULATE PERCENTAGE--------------------
	float calculate_percentage() {
		float obtained_marks;
		float percentage=0;
		obtained_marks=sub1+sub2+sub3;
		percentage=(obtained_marks/300)*100;
		return Math.round(percentage);
	}
//--------------------------COUNT ATKT--------------------------
	int atkt() {
		int no_of_atkt=0;
		if(sub1<40)
			no_of_atkt++;
		if(sub2<40)
			no_of_atkt++;
		if(sub3<40)
			no_of_atkt++;
		return no_of_atkt;
	}
//--------------------------DISPLAY INFORMATION-----------------
	void display() {
		System.out.print("\n     "+roll_no+"    |   "+Math.round(sub1)+"   |   "+Math.round(sub2)+"   |   "
		+Math.round(sub3)+"   |    "+calculate_percentage()+"%    |   "+atkt()+"  | ");
	}
//----------------------CHECK ELIGIBILITY-----------------------
	void check_elegibility(int elegible, int atkt) throws Eligible {
		if(calculate_percentage()<elegible && atkt()>1) {
			throw new Eligible("");
		}
		else {
			System.out.print("Eligible");
		}
	}
}
//--------------------------MAIN CLASS--------------------------
public class Exception_Handling {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int eligibility_criteria,atkt_allowed,no_of_stud;
		
		//------------------------TAKING INFORMATION ABOUT ELIGIBILITY--------------------------------
		
		System.out.println("\n********************************RECRUITMENT PROCESS********************************\n");
		System.out.print("Enter the percentage allowed for student to be eligible: ");
		eligibility_criteria=sc.nextInt();
		System.out.print("Enter the ATKT's allowed for students: ");
		atkt_allowed=sc.nextInt();
		System.out.println("\n------------------------------------------------------------\n");
		System.out.print("Enter number of student want to register for recruitment: ");
		no_of_stud=sc.nextInt();
		
		Student student[]=new Student[no_of_stud];
		
		//-------------------------------TAKING STUDENT DETAILS---------------------------------------
		
		System.out.print("\n--------------------Enter Student details--------------------\n");
		for(int i=0;i<no_of_stud;i++) {
			System.out.println("\nEnter the "+i+" student details: ");
			student[i]=new Student();
			student[i].accept();
			System.out.println("\n-------------------------------------------------------------------------");
		}
		
		//-------------------------------DISPLAYING STUDENT DETAILS-----------------------------------
		
		System.out.println("\n----------------------Student's Eligibility details----------------------\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.print(" ROLL NO. |  SUB1  |  SUB2  |  SUB3  |  PERCENTAGE | ATKT | ELIGIBILITY");
		System.out.print("\n-------------------------------------------------------------------------");
		for(int i=0;i<no_of_stud;i++) {
			student[i].display();
			try {
				student[i].check_elegibility(eligibility_criteria, atkt_allowed);
			}
			catch(Exception e) {
				System.out.print("Not "+e);
			}
		}
		
	}
	
}
