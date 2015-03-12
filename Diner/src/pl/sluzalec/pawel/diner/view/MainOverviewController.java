package pl.sluzalec.pawel.diner.view;

import com.sun.webkit.ContextMenu.ShowContext;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	private TextField hightTextField;

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
	private TextField waistTextField;

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

	@FXML
	private TableView<Project> projectTableView;

	@FXML
	private TableColumn<Project, String> projectTableColumn;

	// Reference to DinerApp.
	private DinerApp dinerApp;

	public MainOverviewController() {

	}

	public void setProjectData(Project project) {
		if (project != null) {
			this.nameTextField.setText(project.getPatientName());
			this.lastNameTextField.setText(project.getLastName());
			this.ageTextField.setText(project.getAge());
			this.bodyMassTextField.setText(project.getBodyMass().toString());
			this.hightTextField.setText(project.getHigth().toString());
			this.hipsTextField.setText(project.getHigth().toString());
			this.waistTextField.setText(project.getWaist().toString());
		} else {
			this.nameTextField.setText("");
			this.lastNameTextField.setText("");
			this.ageTextField.setText("");
			this.bodyMassTextField.setText("");
			this.hightTextField.setText("");
			this.hipsTextField.setText("");
			this.waistTextField.setText("");
		}
	}

	public void setDinerApp(DinerApp dinerApp) {
		this.dinerApp = dinerApp;

		// Add observable list data to the table
		projectTableView.setItems(dinerApp.getProjectList());

	}

	@FXML
	private void initialize() {
		// Initialize project column with project names.
		projectTableColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getProjectName());

		// Clear person details.
		setProjectData(null);

		// Add listner.
		projectTableView
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> setProjectData(newValue));

	}

	@FXML
	private void handleAdd() {
		dinerApp.showAddDialog();
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

}
