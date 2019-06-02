package sem4.st.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import sem4.st.entities.Score;

public class ScoreModel {
	static Logger logger = Logger.getLogger(ScoreModel.class.getName());
	public static boolean saveScore(Score score) {
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"insert into 'score' ('idSubject', 'idStudent', 'score', 'accountId', 'createdAt', 'updatedAt') values (?,?,?,?,?,?)");
			ps.setString(1, score.getIdSubject());
			ps.setString(2, score.getIdStudent());
			ps.setInt(3, score.getScore());
			ps.setString(4, score.getAccountId());
			ps.setLong(5, score.getCreatedAt());
			ps.setLong(6, score.getUpdatedAt());
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return false;
	}
	
	public static List<Score> listAllScore() throws SQLException {
		List<Score> listScores = new ArrayList<>();

		String scoreSql = "SELECT * FROM score";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(scoreSql);
			ResultSet rs = ps.executeQuery(scoreSql);
			while (rs.next()) {
				Score newScore = new Score();
				String idStudent = rs.getString("idStudent");
				String idSubject = rs.getString("idSubject");
				String accountId = rs.getString("accountId");
				int score = rs.getInt("score");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				
				/*
				 * Student newStudent = new Student(); String subjectName =
				 * rs.getString("name");
				 * 
				 * Subject newSubject = new Subject(); String studentName =
				 * rs.getString("name");
				 */
				newScore.setIdStudent(idStudent);
				newScore.setIdSubject(idSubject);
				newScore.setAccountId(accountId);
				newScore.setCreatedAt(createdAt);
				newScore.setScore(score);
				newScore.setUpdatedAt(updatedAt);
				listScores.add(newScore);
			}
			return listScores;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return null;
	}
	
	public static boolean updateScore(Score score) throws SQLException {
		/* System.out.println(score.toString()); */
		String sql = "UPDATE score SET idSubject = ?, idStudent = ?, accountId = ?, score = ?, updatedAt = ?";
		sql += " WHERE id = ?";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, score.getScore());
			ps.setLong(2, score.getUpdatedAt());
			ps.setString(3, score.getAccountId());
			ps.setString(4, score.getIdStudent());
			ps.setString(5, score.getIdSubject());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return false;
	}

	public static boolean deleteScore(String stuId, String subId) throws SQLException {
		String sql = "DELETE FROM score where idStudent=? AND idSubject=?";

		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, stuId);
			ps.setString(2, subId);
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return false;
	}

	public static Score SearchByStudentIdSubjectId(String stuId, String subId) throws SQLException {
		String sql = "SELECT idStudent,idSubject,score,accountId,createdAt,updatedAt from score where idStudent=? AND idSubject=?";
		Score score = null;
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, stuId);
			ps.setString(2, subId);
			/* System.out.println(ps); */
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				score = new Score();
				String idStudent = rs.getString("idStudent");
				String idSubject = rs.getString("idSubject");
				String accountId = rs.getString("accountId");
				int mark = rs.getInt("score");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				
				score.setIdStudent(idStudent);
				score.setIdSubject(idSubject);
				score.setAccountId(accountId);
				score.setCreatedAt(createdAt);
				score.setScore(mark);
				score.setUpdatedAt(updatedAt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return score;
	}
}
