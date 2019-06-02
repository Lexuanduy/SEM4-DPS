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
		System.out.println(score.toString());
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"insert into score(idSubject,idStudent,score,accountId,createdAt,updatedAt) values (?,?,?,?,?,?)");
			ps.setString(1, score.getIdSubject());
			ps.setString(2, score.getIdStudent());
			ps.setInt(3, score.getScore());
			ps.setString(4, score.getAccountId());
			ps.setLong(5, score.getCreatedAt());
			ps.setLong(6, score.getUpdatedAt());
			System.out.println(ps.toString());
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		} finally{
			DBConnection.getInstance().closeConnection();
		}
		return false;
	}
	
	public static List<Score> listAllScore() throws SQLException {
		List<Score> listScores = new ArrayList<>();

		String scoreSql = "SELECT score.score,score.scoreId,score.accountId,score.idStudent,score.createdAt,score.updatedAt"
				+ ",student.name as 'studentName', subject.name as 'subjectName' FROM score "
											+ "INNER JOIN subject ON score.idSubject = subject.id "
											+ "INNER JOIN student ON score.idStudent = student.rollNumber";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(scoreSql);
			ResultSet rs = ps.executeQuery(scoreSql);
			while (rs.next()) {
				Score newScore = new Score();
				String idStudent = rs.getString("idStudent");
				int scoreId = rs.getInt("scoreId");
				String studentName = rs.getString("studentName");
				String subjectName = rs.getString("subjectName");
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
				newScore.setScoreId(scoreId);
				newScore.setStudentName(studentName);
				newScore.setSubjectName(subjectName);
				newScore.setAccountId(accountId);
				newScore.setCreatedAt(createdAt);
				newScore.setScore(score);
				newScore.setUpdatedAt(updatedAt);
				listScores.add(newScore);
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
		} finally{
			DBConnection.getInstance().closeConnection();
		}
		return listScores;
	}
	
	public static boolean updateScore(Score score) throws SQLException {
		/* System.out.println(score.toString()); */
		String sql = "UPDATE score SET idSubject = ?, idStudent = ?, accountId = ?, score = ?, updatedAt = ?";
		sql += " WHERE scoreId = ?";
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(4, score.getScore());
			ps.setLong(5, score.getUpdatedAt());
			ps.setString(3, score.getAccountId());
			ps.setString(2, score.getIdStudent());
			ps.setString(1, score.getIdSubject());
			ps.setInt(6, score.getScoreId());
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		} finally{
			DBConnection.getInstance().closeConnection();
		}
		return false;
	}

	public static boolean deleteScore(int scoreId) throws SQLException {
		String sql = "DELETE FROM score where scoreId = ?";

		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, scoreId);
			ps.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		} finally{
			DBConnection.getInstance().closeConnection();
		}
		return false;
	}

	public static Score searchByScoreId(int id) throws SQLException {
		String sql = "SELECT  scoreId,idStudent,idSubject,score,accountId,createdAt,updatedAt from score where scoreId=?";
		Score score = null;
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, id);
			/* System.out.println(ps); */
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				score = new Score();
				int scoreId = rs.getInt("scoreId");
				String idStudent = rs.getString("idStudent");
				String idSubject = rs.getString("idSubject");
				String accountId = rs.getString("accountId");
				int mark = rs.getInt("score");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				
				
				score.setScoreId(scoreId);
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
		} finally{
			DBConnection.getInstance().closeConnection();
		}
		return score;
	}
}
