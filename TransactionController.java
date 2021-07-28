package application.transactioncontroller;

import java.*;
import java.io.IOException;

import application.Main;
import application.controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class TransactionController implements EventHandler<ActionEvent> {

	@FXML
	Button HomeBtn;
	
	@FXML
	ScrollPane TransactionList;
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Button selected = (Button) event.getSource();
		
		if(selected.getId().equalsIgnoreCase("HomeBtn"))
		{
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( MainController.class.getResource("/Main.fxml") );
				
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
