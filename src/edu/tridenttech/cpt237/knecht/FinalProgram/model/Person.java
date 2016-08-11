package edu.tridenttech.cpt237.knecht.FinalProgram.model;
//FILE: Program4-Knecht-237
//AUTHOR: Colin Knecht
//PURPOSE: Design a user interface for generating schedules and students
public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;	
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
}//END PERSON CLASS
