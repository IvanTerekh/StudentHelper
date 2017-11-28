package edu.iba.sh.bean;

public class Mark {
	private long id;
	
	private long studyId;
	
	private long studentId;
	
	private String date;
	
	private long professorId;
	
	private int mark;
	
	private String comments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudyId() {
		return studyId;
	}

	public void setStudyId(long studyId) {
		this.studyId = studyId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


}
