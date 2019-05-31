package sem4.st.entities;

public class Subject {
	public Subject() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	private String id;
	private String name;
	private int status; // defaul 1: đang sử dụng, 0: tạm khóa.
	private long createdAt;
	private long updatedAt;
}
