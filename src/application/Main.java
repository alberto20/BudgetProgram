/**
 * 
 * The main class of the program that starts with the main.fxml scene
 * 
 * @author adalberto Ramirez
 */

package application;
	
import application.model.Budget;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
public static Stage stage;

public static Budget budget = new Budget();
	
	/**
	 * method that loads the the Scene page for login when the program is run
	 */
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			budget.ReadFile();
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../Main.fxml") );
			
			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			// Set the scene to stage and show the stage to the user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main function of the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		
	}
}
