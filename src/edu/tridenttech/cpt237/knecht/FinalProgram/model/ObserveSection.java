package edu.tridenttech.cpt237.knecht.FinalProgram.model;

import java.util.Observable;
import java.util.Observer;

public class ObserveSection implements Observer
{

	@Override
	public void update(Observable arg0, Object arg1) 
	{
		System.out.println("There are too many Students in the class!!");
		
	}

}
