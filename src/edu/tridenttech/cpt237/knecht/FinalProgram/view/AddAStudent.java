package edu.tridenttech.cpt237.knecht.FinalProgram.view;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface


import java.util.ArrayList;

import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Section;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddAStudent 
{
	private Stage myStage;
	College college = College.getInstance();
	public ArrayList<String> secOffered = new ArrayList<String>();
	Student currentStudent;
	Section currentSection;
	Text firstName;
	Text lastName;
	Text major;
	Text registeredSection;
	
	public AddAStudent()
	{
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setTitle("Add A Section-(AddAStudentClass)");
		myStage.setWidth(550);
		Button addSectionBtn = new Button("Add A Section");
		Button cancelBtn = new Button("Cancel");
		Button showSectionBtn = new Button("Show Section Info");
		
		
		ListView<String> registeredClassWindow = new ListView<>();
		ObservableList<String> classList = FXCollections.observableArrayList();
		secOffered = college.printSectionStringList();
		for (int i = 0; i < secOffered.size(); i++)
		{
			classList.add(secOffered.get(i));
		}
		//sectionsOffered = college.printSectionsOfferedAL();
		//sectionsOffered = college.getSectionsOffered();
//		for (int i = 0; i < sectionsOffered.size(); i++)
//		{
//			classList.add(sectionsOffered.get(i));
//		}
		
		registeredClassWindow.setItems(classList);
		
		gridPane.add(new Text("Add A Section For Student"), 0, 0);
		gridPane.add(registeredClassWindow, 0, 1);
		gridPane.add(addSectionBtn, 1, 2);
		gridPane.add(cancelBtn, 0, 2);
		gridPane.add(new Text("First Name: "), 0, 3);
		firstName = new Text();
		gridPane.add(firstName, 1, 3);
		gridPane.add(new Text("Last Name: "), 0, 4);
		lastName = new Text();
		gridPane.add(lastName, 1, 4);
		gridPane.add(new Text("Major: "), 0, 5);
		major = new Text();
		gridPane.add(major, 1, 5);
		gridPane.add(new Text("Registered Section: "), 0, 6);
		registeredSection = new Text();
		gridPane.add(registeredSection, 1, 6);
		gridPane.add(showSectionBtn, 0, 8);
		addSectionBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				int i = registeredClassWindow.getSelectionModel().getSelectedIndex();
				if (i >=0)
				{
					String sectionName = classList.get(i);
					Section s;
					s = college.getSectionByName(sectionName);
					currentStudent.addSection(sectionName);
					
					currentStudent.registerStudent(s);
					
					registeredSection.setText(sectionName);
					StudentInfo studentInfoWindow = new StudentInfo();
					
					studentInfoWindow.update(currentStudent,sectionName);
					
					//student.addRegisteredSection(sectionName)
				}
			}
		});
		
		showSectionBtn.setOnAction(new ShowSectionHandler() {
			public void handle(ActionEvent event)
			{
				int i = registeredClassWindow.getSelectionModel().getSelectedIndex();
				if (i >=0)
				{
					String sectionName = classList.get(i);
					Section s;
					s = college.getSectionByName(sectionName);
					
					ShowSection showSectionWindow = new ShowSection();
					showSectionWindow.show(s);	
				}
			}		
		});
		cancelBtn.setOnAction(new CancelHandler());
		///LIST VIEW
	}
	
	public class ShowSectionHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0) 
		{
			ShowSection showSectionWindow = new ShowSection();
			showSectionWindow.show(currentSection);
		}
	}
	
	
	public void show(Student student)
	{
		currentStudent = student;
		
		firstName.setText(student.getFirstName());
		lastName.setText(student.getLastName());

		major.setText(student.getStudentsMajor().getMajorName());
		
		myStage.show();
	}
	
	public void toFront()
	{
		myStage.toFront();
	}
	
	public boolean isShowing()
	{
		return myStage.isShowing();
	}
	
	public class CancelHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			myStage.close();
		}
	}

}
