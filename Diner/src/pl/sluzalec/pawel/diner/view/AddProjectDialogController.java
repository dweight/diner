package pl.sluzalec.pawel.diner.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

		if (projectNameTextField.getText() == null
				|| projectNameTextField.getText().length() == 0) {
			//TODO Add project name check.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Nieprawidłowa nazwa");
			alert.setContentText("Nazwa projektu jest nieprawidłowa!");
			alert.setHeaderText(null);
			alert.show();

			return false;

		} else {
			return true;
		}
	}
}
