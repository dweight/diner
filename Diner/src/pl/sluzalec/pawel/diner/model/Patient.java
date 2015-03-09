package pl.sluzalec.pawel.diner.model;

public class Patient {

	private String name;
	private String lastName;
	private boolean gender;
	private String age;
	private double higth;
	private double bodyMass;
	private double waist;
	private double hips;

	public Patient() {
		this(null,null);
	}
	
	public Patient(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		this.gender = true;
		this.age = "25";
		this.higth = 175;
		this.bodyMass = 70;
		this.waist = 50;
		this.hips = 50;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getHigth() {
		return higth;
	}

	public void setHigth(double higth) {
		this.higth = higth;
	}

	public double getBodyMass() {
		return bodyMass;
	}

	public void setBodyMass(double bodyMass) {
		this.bodyMass = bodyMass;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}

	public double getHips() {
		return hips;
	}

	public void setHips(double hips) {
		this.hips = hips;
	}
	
	
}
