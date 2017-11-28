package edu.iba.sh.bean;

public class Student {
	private int id;
	
	private String firstName;
	
	private String secondName;
	
	private double avgMark;
	
	private String groupNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Student)&&((Student)o).id==this.id;
	}
}
