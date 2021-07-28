/**
 * 
 * Class that Runs the Controller for the Transaction Scene and loads the data in the
 * viewlist and changes to main scene if the home button is pressed
 * 
 * @author adalberto Ramirez
 */
package application.transactioncontroller;

import java.*;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import application.Main;
import application.controller.MainController;
import application.model.Budget;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TransactionController implements Initializable {

	// FXML buttons and list for the scene
	@FXML
	Button HomeBtn;
	
	@FXML
	ListView listview;
	
	/** 
	 * handle event method that handles the event when the home button is pressed 
	*/
	@FXML
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

	/**
	 * Initialize method that handles the parsing of data into the listview
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Main.budget.getList();
		
		ObservableList<String> items =FXCollections.observableArrayList (
				Main.budget.getList());
			listview.setItems(items);
	}

}
