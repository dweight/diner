package pl.sluzalec.pawel.diner.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.Project;

public class AddProjectDialogController {

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField projectNameTextField;

	@FXML
	private TextField patientNameTextField;

	@FXML
	private TextField patientLastNameTextField;

	@FXML
	private TextField ageTextField;

	@FXML
	private TextField higthTextField;

	@FXML
	private TextField bodyMassTextField;

	@FXML
	private TextField waistTextField;

	@FXML
	private TextField hipsTextField;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private ToggleGroup genderToggleGroup;

	@FXML
	private RadioButton maleRadioButton;

	private Stage dialogStage;

	private Project project;
	private boolean isOkClicked = false;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setProject(Project project) {
		this.project = project;

		if (project != null) {
			this.projectNameTextField.setText(project.getProjectName().get());
			this.patientNameTextField.setText(project.getPatientName());
			this.patientLastNameTextField.setText(project.getLastName());
			this.ageTextField.setText(project.getAge());
			this.bodyMassTextField.setText(project.getBodyMass().toString());
			this.higthTextField.setText(project.getHigth().toString());
			this.hipsTextField.setText(project.getHips().toString());
			this.waistTextField.setText(project.getWaist().toString());
			if (project.getGender() == true) {
				this.genderToggleGroup.selectToggle(femaleRadioButton);
			} else {
				this.genderToggleGroup.selectToggle(maleRadioButton);
			}
			
			dialogStage.close();
		}

	}

	@FXML
	public void handleOK() {
		
		if (isInputValid()) {

			project.setProjectName(projectNameTextField.getText());
			project.setPatientName(patientNameTextField.getText());
			project.setLastName(patientLastNameTextField.getText());
			project.setAge(ageTextField.getText());
			project.setBodyMass(Double.parseDouble(bodyMassTextField.getText()));
			project.setHigth(Double.parseDouble(higthTextField.getText()));
			project.setHips(Double.parseDouble(hipsTextField.getText()));
			project.setWaist(Double.parseDouble(waistTextField.getText()));
			if (genderToggleGroup.getSelectedToggle() == femaleRadioButton) {
				project.setGender(true);
			} else {
				project.setGender(false);
			}
		}
			isOkClicked = true;
			dialogStage.close();
		}

	

	@FXML
	private void handleCancel() {
		
		dialogStage.close();
	}

	private boolean isInputValid() {
		String error = "";
		if (projectNameTextField.getText() == null
				|| projectNameTextField.getText().length() == 0) {
			error += "Nie podano prawidłowej nazwy projektu!\n";
		}
		if (patientNameTextField.getText() == null
				|| patientNameTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego imienia pacjenta!\n";
		}
		if (patientLastNameTextField.getText() == null
				|| patientLastNameTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego nazwiska pacjenta!\n";
		}
		if (ageTextField.getText() == null
				|| ageTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego wieku pacjenta!\n";
		}
		if (higthTextField.getText() == null
				|| higthTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego wzrostu pacjenta!\n";
		} else {
			try {
				Double.parseDouble(higthTextField.getText());
			} catch (NumberFormatException e) {
				error += "Wzrost powinien być liczbą!\n";
				e.printStackTrace();
			}
		}
		if (bodyMassTextField.getText() == null
				|| bodyMassTextField.getText().length() == 0) {
			error += "Nie podano prawidłowej masy ciała pacjenta!\n";
		} else {
			try {
				Double.parseDouble(bodyMassTextField.getText());
			} catch (NumberFormatException e) {
				error += "Masa ciała powinna być liczbą!\n";
				e.printStackTrace();
			}
		}
		if (waistTextField.getText() == null
				|| waistTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego obwodu pasa pacjenta! (powinien być liczbą)\n";
		} else {
			try {
				Double.parseDouble(waistTextField.getText());
			} catch (NumberFormatException e) {
				error += "Obwód pasa powinien być liczbą!\n";
				e.printStackTrace();
			}
		}
		if (hipsTextField.getText() == null
				|| hipsTextField.getText().length() == 0) {
			error += "Nie podano prawidłowego obwodu bioder pacjenta! (powinien być liczbą)\n";
		} else {
			try {
				Double.parseDouble(hipsTextField.getText());
			} catch (NumberFormatException e) {
				error += "Obwód bioder powinien być liczbą!\n";
				e.printStackTrace();
			}

		}
		if (error.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Nieprawidłowa nazwa");
			alert.setContentText(error);
			alert.setHeaderText("Wprowadzono niepoprawne dane");
			alert.show();
			return false;

		}
	}

	public boolean isOkClicked() {

		return isOkClicked;
	}
}
