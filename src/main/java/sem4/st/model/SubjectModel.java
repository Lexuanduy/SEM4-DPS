package sem4.st.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sem4.st.entities.Subject;

public class SubjectModel {

	static Logger logger = Logger.getLogger(AccountModel.class.getName());

	public static boolean createSubject(Subject subject) throws SQLException {
		String sql = "INSERT INTO subject (id, name, status, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, subject.getId());
			ps.setString(2, subject.getName());
			ps.setInt(3, subject.getStatus());
			ps.setLong(4, subject.getCreatedAt());
			ps.setLong(5, subject.getUpdatedAt());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return false;
	}

	public static List<Subject> listAllSubject() {
		List<Subject> listSubjects = new ArrayList<>();

		String sql = "SELECT * FROM subject";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				Subject subject = new Subject();
				String id = rs.getString("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				subject.setCreatedAt(createdAt);
				subject.setId(id);
				subject.setName(name);
				subject.setStatus(status);
				subject.setUpdatedAt(updatedAt);
				listSubjects.add(subject);
			}
			return listSubjects;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	public static boolean updateSubject(Subject subject) throws SQLException {
		System.out.println(subject.toString());
		String sql = "UPDATE subject SET name = ?, updatedAt = ?";
		sql += " WHERE id = ?";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, subject.getName());
			ps.setLong(2, subject.getUpdatedAt());
			ps.setString(3, subject.getId());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return false;
	}

	public static boolean deleteSubject(String id) throws SQLException {
		String sql = "DELETE FROM subject where id = ?";

		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return false;
	}

	public static Subject SearchById(String id) throws SQLException {
		String sql = "SELECT id,status,name,createdAt,updatedAt from subject where id =?";
		Subject subject = null;
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String subjectId = rs.getString("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				subject = new Subject();
				subject.setCreatedAt(createdAt);
				subject.setName(name);
				subject.setStatus(status);
				subject.setUpdatedAt(updatedAt);
				subject.setId(subjectId);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return subject;
	}
}
