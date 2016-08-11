package edu.tridenttech.cpt237.knecht.FinalProgram.view;
import java.util.Optional;

import edu.tridenttech.cpt237.knecht.FinalProgram.model.Catalog;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface


public class MainWindow 
{
	TextField idNumber;
	TextField firstName;
	TextField lastName;
	College college = College.getInstance();
	Catalog catalog = Catalog.getInstance();
	StudentInfo studentInfoWindow = new StudentInfo();
	
	private Stage myStage;
	
	public MainWindow(Stage stage) 
	{
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		Button okBtn = new Button("OK");
		Button cancelBtn = new Button("Cancel");
		myStage = stage;
		myStage.setTitle("Main Window Program 4(MainWindow Class)");
		myStage.setScene(scene);
		myStage.setWidth(550);
		
		gridPane.add(new Text("Welcome to Program 4"), 1, 0);
		gridPane.add(new Label("What is the Student's ID:"), 1, 1);
		idNumber = new TextField();
		gridPane.add((idNumber), 2, 1);
		gridPane.add(new Text("or Search by Name"), 1, 2);
		gridPane.add(new Label("First Name:"), 1, 3);
		firstName = new TextField();
		gridPane.add((firstName), 2, 3);
		gridPane.add(new Label("Last Name:"), 1, 4);
		lastName = new TextField();
		gridPane.add((lastName), 2, 4);
		
		gridPane.add(okBtn, 1, 5);
		gridPane.add(cancelBtn, 2, 5);
		
		//okBTN SET ON ACTION
		okBtn.setTooltip(new Tooltip("Advance to Next Screen"));
		okBtn.setOnAction(new StudentInfoLauncher());
		
		
		cancelBtn.setTooltip(new Tooltip("Cancel the Program"));
		cancelBtn.setOnAction(new CancelHandler());
		
	}
	
	public class StudentInfoLauncher implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			//StudentInfo studentInfoWindow = new StudentInfo();
			//studentInfoWindow.show();	
			String fName = firstName.getText();
			String lName = lastName.getText();
			String idNum = idNumber.getText();
			
			if (studentInfoWindow == null)
			{
				studentInfoWindow = new StudentInfo();
			}
			
			if (!studentInfoWindow.isShowing())
			{
				if (fName.length() != 0 && lName.length() != 0)
				{
				Student student = college.getStudentByName(fName, lName);
				
					if (student == null)
					{
						Alert alert = new Alert(AlertType.CONFIRMATION, "Student does not exist yet.  Would you like to add Student?");
						
						 Optional<ButtonType> result = alert.showAndWait();
						 if (result.isPresent() && result.get() == ButtonType.OK) 
						 {
						     //ADD student
							 AddNewStudent newStudentWindow = new AddNewStudent();
							 newStudentWindow.show(); 
						 }
						
					}
				studentInfoWindow.show(student);
				//alert Here
				}
				else if (fName.length() == 0 && lName.length() == 0)
				{
					Student student = college.getStudentByID(idNum);
					
					if (student == null)
					{
						Alert alert = new Alert(AlertType.CONFIRMATION, "Student does not exist yet.  Would you like to add Student?");
						
						 Optional<ButtonType> result = alert.showAndWait();
						 if (result.isPresent() && result.get() == ButtonType.OK) 
						 {
						     //Add Student
							 AddNewStudent newStudentWindow = new AddNewStudent();
							 newStudentWindow.show();
						 }
					}
					
					studentInfoWindow.show(student);
				}
				
			}
			else
			{
				studentInfoWindow.toFront();
			}
		}
	}
	
	public void show()
	{
		myStage.show();
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
