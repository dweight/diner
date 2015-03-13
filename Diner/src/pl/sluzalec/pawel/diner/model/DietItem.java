package pl.sluzalec.pawel.diner.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DietItem {

	private StringProperty name;

	// TODO Add other properties.
	private DoubleProperty kcal;
	private DoubleProperty quantity;

	public DietItem() {
		this("Kasza", 150, 200);
	}

	public DietItem(String name, double kcal, double quantity) {
		this.name = new SimpleStringProperty(name);
		this.kcal = new SimpleDoubleProperty(kcal);
		this.quantity = new SimpleDoubleProperty(quantity);
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public DoubleProperty getKcal() {
		return kcal;
	}

	public void setKcal(DoubleProperty kcal) {
		this.kcal = kcal;
	}

	public DoubleProperty getQuantity() {
		return quantity;
	}

	public void setQuantity(DoubleProperty quantity) {
		this.quantity = quantity;
	}

}
