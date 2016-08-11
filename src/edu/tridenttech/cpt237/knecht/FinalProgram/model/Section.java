package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import java.util.ArrayList;
import java.util.Observable;

public class Section extends Observable
{
	private int maxStudents;
	private String sectionNumber;
	public ArrayList<Student> classRoll = new ArrayList<Student>();
	private String sectionName;
	public Course course;
	private String courseID;
	public String numSeats;
	Catalog catalog = Catalog.getInstance();
	private int numStudentsEnrolled = 0;
	College college = College.getInstance();
	
	public Section(String courseID, String sectionNumber, int maxStudents)
	{
		this.courseID = courseID;
		this.sectionNumber = sectionNumber;
		this.maxStudents = maxStudents;
		
		sectionName = courseID + " " + sectionNumber;
		
		course = catalog.getCourseById(courseID);
	}
	

	public boolean registerStudent(Student s)
	{

		if (classRoll.contains(s))
		{
			System.out.println("Student already registered for this course");
			return false;
			//Don't add same student twice in a section
		}
		if (numStudentsEnrolled <= maxStudents)
		{
			classRoll.add(s);
			numStudentsEnrolled++;
			return true;
		}
		
		else
		{
			System.out.println("Student not added, too many Students in class");
			notifyObservers(); //OBSERVER HERE
			return false;
		}
	}
	
	public boolean setOverride()
	{
		if (classRoll.size() == maxStudents)
		{
			maxStudents++;
			return true;
		}
		return false;
	}
	
	public int getAvailableSeats()
	{
		int availableSeats;
		availableSeats = maxStudents - classRoll.size();
		return availableSeats;
	}
	
	public String getAvailableSeatsString()
	{	
		String localSeats = "0";
		int availableSeats;
		availableSeats = maxStudents - classRoll.size();
		if (availableSeats == 1)
		{
			localSeats = "1";
		}
		else if (availableSeats == 2)
		{
			localSeats = "2";
		}
		else if (availableSeats == 3)
		{
			localSeats = "3";
		}
		else if (availableSeats == 4)
		{
			localSeats = "4";
		}
		else if (availableSeats == 5)
		{
			localSeats = "5";
		}
		else 
		{
			localSeats = "6";
		}
		
		//availableSeats = Integer.parseInt(localSeats);
		return localSeats;
	}
	
	public String getSectionNumber() 
	{
		return sectionNumber;
	}

	public ArrayList<Student> getClassRoll() 
	{
		return classRoll;
	}
	
	public ArrayList<String> getClassRollString()
	{
		ArrayList<String> classRollString = new ArrayList<String>();
//		for (Student s : getClassRoll())
//		{
//			if (s.getFirstName().equals(classRoll.)
//			{
//				classRollString.add(classRoll);
//			}
//		}
		for (int i = 0; i < classRoll.size(); i++)
		{
			classRollString.add(classRoll.toString());		
		}
		
			return classRollString;
	}

	public String getSectionName() 
	{
		return sectionName;
	}
	

	public Course getCourse() 
	{
		return course;
	}

	public String getCourseID() 
	{
		return courseID;
	}
	
}
