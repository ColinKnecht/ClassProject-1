package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: Program4-Knecht-237
//AUTHOR: Colin Knecht
//PURPOSE: Design a user interface for generating schedules and students

import java.util.ArrayList;
import java.util.Collection;

public class Major 
{
	private final String majorName;
	private final boolean isDegree;
	public ArrayList<Course> courseList = new ArrayList<Course>();
	
	public Major (String majorName, boolean isDegree)
	{
		this.majorName = majorName;
		this.isDegree = isDegree;
	}
	public Major(String majorName, boolean isDegree, ArrayList courseList)
	{
		this.majorName = majorName;
		this.isDegree = isDegree;
		this.courseList = courseList;
	}

	public String getMajorName() 
	{
		return majorName;
	}

	public boolean isDegree() 
	{
		return isDegree;
	}
	public void addRequiredCourse(Course newCourse)
	{
		courseList.add(newCourse);
	}

	public ArrayList<Course> getRequiredCourses() 
	{
		return courseList;
	}

	public ArrayList addAll(String string) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}// end Major Class
