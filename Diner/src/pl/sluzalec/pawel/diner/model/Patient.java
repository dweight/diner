package pl.sluzalec.pawel.diner.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {

	private StringProperty name;
	private StringProperty lastName;
	private BooleanProperty gender;
	private StringProperty age;
	private DoubleProperty higth;
	private DoubleProperty bodyMass;
	private DoubleProperty waist;
	private DoubleProperty hips;

	public Patient() {
		this("Imię", "Nazwisko");
	}

	public Patient(String name, String lastName) {
		this.name = new SimpleStringProperty(name);
		this.lastName = new SimpleStringProperty(lastName);
		// Exemple data.
		this.gender = new SimpleBooleanProperty(true);
		this.age = new SimpleStringProperty("25");
		this.higth = new SimpleDoubleProperty(175);
		this.bodyMass = new SimpleDoubleProperty(70);
		this.waist = new SimpleDoubleProperty(50);
		this.hips = new SimpleDoubleProperty(50);
	}

	public String makeID() {
		String id;
		id = name.get() + " " + lastName.get();
		return id;
	}
	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public BooleanProperty getGender() {
		return gender;
	}

	public void setGender(BooleanProperty gender) {
		this.gender = gender;
	}

	public StringProperty getAge() {
		return age;
	}

	public void setAge(StringProperty age) {
		this.age = age;
	}

	public DoubleProperty getHigth() {
		return higth;
	}

	public void setHigth(DoubleProperty higth) {
		this.higth = higth;
	}

	public DoubleProperty getBodyMass() {
		return bodyMass;
	}

	public void setBodyMass(DoubleProperty bodyMass) {
		this.bodyMass = bodyMass;
	}

	public DoubleProperty getWaist() {
		return waist;
	}

	public void setWaist(DoubleProperty waist) {
		this.waist = waist;
	}

	public DoubleProperty getHips() {
		return hips;
	}

	public void setHips(DoubleProperty hips) {
		this.hips = hips;
	}

}
