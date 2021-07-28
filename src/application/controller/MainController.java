/**
 * 
 * Main Controller class that moves the scene to budget Scene or Transaction Scene
 * 
 * @author adalberto ramirez
 */
package application.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import application.Main;
import application.model.Budget;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements EventHandler<ActionEvent> {
	
	//FXML buttons for the scene
	@FXML
	Button BudgetOverviewBtn, TransactionBtn;
	
	/**
	 * handle event method that handles which button is pressed and sets the new scene
	 * dependent on the button
	 */
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Button selected = (Button) event.getSource();

		// sets the budget scene if the budget button is pressed
		if(selected.getId().equalsIgnoreCase("BudgetOverviewBtn"))
		{
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( MainController.class.getResource("/Budget.fxml") );
				
				// Load the layout from the FXML and add it to the scene
				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );
				
				// Set the scene to stage and show the stage to the user
				Main.stage.setScene(scene);
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	
		// swwitches to transaction scene is transaction button is pressed
		if(selected.getId().equalsIgnoreCase("TransactionsBtn"))
		{
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( MainController.class.getResource("/Transactions.fxml") );
				
				// Load the layout from the FXML and add it to the scene
				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );
				
				// Set the scene to stage and show the stage to the user
				Main.stage.setScene(scene);
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
