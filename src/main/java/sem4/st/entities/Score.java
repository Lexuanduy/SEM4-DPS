package sem4.st.entities;

public class Score {
	public Score() {
		super();
	}
	public String getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(String idSubject) {
		this.idSubject = idSubject;
	}
	public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	private String idSubject;
	private String idStudent;
	private int score;
	private String accountId;
	private long createdAt;
	private long updatedAt;
	private int scoreId;
	private String studentName;
	private String subjectName;
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Score [idSubject=" + idSubject + ", idStudent=" + idStudent + ", score=" + score + ", accountId="
				+ accountId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", scoreId=" + scoreId
				+ ", studentName=" + studentName + ", subjectName=" + subjectName + "]";
	}
	
	
	
}
