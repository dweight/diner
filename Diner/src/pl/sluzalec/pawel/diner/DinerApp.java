package pl.sluzalec.pawel.diner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DinerApp extends Application {

	public static String APP_NAME = "Diner"; 

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
                    "/pl/sluzalec/pawel/diner/view/MainOverview.fxml"));
            Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.setTitle(APP_NAME);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
