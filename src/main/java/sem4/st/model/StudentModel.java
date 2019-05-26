package sem4.st.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sem4.st.entities.Student;

public class StudentModel {
	static Logger logger = Logger.getLogger(AccountModel.class.getName());
	public static boolean createStudent(Student student) {
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"insert into student ('rollNumber', 'name', 'gender', 'bod', 'phone','status','address',"
					+ "'cmnd','email','mediumScore','accountId','createdAt, 'updatedAt') "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, student.getRollNumber());
			ps.setString(2, student.getName());
			ps.setString(3, student.getGender());
			ps.setLong(4, student.getBod());
			ps.setString(5, student.getPhone());
			ps.setInt(6, student.getStatus());
			ps.setString(7, student.getAddress());
			ps.setString(8, student.getCmnd());
			ps.setString(9, student.getEmail());
			ps.setFloat(10, student.getMediumScore());
			ps.setString(11, student.getAccountId());
			ps.setLong(12, student.getCreatedAt());
			ps.setLong(13, student.getUpdatedAt());
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return false;
	}
	
	public static boolean updateStudent(Student student) {
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"update student set  'name' = ?, 'gender' = ?, 'bod' = ?, 'phone' = ?,"
					+ "'status' = ?,'address' = ?,'cmnd' = ?,'email' = ?,'mediumScore' = ?,'accountId' = ?,"
					+ "'createdAt = ?, 'updatedAt' = ? where 'rollNumber' = ?");
			ps.setString(13, student.getRollNumber());
			ps.setString(1, student.getName());
			ps.setString(2, student.getGender());
			ps.setLong(3, student.getBod());
			ps.setString(4, student.getPhone());
			ps.setInt(5, student.getStatus());
			ps.setString(6, student.getAddress());
			ps.setString(7, student.getCmnd());
			ps.setString(8, student.getEmail());
			ps.setFloat(9, student.getMediumScore());
			ps.setString(10, student.getAccountId());
			ps.setLong(11, student.getCreatedAt());
			ps.setLong(12, student.getUpdatedAt());
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return false;
	}
	
	public static boolean deleteStudent(String rollNumber) {
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"delete from student where 'rollNumber' = ?");
			ps.setString(1, rollNumber);
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return false;
	}
	
	public static List<Student> listAllStudent(String studentName,String rollNumber,int page) {
		logger.info("test - "+studentName+"-"+rollNumber+"-"+page);
		List<Student> studentList = new ArrayList<Student>();
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement("select * from student where 'name' like ? or 'rollNumber' like ? limit 10 offset ? ");
			ps.setInt(3, (page-1)*10);
			ps.setString(1, "%"+studentName+"%");
			ps.setString(2, "%"+rollNumber+"%");
			logger.info("query - "+ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				String rollNum = rs.getString("rollNumber");
				String gender = rs.getString("gender");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String cmnd = rs.getString("cmnd");
				String email = rs.getString("email");
				String accountId = rs.getString("accountId");
				Float mediumScore = rs.getFloat("mediumScore");
				int status = rs.getInt("status");
				long bod = rs.getLong("bod");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				student.setAccountId(accountId);
				student.setAddress(address);
				student.setBod(bod);
				student.setCmnd(cmnd);
				student.setCreatedAt(createdAt);
				student.setEmail(email);
				student.setGender(gender);
				student.setMediumScore(mediumScore);
				student.setName(name);
				student.setPhone(phone);
				student.setRollNumber(rollNum);
				student.setStatus(status);
				student.setUpdatedAt(updatedAt);
				studentList.add(student);
			}
			return studentList;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	public static Student searchByRollNumber(String rollNumber) {
		Student student = new Student();
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery("SELECT * FROM student WHERE rollNumber = '" + rollNumber + "'");

			while (rs.next()) {
				String rollNum = rs.getString("rollNumber");
				String gender = rs.getString("gender");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String cmnd = rs.getString("cmnd");
				String email = rs.getString("email");
				String accountId = rs.getString("accountId");
				Float mediumScore = rs.getFloat("mediumScore");
				int status = rs.getInt("status");
				long bod = rs.getLong("bod");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				student.setAccountId(accountId);
				student.setAddress(address);
				student.setBod(bod);
				student.setCmnd(cmnd);
				student.setCreatedAt(createdAt);
				student.setEmail(email);
				student.setGender(gender);
				student.setMediumScore(mediumScore);
				student.setName(name);
				student.setPhone(phone);
				student.setRollNumber(rollNum);
				student.setStatus(status);
				student.setUpdatedAt(updatedAt);
			}
		} catch (SQLException ex) {
		}
		return student;
	}
}
