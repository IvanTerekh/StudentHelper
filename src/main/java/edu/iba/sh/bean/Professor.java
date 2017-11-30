package edu.iba.sh.bean;

public class Professor {
	
	private int id;

	private String firstName;
	
	private String secondName;
	
	private String fatherName;
	
	private String birthDate;
	
	private String avgMark;

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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(String avgMark) {
		this.avgMark = avgMark;
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Professor)&&((Professor)o).id==this.id;
	}
}
