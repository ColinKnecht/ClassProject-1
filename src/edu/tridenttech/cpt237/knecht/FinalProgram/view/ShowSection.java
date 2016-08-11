package edu.tridenttech.cpt237.knecht.FinalProgram.view;
//FILE: FinalProgram-Knecht
//AUTHOR: Colin Knecht
//PURPOSE: Add Section and TermSchedule classes and connect them with the interface
import java.util.ArrayList;

import edu.tridenttech.cpt237.knecht.FinalProgram.model.Catalog;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.College;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Section;
import edu.tridenttech.cpt237.knecht.FinalProgram.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowSection 
{
	College college = College.getInstance();
	Catalog catalog = Catalog.getInstance();
	Section currentSection;
	Text sectionName;
	Text seatsAvailable;
	public ArrayList<String> classStudents = new ArrayList<String>();
	public ArrayList<Student> classStudents1 = new ArrayList<Student>();
	
	private Stage myStage;
	
	public ShowSection()
	{
		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane);
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.setTitle("Show Section(ShowSection Class)");
		myStage.setWidth(550);
		
		Button closeBtn = new Button("Close");
		ListView<String> classRollWindow = new ListView<>();
		ObservableList<String> classList = FXCollections.observableArrayList();
//		classStudents = currentSection.getClassRollString();
//		for (int i = 0; i < classStudents.size(); i++)
//		{
//			classList.add(classStudents.get(i));
//		}
		////PUT STUDENT LIST ROLL HERE
		//classRollWindow.setItems(classList);
		
		gridPane.add(new Text("Show Section Info"), 0, 0);
		gridPane.add(new Label("Section Name:"), 0, 1);
		sectionName = new Text();
		gridPane.add(sectionName, 1, 1);
		gridPane.add(new Label("Number of Seats Available:"), 0, 2);
		seatsAvailable = new Text();
		gridPane.add(seatsAvailable, 1, 2);
		gridPane.add(new Label("Students Currently Enrolled:"), 0, 3);
		//gridPane.add(classRollWindow, 1, 3);
		

		
		gridPane.add(closeBtn, 0, 6);
		closeBtn.setOnAction(new CloseButtonHandler());
	
	}
	public void show(Section section)
	{
		currentSection = section;
		sectionName.setText(section.getSectionName());
		seatsAvailable.setText(section.getAvailableSeatsString());
		myStage.show();
	}
	
	public class CloseButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			myStage.close();
		}
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
