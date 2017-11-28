package edu.iba.sh.bean;

public class Study {
	private long id;
	
	private String name;
	
	private int hours;
	
	private long professorId;
	
	private double avgMark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(float avgMark) {
		this.avgMark = avgMark;
	}

	public Study(long id, String name, int hours, long professorId,
			float avgMark) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.professorId = professorId;
		this.avgMark = avgMark;
	}

}
