package sem4.st.entities;

public class Student {
	public Student() {
		super();
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getBod() {
		return bod;
	}
	public void setBod(long bod) {
		this.bod = bod;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getMediumScore() {
		return mediumScore;
	}
	public void setMediumScore(float mediumScore) {
		this.mediumScore = mediumScore;
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
	private String rollNumber;
	private String accountId;
	private String name;
	private String gender;
	private long bod;
	private String phone;
	private int status; // 1: Đang học, 0: đã nghỉ, 2: bảo lưu. 
	private String address;
	private String cmnd;
	private String email;
	private float mediumScore;
	private long createdAt;
	private long updatedAt;
}
