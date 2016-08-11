package edu.tridenttech.cpt237.knecht.FinalProgram.view;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface

import java.util.ArrayList;

import edu.tridenttech.cpt237.knecht.FinalProgram.model.Catalog;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentInfo 
{
	College college = College.getInstance();
	Catalog catalog = Catalog.getInstance();
	
	private Stage myStage;
	Student currentStudent;
	Text idNumber;
	Text firstName;
	Text lastName;
	Text major;
	Text registeredSections;
	AddAStudent registerSectionWindow = new AddAStudent();
	public ArrayList<String> regSectionList = new ArrayList<String>();
	ListView<String> regSectionWindow = new ListView<>();
	ObservableList<String> courseList = FXCollections.observableArrayList();
	
	public StudentInfo()
	{
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setTitle("Window 2 of Program 4-(StudentInfo)");
		myStage.setWidth(550);
		Button addSectionBtn = new Button("Add Section");
		Button cancelBtn = new Button("Cancel");
		

//		regSectionList = currentStudent.printRegisteredSectionsList();
//		for (int i = 0; i < regSectionList.size(); i++)
//		{
//			courseList.add(regSectionList.get(i));
//		}
//		
//		regSectionWindow.setItems(courseList);
		
		gridPane.add(new Text("StudentInfo"), 0, 0);
		gridPane.add(new Label("First Name:"), 0, 1);
		firstName = new Text();
		gridPane.add(firstName, 1, 1);
		gridPane.add(new Label("Last Name:"), 0, 2);
		lastName = new Text();
		gridPane.add(lastName, 1, 2);
		gridPane.add(new Label("Major:"), 0, 3);
		major = new Text();
		gridPane.add(major, 1, 3);
		gridPane.add(new Label("Classes Registered:"), 0, 4);
	
		//gridPane.add(registeredSections, 1, 4);
		gridPane.add(regSectionWindow, 1, 4);
		
		// ADD LIST HERE, MOVE BUTTONS DOWN
		gridPane.add(addSectionBtn, 0, 6);
		gridPane.add(cancelBtn, 1, 6);
		
		addSectionBtn.setTooltip(new Tooltip("Add A Section to the Student"));
//		addSectionBtn.setOnAction(new RegisterStudentHandler());
		addSectionBtn.setOnAction(new AddAStudentHandler());
		///addSectionBtn SET ON ACTION
		
		cancelBtn.setTooltip(new Tooltip("Close The Window"));
		cancelBtn.setOnAction(new CancelHandler());
		
	}
	
	public class CancelHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			myStage.close();
		}
	}
	
	public class AddAStudentHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			AddAStudent addStudentWindow = new AddAStudent();
			addStudentWindow.show(currentStudent);
		}
	}
	
	public class RegisterStudentHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0) {
			//RegisterStudent registerStudentWindow = new RegisterStudent();
			//registerStudentWindow.show();
		}
	}
	
	public void show(Student student)
	{
		currentStudent = student;
		firstName.setText(student.getFirstName());
		lastName.setText(student.getLastName());
		major.setText(student.getStudentsMajor().getMajorName());
		
		regSectionList = student.printRegisteredSectionsList();
		for (int i = 0; i < regSectionList.size(); i++)
		{
			courseList.add(regSectionList.get(i));
		}
		
		regSectionWindow.setItems(courseList);
		
		//registeredSections.setText(student.printRegisteredSectionsList());
		
		myStage.show();
	}
	
	public void update(Student student, String sectionName)
	{
		currentStudent = student;
		firstName.setText(student.getFirstName());
		lastName.setText(student.getLastName());

		major.setText(student.getStudentsMajor().getMajorName());
		
		regSectionList = student.printRegisteredSectionsList();
		for (int i = 0; i < regSectionList.size(); i++)
		{
			//courseList.add(regSectionList.get(i));
			courseList.add(sectionName);
		}
		
		regSectionWindow.setItems(courseList);
		
		//registeredSections.setText(sectionName);
		//registeredSections.setText(currentStudent.getRegisteredSections());
	}
	
	public void update(Student student)
	{
		currentStudent = student;
		firstName.setText(student.getFirstName());
		lastName.setText(student.getLastName());

		major.setText(student.getStudentsMajor().getMajorName());
		
		regSectionList = student.printRegisteredSectionsList();
		for (int i = 0; i < regSectionList.size(); i++)
		{
			courseList.add(regSectionList.get(i));
		}
		
		regSectionWindow.setItems(courseList);
		
		//registeredSections.setText(sectionName);
		//registeredSections.setText(currentStudent.getRegisteredSections());
	}
	public void toFront()
	{
		myStage.toFront();
	}
	public boolean isShowing()
	{
		return myStage.isShowing();
	}
}
