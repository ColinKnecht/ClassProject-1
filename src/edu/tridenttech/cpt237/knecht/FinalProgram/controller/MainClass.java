package edu.tridenttech.cpt237.knecht.FinalProgram.controller;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Catalog;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Section;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.TermSchedule;
import edu.tridenttech.cpt237.knecht.FinalProgram.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainClass extends Application
{
	
	public void start(Stage primaryStage) throws Exception
	{
		new MainWindow(primaryStage).show();
	}
	
	public static void main(String[] args)
	{
		Catalog catalog = Catalog.getInstance();
		College college = College.getInstance();
		TermSchedule termSchedule = TermSchedule.getInstance();
		
		catalog.loadCourses("NeptuneCourses.txt");
		catalog.loadMajors("NeptuneMajors.txt");
		//college.loadInstructors("NeptuneInstructors-B.txt");
		college.loadStudents("NeptuneStudents.txt");
		termSchedule.loadSections("NeptuneSections-revised.txt");
		
		
		
		Application.launch(args);
	}

}//end MainClass
