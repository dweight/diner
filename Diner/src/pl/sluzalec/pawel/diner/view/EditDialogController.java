package pl.sluzalec.pawel.diner.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.Patient;

public class EditDialogController implements Initializable {

	private Stage dialogStage;
	private Patient patient = new Patient();

	@FXML
	private TextField bodyMassTextField;

	@FXML
	private TextField hipsTextField;

	@FXML
	private Button cancelButton;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private TextField nameTextField;

	@FXML
	private RadioButton maleRadioButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField haigthTextField;

	@FXML
	private TextField waistTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField ageTextField;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setPatient() {

		nameTextField.setText(patient.getName());
		lastNameTextField.setText(patient.getLastName());
		ageTextField.setText(patient.getAge());
		bodyMassTextField.setText(Double.toString(patient.getBodyMass()));
		haigthTextField.setText(Double.toString(patient.getHigth()));
		waistTextField.setText(Double.toString(patient.getWaist()));
		hipsTextField.setText(Double.toString(patient.getHips()));
		if (patient.getGender() == true) {
			femaleRadioButton.arm();
		} else {
			maleRadioButton.arm();
		}
	}

	public void handleOK() {
		if (isInputValid()) {
			patient.setName(nameTextField.getText());
			patient.setLastName(lastNameTextField.getText());
			patient.setHigth(Double.parseDouble(hipsTextField.getText()));
			patient.setBodyMass(Double.parseDouble(bodyMassTextField.getText()));
			patient.setWaist(Double.parseDouble(waistTextField.getText()));
			patient.setHips(Double.parseDouble(hipsTextField.getText()));
			patient.setAge(ageTextField.getText());
			if (femaleRadioButton.isArmed()) {
				patient.setGender(true);
			} else {
				patient.setGender(false);
			}

			dialogStage.close();
		}

	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (nameTextField.getText() == null
				|| nameTextField.getText().length() == 0) {
			errorMessage += "Niepoprawne imię!\n";
		}
		if (lastNameTextField.getText() == null
				|| lastNameTextField.getText().length() == 0) {
			errorMessage += "Niepoprawne nazwisko!\n";
		}
		if (ageTextField.getText() == null
				|| ageTextField.getText().length() == 0) {
			errorMessage += "Niepoprawny wiek!\n";
		} else {
			try {
				Integer.parseInt(ageTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Niepoprawny wiek (musi być liczbą)!\n";
			}
		}

		if (bodyMassTextField.getText() == null
				|| bodyMassTextField.getText().length() == 0) {
			errorMessage += "Niepoprawna masa ciała!\n";
		} else {
			try {
				Integer.parseInt(bodyMassTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Niepoprawna masa ciała (musi być liczbą)!\n";
			}
		}

		if (haigthTextField.getText() == null
				|| haigthTextField.getText().length() == 0) {
			errorMessage += "Niepoprawny wzrost!\n";
		} else {
			try {
				Integer.parseInt(hipsTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Niepoprawny wzrost (musi być liczbą)!\n";
			}
		}

		if (waistTextField.getText() == null
				|| waistTextField.getText().length() == 0) {
			errorMessage += "Niepoprawny obwód pasa!\n";
		} else {
			try {
				Integer.parseInt(waistTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Niepoprawny obwód pasa (musi być liczbą)!\n";
			}
		}

		if (hipsTextField.getText() == null
				|| hipsTextField.getText().length() == 0) {
			errorMessage += "Niepoprawny obwód bioder!\n";
		} else {
			try {
				Integer.parseInt(hipsTextField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Niepoprawny obwód bioder (musi być liczbą)!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Niewłaściwe dane");
			alert.setContentText(errorMessage);
			alert.setHeaderText("Proszę poprawić nieprawdłowe pola");
			alert.show();
			return false;
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private void configureRadioButtons() {
		femaleRadioButton.arm();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		configureRadioButtons();
		System.out.println("Kontroler uruchomiony!");

	}

}
