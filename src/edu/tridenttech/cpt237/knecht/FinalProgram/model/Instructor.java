package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: Program4-Knecht-237
//AUTHOR: Colin Knecht
//PURPOSE: Design a user interface for generating schedules and students
import java.util.ArrayList;

public class Instructor extends Person {

	Catalog catalog = Catalog.getInstance();
	private ArrayList<Course> preferredCourses = new ArrayList<Course>();
	
	public Instructor(String firstName, String lastName) 
	{
		super(firstName, lastName);
	}
	
	public void addPreferredCourse(String courseID)
	{
		Course c = catalog.getCourseById(courseID);
		//for (c : preferredCourses)
		//{
			if (courseID.equals(catalog.getCourseById(courseID)))
			{
				preferredCourses.add(c);
			}
			else if (c == null)
			{
				System.out.println("Course not Found(addPreferredCourse)");
			}
		//}//END FOR LOOP	
	}
	
	public boolean isPreferredCourse(String courseID)
	{
		for (int i=0; i < preferredCourses.size(); i++)
		{
			if (courseID == preferredCourses.get(i).getCourseID())
				return true;	
		}//END FOR
		return false;
	}

}//END INSTRUCTOR CLASS
