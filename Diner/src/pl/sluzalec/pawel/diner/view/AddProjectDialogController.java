package pl.sluzalec.pawel.diner.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.Project;

public class AddProjectDialogController {

	private Stage dialogStage;
	
	

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField projectNameTextField;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	public void handleOK() {
		if (isInputValid()) {

			dialogStage.close();
		}

	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";
		
		if (projectNameTextField.getText() == null
				|| projectNameTextField.getText().length() == 0) {
			errorMessage += "Niepoprawna nazwa projektu!\n";
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
}
