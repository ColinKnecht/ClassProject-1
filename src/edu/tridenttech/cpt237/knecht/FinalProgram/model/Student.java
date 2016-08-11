package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import java.util.ArrayList;

public class Student extends Person
{
	private static int nextID = 1000;
	private int studentsID;
	public Major studentsMajor;
	Catalog catalog = Catalog.getInstance();
	College college = College.getInstance();
	public ArrayList<String> registeredSections = new ArrayList<String>();
	
	public Student(String firstName, String lastName)//CONSTRUCTOR
	{
		super(firstName, lastName);
		studentsID = nextID++;
	}
	public Student(String firstName, String lastName, int studentsID)
	{
		super(firstName, lastName);
		this.studentsID = studentsID;
		nextID++;
	}
	// BOOLEAN METHOD OVERRIDE
	//SECTION.REGISTERSTUDENT(Section s)
	public boolean overrideMax()
	{
		return false;
	}
	
	public void registerStudent(Section s)
	{
		s.registerStudent(this);
	}
	
	public int getStudentsID(String id) 
	{
		int y = Integer.parseInt(id);
		studentsID = y;
		return studentsID;
	}
	
	public int getStudentsID()
	{
		return studentsID;
	}
	public int getNextID()
	{
		return nextID;
	}

	public Major getStudentsMajor() 
	{
		return studentsMajor;
	}
	
	public void setStudentsMajor(String newMajorName)
	{
		Major m = catalog.getMajorByName(newMajorName);
		
		if (m != null)
		{
			studentsMajor = m;
		}	
		else if (m == null)
		{
			System.out.println("Major not Found(setStudentMajor)");
		}		
	}
	

	public boolean addSection(String sectionName)
	{
		if (sectionName.equals(college.getSectionsOffered()))
		{
			registeredSections.add(sectionName);
			return true;
		}
		registeredSections.add(sectionName);
		return false;
	}
	
	public ArrayList<String>getRegisteredSections()
	{
		return registeredSections;
	}
	
//	public String getRegSectionName(Student s)
//	{
////		String[] section = registeredSections.toArray(new String[registeredSections.size()]);
////		s.getRegisteredSections();
//		if (s.getRegisteredSections() == registeredSections)
//			
//		
//		return section;
//	}
	
	public void printRegisteredSections()
	{
		if (registeredSections.size() == 0)
		{
			registeredSections.add("No Sections");
		}
		
		for (int i = 0; i < registeredSections.size(); i++)
		{
			System.out.printf("%5d %s %n", i, registeredSections.get(i));
		}
	}
	
	public ArrayList<String> printRegisteredSectionsList()
	{
		ArrayList<String> regSectionList = new ArrayList<String>();
		if (registeredSections.size() == 0)
		{
			//registeredSections.add("No Sections");
			regSectionList.add("Student Has No Sections");
		}
		else
		{
			for (int i = 0; i < registeredSections.size(); i++)
			{
				//System.out.printf("%5d %s %n", i, registeredSections.get(i));
				regSectionList.add(registeredSections.get(i));
			}
		}
		return regSectionList;
	}

}//END STUDENT CLASS
