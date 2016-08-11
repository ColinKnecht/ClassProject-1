package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TermSchedule 
{
	private static TermSchedule instance;
	College college = College.getInstance();
	
	private TermSchedule()
	{
		
	}
	
	public static TermSchedule getInstance()
	{
		if (instance == null)
		{
			instance = new TermSchedule();
		}
		return instance;
	}
	
	public void loadSections(String fileName)
	{
		try 
		{
			Scanner fileRead = new Scanner(new File(fileName));
			while (fileRead.hasNext())
			{
				try
				{
					String line = fileRead.nextLine();
					String[] fields = line.split(",");
					
					if (fields.length < 1)
					{
						System.err.println("Course ID not present");
						continue;
					}
					
					String courseID;
					courseID = fields[0];
					if (fields.length < 2)
					{
						System.err.println("Section Number not Present");
						continue;
					}
					
					String sectionNumber;
					sectionNumber = fields[1];
					
					if (fields.length < 3)
					{
						System.err.println("Max capacity not present");
						continue;
					}
					
					int maxStudents;
					
					try //NON Numeric
					{
						maxStudents = Integer.parseInt(fields[2]);
					}
					catch (NumberFormatException e)
					{
						System.err.println("Max Capacity is not a Number " + e);
						continue;
					}
					
					
					Section newSection = new Section(courseID, sectionNumber, maxStudents);
					college.addSection(newSection);
					
				}
				catch (Exception e)
				{
					System.err.println(e);
					e.printStackTrace();
				}
			}
			fileRead.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File Not Found(LoadCourse-TermSchedule)");
		}
	}
	
	public Section getSectionByName(String sectionName)
	{
		for (Section s : college.getSectionsOffered())
		{
			if (sectionName.equals(s.getSectionName()))
				return s;
		}
		return null;
	}
	
	public ArrayList<Section> getSectionsByCourseID(String courseID)
	{
		ArrayList<Section> sectionResult = new ArrayList<Section>();
		
		for (Section s : college.getSectionsOffered())
		{
			if (courseID.equals(s.getCourseID()))
			{
				sectionResult.add(s);
			}
		}
			return sectionResult;
	}
	
	public ArrayList<String> getSectionNamesByCourseID(String courseID)
	{
		ArrayList<String> sectionResult = new ArrayList<String>();
		for (Section s : college.getSectionsOffered())
		{
			if (courseID.equals(s.getCourseID()))
			{
				sectionResult.add(s.getCourseID());
			}
		}
			return sectionResult;
	}
	
	public void getSectionNames()
	{
		college.printSectionsOffered();
	}
	
	
}
