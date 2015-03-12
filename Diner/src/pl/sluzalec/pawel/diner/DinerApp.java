package pl.sluzalec.pawel.diner;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pl.sluzalec.pawel.diner.model.Project;
import pl.sluzalec.pawel.diner.util.ProjectListWrapper;
import pl.sluzalec.pawel.diner.view.AddProjectDialogController;
import pl.sluzalec.pawel.diner.view.MainOverviewController;

public class DinerApp extends Application {

	public final String APP_NAME = "Diner";
	private Stage primaryStage;
	private AnchorPane mainOverview;
	private ObservableList<Project> projectList = FXCollections
			.observableArrayList();

	public DinerApp() {
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(APP_NAME);
		this.primaryStage.getIcons()
				.add(new Image("file:res/images/diner.png"));
		initMainOverview();
	}

	public ObservableList<Project> getProjectList() {
		return projectList;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	// Saving and loading last sate of app.
	// Returns project file preference - the file that was opened.
	public File getProjectFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(DinerApp.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	// Sets the path to currently loaded file.
	public void setProjectFile(File file) {
		Preferences prefs = Preferences.userNodeForPackage(DinerApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update app title.
			primaryStage.setTitle(APP_NAME + " - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update app title.
			primaryStage.setTitle(APP_NAME);
		}
	}

	// Method to load saved projects from file.
	public void loadProjectDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(ProjectListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Loading file and unmarshalling.
			ProjectListWrapper wrapper = (ProjectListWrapper) um
					.unmarshal(file);

			projectList.clear();
			projectList.addAll(wrapper.getProjects());

			// Save file path to registry.
			setProjectFile(file);

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Błąd :(");
			alert.setHeaderText("Nie udało się wczytać danych");
			alert.setContentText("Nie udało się wczytać pliku:\n"
					+ file.getPath());
			alert.showAndWait();
		}
	}

	// Method to save current projects to file.
	public void saveProjectDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(ProjectListWrapper.class);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping project data
			ProjectListWrapper wrapper = new ProjectListWrapper();
			wrapper.setProjects(projectList);

			// Marshalling and saving to file.
			mar.marshal(wrapper, file);
			setProjectFile(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Błąd :(");
			alert.setHeaderText("Nie udało się zapisać danych");
			alert.setContentText("Nie udało się zapisać pliku:\n"
					+ file.getPath());
			alert.showAndWait();
		}
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

}
