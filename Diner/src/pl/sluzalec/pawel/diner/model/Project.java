package pl.sluzalec.pawel.diner.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Project {

	private StringProperty projectName;
	private StringProperty patientName;
	private StringProperty lastName;
	private BooleanProperty gender;
	private StringProperty age;
	private DoubleProperty higth;
	private DoubleProperty bodyMass;
	private DoubleProperty waist;
	private DoubleProperty hips;
	private ObservableList<DietItem> breakfastList = FXCollections
			.observableArrayList();
	private ObservableList<DietItem> lunchList = FXCollections
			.observableArrayList();
	private ObservableList<DietItem> dinnerList = FXCollections
			.observableArrayList();
	private ObservableList<DietItem> teeTimeList = FXCollections
			.observableArrayList();
	private ObservableList<DietItem> supperList = FXCollections
			.observableArrayList();
	private ObservableList<DietItem> betweenMealsList = FXCollections
			.observableArrayList();

	public Project() {
		this("Nowy Projekt");
	}

	public Project(String name) {
		this.projectName = new SimpleStringProperty(name);
		// Dummy data.
		this.patientName = new SimpleStringProperty("Jan");
		this.lastName = new SimpleStringProperty("Kowalski");
		this.age = new SimpleStringProperty("25");
		this.higth = new SimpleDoubleProperty(175);
		this.bodyMass = new SimpleDoubleProperty(70);
		this.waist = new SimpleDoubleProperty(50);
		this.hips = new SimpleDoubleProperty(50);
		this.gender = new SimpleBooleanProperty(false);
		this.breakfastList.add(new DietItem());
		this.teeTimeList.add(new DietItem());
		this.lunchList.add(new DietItem());
		this.dinnerList.add(new DietItem());
		this.supperList.add(new DietItem());
		this.betweenMealsList.add(new DietItem());
	}

	public ObservableList<DietItem> getBreakfastList() {
		return breakfastList;
	}

	public ObservableList<DietItem> getLunchList() {
		return lunchList;
	}

	public ObservableList<DietItem> getDinnerList() {
		return dinnerList;
	}

	public ObservableList<DietItem> getTeeTimeList() {
		return teeTimeList;
	}

	public ObservableList<DietItem> getSupperList() {
		return supperList;
	}

	public ObservableList<DietItem> getBetweenMealsList() {
		return betweenMealsList;
	}

	public void addLunchList(DietItem item) {
		lunchList.add(item);
	}

	public void addDinnerList(DietItem item) {
		dinnerList.add(item);
	}

	public void addBreakfastList(DietItem item) {
		breakfastList.add(item);
	}

	public void addTeeTimeList(DietItem item) {
		teeTimeList.add(item);
	}

	public void addSupperList(DietItem item) {
		supperList.add(item);
	}

	public void addBetweenMealsList(DietItem item) {
		betweenMealsList.add(item);
	}

	public StringProperty getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName.set(projectName);
	}

	public String getPatientName() {
		return patientName.get();
	}

	public void setPatientName(String patientName) {
		this.patientName.set(patientName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public Boolean getGender() {
		return gender.get();
	}

	public void setGender(Boolean gender) {
		this.gender.set(gender);
	}

	public String getAge() {
		return age.get();
	}

	public void setAge(String age) {
		this.age.set(age);
	}

	public Double getHigth() {
		return higth.get();
	}

	public void setHigth(Double higth) {
		this.higth.set(higth);
	}

	public Double getBodyMass() {
		return bodyMass.get();
	}

	public void setBodyMass(Double bodyMass) {
		this.bodyMass.set(bodyMass);
	}

	public Double getWaist() {
		return waist.get();
	}

	public void setWaist(Double waist) {
		this.waist.set(waist);
	}

	public Double getHips() {
		return hips.get();
	}

	public void setHips(Double hips) {
		this.hips.set(hips);
	}
}
