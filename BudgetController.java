package application.budgetcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.controller.MainController;
import application.model.Budget;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BudgetController implements Initializable {
	
	@FXML
	Button HomeBtn;
	
	@FXML
	private PieChart BudgetPie;
	
	Budget budget = new Budget();
	
	
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


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		budget.ReadFile();
		ObservableList<PieChart.Data> PieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Expenses" , budget.getExpenses()),
				new PieChart.Data("Remaining" , budget.getRemaining()),
				new PieChart.Data("Income" , budget.getIncome()));
				
				BudgetPie.setData(PieChartData);
		
	}

}
