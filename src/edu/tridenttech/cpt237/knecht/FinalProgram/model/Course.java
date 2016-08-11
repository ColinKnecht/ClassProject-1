package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface

public class Course 
{
	private final String courseID;
	private final String courseName;
	private final int courseHours;
	
	public Course(String courseID, String courseName, int courseHours)
	{
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseHours = courseHours;	
	}

	public String getCourseID()
	{
		return courseID;
	}

	public String getCourseName() 
	{
		return courseName;
	}

	public int getCourseHours() 
	{
		return courseHours;
	}
}//end Course Class
