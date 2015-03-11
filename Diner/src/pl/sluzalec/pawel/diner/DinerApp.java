package pl.sluzalec.pawel.diner;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.Patient;
import pl.sluzalec.pawel.diner.model.Project;
import pl.sluzalec.pawel.diner.view.MainOverviewController;

public class DinerApp extends Application {

	public final String APP_NAME = "Diner";
	private Stage primaryStage;
	private AnchorPane mainOverview;
	private ObservableList<Project> patientData = FXCollections
			.observableArrayList();

	public DinerApp() {

		// Sample data.
		patientData.add(new Project());
		
		
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(APP_NAME);

		initMainOverview();

	}

	public ObservableList<Project> getPatientData() {
		return patientData;
	}

	public void initMainOverview() {
		try {
			// Load main view from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DinerApp.class
					.getResource("view/MainOverview.fxml"));
			mainOverview = (AnchorPane) loader.load();

			// Show scene with main view.
			Scene scene = new Scene(mainOverview);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Give the controller access to the main app.
			MainOverviewController controller = loader.getController();
			controller.setDinerApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
