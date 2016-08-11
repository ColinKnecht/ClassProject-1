package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class College {
	private static College instance;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
	private ArrayList<Section> sectionsOffered = new ArrayList<Section>();
	
		
	private College()//Constructor
	{
		
	}
	
	public static College getInstance()
	{
		if (instance == null)
		{
			instance = new College();
		}
		return instance;
	}
	
	public void addSection(Section sectionName)
	{
		if (sectionsOffered.contains(sectionName))
		{
			System.err.println("duplicate section");
			return;
		}
		
		sectionsOffered.add(sectionName);	
	}
	
	public ArrayList<Section>getSectionsOffered()
	{
		return sectionsOffered;
	}
	public void printSectionsOffered()
	{
		for (int i = 0; i < sectionsOffered.size(); i++)
		{
			System.out.printf("%5d %s %n", i, sectionsOffered.get(i).getSectionName());
		}
	}
	
	public Section getSectionByName(String sectionName)
	{
		for (Section s : sectionsOffered)
		{
			if (sectionName.equals(s.getSectionName()))
			{
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<String> printSectionStringList()
	{
		ArrayList<String> stringSections = new ArrayList<String>();
		for (int i = 0; i < sectionsOffered.size(); i++)
		{
			stringSections.add(sectionsOffered.get(i).getSectionName());
			//System.out.printf("%5d %s %n", i, sectionsOffered.get(i).getSectionName());
		}
		return stringSections;
	}
	
	public ArrayList<Section> printSectionsOfferedAL()
	{
		ArrayList<Section> sectionsPrinted = new ArrayList<Section>();
		for (int i = 0; i < sectionsOffered.size(); i++)
		{
			//sectionsPrinted.add(sectionsOffered.get(i).getSectionName());
			 System.out.printf("%5d %s %n", i, sectionsOffered.get(i).getSectionName());
			 //System.out.printf("%5d %s %n", i, sectionsPrinted.get(i));
		}
		return sectionsOffered;
	}
	
	public void loadStudents(String fileName)
	{
		try 
		{
			Scanner fileRead = new Scanner(new File(fileName));
			while (fileRead.hasNext())
			{
				String line = fileRead.nextLine();
				String[]fields = line.split(",");
				//Major major = null;
				Student newStudent = new Student(fields[0],fields[1]);
				
				newStudent.setStudentsMajor(fields[2]);
				
				studentList.add(newStudent);
			}//END WHILE
			fileRead.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Student File Not Found/Loaded");
			e.printStackTrace();
		}
	}
	
	public void loadInstructors(String fileName)
	{
		try 
		{
			Scanner fileRead = new Scanner(new File(fileName));
			while (fileRead.hasNext())
			{
				String line = fileRead.nextLine();
				String[]fields = line.split(",");
				Instructor newInstructor = new Instructor(fields[0], fields[1]);
				for (int i = 2; i < fields.length; i++)
				{
				newInstructor.addPreferredCourse(fields[2]);
				}
				instructorList.add(newInstructor);	
			}//end While
			fileRead.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Instructor File Not Found/Loaded");
			e.printStackTrace();
		}			
	}
	
	public void printInstructorList()
	{
		for (int i=0; i < instructorList.size(); i++)
		{
			System.out.printf("%5d %s %5s %n",i, instructorList.get(i).getFirstName(),instructorList.get(i).getLastName());
		}
	}
	
	public void printStudentList()
	{
		for (int i=0; i < studentList.size(); i++)
		{
			System.out.printf("%5d %s %5s %n",i, studentList.get(i).getFirstName(),studentList.get(i).getLastName());
		}
	}
	
	public ArrayList<Student> getStudentList()
	{
		return studentList;
	}
	public ArrayList<Instructor> getInstructorList()
	{
		return instructorList;
	}
	
	public Student addStudent(String firstName, String lastName)
	{
		Student newStudent = new Student(firstName,lastName);
		studentList.add(newStudent);
		return newStudent;
	}
	public Instructor addInstructor(String firstName, String lastName)
	{
		Instructor newInstructor = new Instructor(firstName,lastName);
		instructorList.add(newInstructor);
		return newInstructor;	
	}
	
	public Student getStudentByID(int studentID)
	{
		for (Student s : studentList)
		{
			if (studentID == s.getStudentsID())
				return s;
			
		}//END FORLOOP
		return null;
	}
	
	public Student getStudentByID(String idNum)
	{
		int y = Integer.parseInt(idNum);
		
		for (Student s : studentList)
		{
			if (y == s.getStudentsID())
				return s;

		}//END FORLOOP
		return null;
		
	}
	
	public Student getStudentByName(String firstName, String lastName)
	{
		for (Student s : studentList)
		{
			if (firstName.equals(s.getFirstName()) && lastName.equals(s.getLastName()))
			{
				//System.out.println(s.getFirstName() + " " + s.getLastName() + " " + " Major: " + s.getStudentsMajor());
				return s;
			}

			
		}//END FOR LOOP
		return null;	
	}
	
	public Instructor getInstructorByName(String firstName, String lastName)//Check
	{
		for (Instructor i : instructorList)
		{
			if (firstName.equals(i.getFirstName()) && lastName.equals(i.getLastName()))
			{
				System.out.println(i.getFirstName() + " " + i.getLastName());
				return i;
			}	
		}//END FORLOOP
		return null;
	}

}//END COLLEGE CLASS