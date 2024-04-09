package com.supre.Task2_StudentGradeCalculator;

//importing the Scanner Class from java.util package
import java.util.Scanner;

public class StudentGradeCalculator 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("STUDENT GRADE CALCULATOR");
		System.out.println("-------------------------");
		
		//Input for Student Name
		System.out.println("Enter the Student's Name: ");
		String stuName = scan.nextLine();
		
		//Input the number of Subjects
		System.out.println("Enter the number of Subjects: ");
		int numSubjects = scan.nextInt();
		
		//calculating the Total Marks of the Student
		double totalMarks = 0.0;
		for(int i=1;i<=numSubjects;i++)
		{
			System.out.println("Enter the Subject "+i+" marks: ");
			double subjectMarks = getValidMarks(scan);
			totalMarks += subjectMarks;
		}
		
		//calculating the average marks of the Student
		double avgMarks = totalMarks/numSubjects;
		
		//calculate grade based on the average marks
		String grade = calculateGrade(avgMarks);
		
		//Display the Result
		System.out.println("\n-----Students Result-----");
		System.out.println("Student Name : "+stuName);
		System.out.println("Total Marks : "+totalMarks);
		System.out.println("Average Marks : "+avgMarks);
		System.out.println("Grade : "+grade);
		//close the Scanner
		scan.close();
		
	}
	
	//method to check input marks is valid or not
	public static double getValidMarks(Scanner scan) 
	{
		double marks = -1;
		while(marks < 0 || marks > 100)
		{
			System.out.println("\tEnter the valid marks(0 - 100): ");
			marks = scan.nextDouble();
			if(marks < 0 || marks > 100)
				System.out.println("Invalid marks...Please enter the valid marks(0 -100): ");
		}
		return marks;
	}
	
	//method to calculate the Grade using Average marks of all the Subjects
	public static String calculateGrade(double avgMarks)
	{
		if(avgMarks > 95)
			return "S";
		else if(avgMarks > 90)
			return "A+";
		else if(avgMarks > 80)
			return "A";
		else if(avgMarks > 70)
			return "B";
		else if(avgMarks > 60)
			return "C";
		else if(avgMarks >=50)
			return "D";
		else
			return "F";
	}
}
