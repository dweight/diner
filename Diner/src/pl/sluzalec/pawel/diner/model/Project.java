package pl.sluzalec.pawel.diner.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class Project {

	private Patient patient = new Patient();
	private Diet diet;
	private String name;
	private ObservableList<TreeItem<String>> dietList = FXCollections
			.observableArrayList();

	public Project() {
		this(null, null, "Przykładowy Projekt");
		
	}

	public Project(Patient patient, Diet diet, String name) {
		this.patient = patient;
		this.diet = diet;
		this.name = name;
		dietList.add(new TreeItem<String>("Przykładowa dieta 1"));
		dietList.add(new TreeItem<String>("Przykładowa dieta 2"));
	}

	public TreeItem<String> setItem() {
		TreeItem<String> item = new TreeItem<>(name);
		TreeItem<String> patientItem = new TreeItem<>("Dane Pacjenta");
		TreeItem<String> dietItem = new TreeItem<>("Diety");
		dietItem.getChildren().addAll(dietList);

		item.setExpanded(true);
		item.getChildren().add(patientItem);
		item.getChildren().add(dietItem);

		return item;
	}

	public Project getProject() {
		return this;
	}

	public Patient getPatient() {
		return patient;
	}
	
	public String getName() {
		return name;
	}
}
