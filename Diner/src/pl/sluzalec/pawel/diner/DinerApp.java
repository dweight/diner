package pl.sluzalec.pawel.diner;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.Project;
import pl.sluzalec.pawel.diner.view.AddProjectDialogController;
import pl.sluzalec.pawel.diner.view.MainOverviewController;

public class DinerApp extends Application {

	public final String APP_NAME = "Diner";
	private Stage primaryStage;
	private AnchorPane mainOverview;
	private ObservableList<Project> projectList = FXCollections
			.observableArrayList();

	public DinerApp() {

		// Place to add new sample project.
		
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(APP_NAME);

		initMainOverview();

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

	public boolean showAddDialog(Project project) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DinerApp.class
					.getResource("view/AddProjectDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Dodaj Projekt");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AddProjectDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setProject(project);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ObservableList<Project> getProjectList() {
		return projectList;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
