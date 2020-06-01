/*
 * @author: Thi Nguyen
 * @date: 05/31/2020
 */

package autoShop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class autoShopMain extends Application {

	public void start(Stage primaryStage) throws Exception {
		// load the fxml file
		Parent root = FXMLLoader.load(getClass().getResource("AutoShop.fxml"));
		// set the scene
		Scene scene = new Scene(root);		
		// set the title of the window
		primaryStage.setTitle("Joe's AutoShop");
		// set the scene for the stage
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
