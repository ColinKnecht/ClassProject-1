package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog 
{
	public ArrayList<Course> courses = new ArrayList<Course>();
	public ArrayList<Major> majorList = new ArrayList<Major>();
	public int index = 0;
	private static Catalog instance;
	College college = College.getInstance();
	
	private Catalog()
	{
		
	}
	public static Catalog getInstance()
	{
		if (instance == null)
		{
			instance = new Catalog();
		}
		return instance;
	}
	
	public void loadMajors(String fileName)
	{
		try 
		{
			Scanner fileRead = new Scanner(new File(fileName));
			while (fileRead.hasNext())
			{
				String line = fileRead.nextLine();
				String[] fields = line.split(",");
				Course newCourse;
				Major newMajor = new Major(fields[0],Boolean.parseBoolean(fields[1]));
				for (int i = 2; i < fields.length; i++)
				{
					newCourse = getCourseById(fields[i]);
					newMajor.addRequiredCourse(newCourse);	
				}
				majorList.add(newMajor);
			}
			fileRead.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File Not Found");
		}
	}
	public void loadCourses(String fileName)
	{
		try 
		{
			Scanner fileRead = new Scanner(new File(fileName));
			while (fileRead.hasNext())
			{
				
				String line = fileRead.nextLine();
				String[] fields = line.split(",");
				
				Course course = new Course(fields[0], fields[1], Integer.parseInt(fields[2]));
				String newSection = fields[0] + " - 001";
				//college.addSection(newSection);
				courses.add(course);
			}//end while
			fileRead.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File Not Found");
		}
	}//end loadCourses
	
	public void printCourseList()
	{
		for (int i=0; i < courses.size(); i++)
		{
			System.out.printf("%d %10s %10s %5d%n", i, courses.get(i).getCourseID(),courses.get(i).getCourseName(), courses.get(i).getCourseHours());	
		}
	}
	public ArrayList<Major> getMajorList()
	{
		return majorList;
	}
	public void printMajorList()
	{
		for (int i=0; i < majorList.size(); i++)
		{
			System.out.printf("%5d %s %5s %n",i, majorList.get(i).getMajorName(),majorList.get(i).isDegree());
		}
	}
	
	public Course getCourseById(String idNumber)
	{
		for (Course c : courses)
		{
			if (idNumber.equals(c.getCourseID()))
				return c;			
		}//END FOR LOOP
		System.out.println("Course ID Number not found");
		return null;
	}
	
	public Major getMajorByName(String nameMajor) //ADDED FOR PROGRAM 2
	{
		for (Major m : majorList)
		{
			if (nameMajor.equals(m.getMajorName()))
				return m;
		}
		return null;
	}
	
}//end Catalog class
