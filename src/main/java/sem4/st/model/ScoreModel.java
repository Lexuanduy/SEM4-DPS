package sem4.st.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import sem4.st.entities.Score;

public class ScoreModel {
	static Logger logger = Logger.getLogger(ScoreModel.class.getName());
	public boolean saveScore(Score score) {
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
}
