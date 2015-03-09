package pl.sluzalec.pawel.diner.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.DinerApp;

public class MainOverviewController implements Initializable {

	@FXML
	private TextField bodyMassTextField;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private TreeView<?> patientTreeView;

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

	@FXML
	public void showAddPatientDialog() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DinerApp.class
					.getResource("view/EditPatientDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Dodaj Pacjenta");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			
			EditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			

			dialogStage.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
