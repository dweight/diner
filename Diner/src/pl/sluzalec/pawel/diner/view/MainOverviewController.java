package pl.sluzalec.pawel.diner.view;

import java.io.File;
import java.util.Optional;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import pl.sluzalec.pawel.diner.DinerApp;
import pl.sluzalec.pawel.diner.model.DietItem;
import pl.sluzalec.pawel.diner.model.Project;

public class MainOverviewController {

	@FXML
	private MenuItem saveMenuItem;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private MenuItem loadMenuItem;

	@FXML
	private MenuItem closeMenuItem;

	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private Button addPatientButton;

	@FXML
	private Button editButton;

	@FXML
	private Button deletePatientButton;

	@FXML
	private TableView<Project> projectTableView;

	@FXML
	private TableColumn<Project, String> projectTableColumn;

	@FXML
	private Tab patientDataTab;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField ageTextField;

	@FXML
	private TextField bodyMassTextField;

	@FXML
	private TextField higthTextField;

	@FXML
	private TextField waistTextField;

	@FXML
	private TextField hipsTextField;

	@FXML
	private RadioButton maleRadioButton;

	@FXML
	private ToggleGroup genderToggleGroup;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private Tab editorTab;

	@FXML
	private Button addProductButton;

	@FXML
	private TableView<DietItem> breakfastTable;

	@FXML
	private TableColumn<DietItem, String> bc1;

	@FXML
	private TableColumn<DietItem, String> bc2;

	@FXML
	private TableView<DietItem> lunchTable;

	@FXML
	private TableColumn<DietItem, String> lc1;

	@FXML
	private TableColumn<DietItem, String> lc2;

	@FXML
	private TableView<DietItem> dinnerTable;

	@FXML
	private TableColumn<DietItem, String> dc1;

	@FXML
	private TableColumn<DietItem, String> dc2;

	@FXML
	private TableView<DietItem> teaTimeTable;

	@FXML
	private TableColumn<DietItem, String> ttc1;

	@FXML
	private TableColumn<DietItem, String> ttc2;

	@FXML
	private TableView<DietItem> supperTable;

	@FXML
	private TableColumn<DietItem, String> sc1;

	@FXML
	private TableColumn<DietItem, String> sc2;

	@FXML
	private TableView<DietItem> betweenMealsTable;

	@FXML
	private TableColumn<DietItem, String> bmc1;

	@FXML
	private TableColumn<DietItem, String> bmc2;

	@FXML
	private Tab indexTab;

	// Reference to DinerApp.
	private DinerApp dinerApp;

	boolean okClicked = false;

	public MainOverviewController() {

	}

	public void setProjectData(Project project) {
		if (project != null) {
			
			this.nameTextField.setText(project.getPatientName());
			this.lastNameTextField.setText(project.getLastName());
			this.ageTextField.setText(project.getAge());
			this.bodyMassTextField.setText(project.getBodyMass().toString());
			this.higthTextField.setText(project.getHigth().toString());
			this.hipsTextField.setText(project.getHigth().toString());
			this.waistTextField.setText(project.getWaist().toString());
			if (project.getGender() == true) {
				this.genderToggleGroup.selectToggle(femaleRadioButton);
			} else {
				this.genderToggleGroup.selectToggle(maleRadioButton);
			}
			breakfastTable.setItems(project.getBreakfastList());
			lunchTable.setItems(project.getLunchList());
			dinnerTable.setItems(project.getDinnerList());
			teaTimeTable.setItems(project.getTeeTimeList());
			supperTable.setItems(project.getSupperList());
			betweenMealsTable.setItems(project.getBetweenMealsList());
		} else {

			this.nameTextField.setText("");
			this.lastNameTextField.setText("");
			this.ageTextField.setText("");
			this.bodyMassTextField.setText("");
			this.higthTextField.setText("");
			this.hipsTextField.setText("");
			this.waistTextField.setText("");
			this.genderToggleGroup.selectToggle(femaleRadioButton);
		}
	}

	public void setDinerApp(DinerApp dinerApp) {
		this.dinerApp = dinerApp;

		// Add observable list data to the table.
		projectTableView.setItems(dinerApp.getProjectList());

	}

	@FXML
	private void initialize() {

		// Initialize project table with project names.
		projectTableColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getProjectName());
		projectTableColumn.setText("Projekty");
		projectTableView.setPlaceholder(new Text("Brak Projektów"));
		
		// Clear patient details.
		setProjectData(null);

		// Add listner to project table.
		projectTableView
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> setProjectData(newValue));

		// Initialize editor tables columns.
		bc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		bc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		lc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		lc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		dc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		dc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		ttc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		ttc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		sc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		sc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		bmc1.setCellValueFactory(cellData -> cellData.getValue().getName());
		bmc2.setCellValueFactory(cellData -> cellData.getValue().getQuantity()
				.asString());

		// Add listners to editor tabels.
		breakfastTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
		
		lunchTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
		
		dinnerTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
		
		teaTimeTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
		
		supperTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
		
		betweenMealsTable
		.getSelectionModel()
		.selectedItemProperty()
		.addListener(
				(observable, oldValue, newValue) -> System.out.println(newValue));
	}

	@FXML
	private void handleAdd() {
		Project tmpProject = new Project();
		boolean okClicked = dinerApp.showAddDialog(tmpProject);
		if (okClicked == true) {
			dinerApp.getProjectList().add(tmpProject);
		}

	}

	@FXML
	private void handleEdit() {
		Project selectedProject = projectTableView.getSelectionModel()
				.getSelectedItem();
		if (selectedProject != null) {
			boolean okClicked = dinerApp.showAddDialog(selectedProject);
			if (okClicked) {
				setProjectData(selectedProject);
			}
		}
	}

	@FXML
	private void handleDelete() {

		int selectedIndex = projectTableView.getSelectionModel()
				.getSelectedIndex();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText(null);
		alert.setContentText("Czy na pewno chcesz usunąć wybrany projekt?");

		ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
		ButtonType buttonTypeCancel = new ButtonType("Anuluj",
				ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOk) {
			if (selectedIndex != -1) {
				projectTableView.getItems().remove(selectedIndex);
			}
		} else {
			alert.close();
		}

	}

	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Setup filter.
		FileChooser.ExtensionFilter extFilter = new ExtensionFilter(
				"Pliki XML (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show filechooser dialog.
		File file = fileChooser.showOpenDialog(dinerApp.getPrimaryStage());

		if (file != null) {
			dinerApp.loadProjectDataFromFile(file);
		}
	}

	@FXML
	private void handleSave() {
		File projectFile = dinerApp.getProjectFilePath();
		if (projectFile != null) {
			dinerApp.saveProjectDataToFile(projectFile);
		} else {
			handleSaveAs();
		}
	}

	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new ExtensionFilter(
				"Pliki XML (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(dinerApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has correct extension.
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			dinerApp.saveProjectDataToFile(file);
		}
	}

	@FXML
	private void handleAbout() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Diner");
		alert.setContentText("Diner - prosty edytor diet.\nAutor: Paweł Służalec\nStrona WWW: http://github.com/dweight/diner\n 2015");
		alert.setHeaderText("O programie");
		alert.showAndWait();
	}

	@FXML
	private void handleClose() {
		System.exit(0);
	}

}
