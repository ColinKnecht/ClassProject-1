package edu.tridenttech.cpt237.knecht.FinalProgram.view;

import edu.tridenttech.cpt237.knecht.FinalProgram.model.Catalog;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Course;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Instructor;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Major;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Person;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddNewStudent 
{
	College college = College.getInstance();
	Catalog catalog = Catalog.getInstance();
	private Stage myStage;
	TextField firstName;
	TextField lastName;
	TextField major;
	
	
	public AddNewStudent()//Constructor
	{		
		
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		Button saveBtn = new Button("Save");
		Button cancelBtn = new Button("Cancel");
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setTitle("Add A Student-(AddNewStudent Class)");
		
		myStage.setWidth(450);
		
		
		gridPane.add(new Text("Add Student"), 0, 0);
		gridPane.add(new Label("First Name:"),0 ,1);
		firstName = new TextField();
		gridPane.add((firstName), 1, 1);
		gridPane.add(new Label("Last Name:"), 0, 2);
		lastName = new TextField();
		gridPane.add((lastName), 1, 2);
//		gridPane.add(new Label("Enter Major:"), 0, 3);
//		major = new TextField();
//		gridPane.add((major), 1, 3);
		gridPane.add(saveBtn,0,4);
		gridPane.add(cancelBtn, 1, 4);
		
		saveBtn.setOnAction(new StudentRegister());
		saveBtn.setTooltip(new Tooltip("Save New Student"));
		
		cancelBtn.setOnAction(new CancelHandler());
		cancelBtn.setTooltip(new Tooltip("Return to Main Menu"));
			
	}
    public class CancelHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
             myStage.close();
        }
    }
    
    public class StudentRegister implements EventHandler<ActionEvent>
    {

		@Override
		public void handle(ActionEvent event) 
		{
			// TODO Auto-generated method stub
			String fName = firstName.getText();
			String lName = lastName.getText();
//			String majr = major.getText();
			
			college.addStudent(fName, lName);
//			catalog.getMajorByName(majr);
			
			myStage.close();
			
		}
    }
	
	public boolean isShowing()
	{
		return myStage.isShowing();
	}
	
	public void toFront()
	{
		myStage.toFront();
	}
	public void show()
	{
		myStage.show();
	}

}///

