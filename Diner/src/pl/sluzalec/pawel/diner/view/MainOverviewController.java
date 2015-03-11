package pl.sluzalec.pawel.diner.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.DinerApp;
import pl.sluzalec.pawel.diner.model.Project;

public class MainOverviewController {

	@FXML
	private TextField bodyMassTextField;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private TreeView<String> patientTreeView;

	@FXML
	private TextField haightTextField;

	@FXML
	private Button searchButton;

	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private Tab patientDataTab;

	@FXML
	private MenuItem saveMenuItem;

	@FXML
	private TreeView<?> editorTreeView;

	@FXML
	private TextField nameTextField;

	@FXML
	private Button addPatientButton;

	@FXML
	private TextField weistTextField;

	@FXML
	private TextField ageTextField;

	@FXML
	private Tab editorTab;

	@FXML
	private Button deletePatientButton;

	@FXML
	private TextField hipsTextField;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private TextField searchTextield;

	@FXML
	private MenuItem closeMenuItem;

	@FXML
	private Tab indexTab;

	@FXML
	private RadioButton maleRadioButton;

	@FXML
	private MenuItem loadMenuItem;

	// Reference to DinerApp.
	private DinerApp dinerApp;

	// Root TreeList Item.
	private TreeItem<String> rootItem = new TreeItem<>();

	// List of project items.
	private ObservableList<TreeItem<String>> projectItesList = FXCollections
			.observableArrayList();

	public MainOverviewController() {
		
		Project project1 = new Project();
		Project project2 = new Project();
		
		projectItesList.add(project1.setItem());
		projectItesList.add(project2.setItem());
	}

	@FXML
	private void initialize() {
		initTreeList();
	}

	@FXML
	private void handleAbout() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("O programie");
		alert.setContentText("Diner - prosty edytor diet.\nAutor: Paweł Służalec, 2015");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	@FXML
	private void handleClose() {
		Stage stage = dinerApp.getPrimaryStage();
		stage.close();
	}

	public void setDinerApp(DinerApp dinerApp) {
		this.dinerApp = dinerApp;

	}

	public void initTreeList() {
		
		rootItem.getChildren().addAll(projectItesList);
		rootItem.setExpanded(true);
		patientTreeView.setRoot(rootItem);
		patientTreeView.setShowRoot(false);

		System.out.println("Aktywowano TreeListView");
	}
}
