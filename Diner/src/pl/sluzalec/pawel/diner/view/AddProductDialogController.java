package pl.sluzalec.pawel.diner.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sluzalec.pawel.diner.model.DietItem;

public class AddProductDialogController {

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField quantityTextField;

	@FXML
	private TableView<DietItem> resultTableView;

	@FXML
	private TableColumn<DietItem, String> resultTableColumn;

	@FXML
	private CheckBox breakfastCB;

	@FXML
	private CheckBox lunchCB;

	@FXML
	private CheckBox dinnerCB;

	@FXML
	private CheckBox teeTimeCB;

	@FXML
	private CheckBox supperCB;

	@FXML
	private CheckBox betweenMealsCB;

	@FXML
	private TextField serchTextField;

	@FXML
	private Button searchButton;

	private Stage dialogStage;
	private ObservableList<DietItem> searchList = FXCollections
			.observableArrayList(new DietItem("Fasola", 50, 50));
	private ArrayList<String> list = new ArrayList<String>();
	private DietItem tmpDietItem;

	@FXML
	private void initialize() {

		// Populate list with sample data.
		resultTableView.setItems(searchList);

		// Set cell factory.
		resultTableColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getName());

		// Get selected item from list.
		resultTableView
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> updateDietItem(newValue));

	}

	@FXML
	private void handleOk() {

		if (isInputValid()) {
			this.tmpDietItem.setQuantity(Double.parseDouble(quantityTextField
					.getText()));
			makeList();
			dialogStage.close();
		}

	}

	@FXML
	private void handleCancel() {

		dialogStage.close();
	}

	public boolean isInputValid() {
		String error = "";
		boolean oneSelected = false;
		if (breakfastCB.isSelected() || lunchCB.isSelected()
				|| dinnerCB.isSelected() || teeTimeCB.isSelected()
				|| supperCB.isSelected() || betweenMealsCB.isSelected()) {
			 oneSelected = true;
		} else {
			error += "Nie wybrano żadnego posiłku (należy wybrać przynajmniej jeden)!\n";
		}

		if (resultTableView.getSelectionModel().getSelectedItem() == null) {
			error += "Nie wybrano produktu!\n";
		}

		if (quantityTextField.getText() == null
				|| quantityTextField.getText().length() == 0) {
			error += "Nie podano ilości!\n";
		} else {
			try {
				Double.parseDouble(quantityTextField.getText());
			} catch (NumberFormatException e) {
				error += "Podano nieprawidłową ilość (powinna być liczbą)!";
			}
		}
		if (error.length() == 0 && oneSelected == true) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Nieprawidłowe dane");
			alert.setContentText(error);
			alert.setHeaderText(null);
			alert.showAndWait();
			return false;
		}
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setDietItem(DietItem item) {
		tmpDietItem = item;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void updateDietItem(DietItem item) {
		this.tmpDietItem.setName(item.getName().get());
		this.tmpDietItem.setKcal(item.getKcal().get());
	}

	public void makeList() {

		if (breakfastCB.isSelected()) {
			list.add("breakfast");
		}
		if (lunchCB.isSelected()) {
			list.add("lunch");
		}
		if (dinnerCB.isSelected()) {
			list.add("dinner");
		}
		if (teeTimeCB.isSelected()) {
			list.add("teetime");
		}
		if (supperCB.isSelected()) {
			list.add("supper");
		}
		if (betweenMealsCB.isSelected()) {
			list.add("between");
		}
	}
}
