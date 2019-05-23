package sem4.st.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import sem4.st.entities.Account;

public class AccountModel {
	static Logger logger = Logger.getLogger(AccountModel.class.getName());
	public boolean register(Account account) {
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			PreparedStatement ps = cnn.prepareStatement(
					"insert into 'account' ('id', 'userName', 'passWord', 'salt', 'createdAt', 'updatedAt') values (?,?,?,?,?,?)");
			ps.setString(1, account.getId());
			ps.setString(2, account.getUserName());
			ps.setString(3, account.getPassWord());
			ps.setString(4, account.getSalt());
			ps.setLong(5, account.getCreatedAt());
			ps.setLong(6, account.getUpdatedAt());
			ps.execute();
			return true;
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	public Account searchByName(String name) {
		Account acc = new Account();
		try {
			Connection cnn = DBConnection.getInstance().getConnection();
			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery("SELECT * FROM account WHERE userName = '" + name + "'");

			while (rs.next()) {
				String id = rs.getString("id");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				String salt = rs.getString("salt");
				long createdAt = rs.getLong("createdAt");
				long updatedAt = rs.getLong("updatedAt");
				acc.setId(id);
				acc.setUserName(userName);
				acc.setPassWord(passWord);
				acc.setSalt(salt);
				acc.setCreatedAt(createdAt);
				acc.setUpdatedAt(updatedAt);
			}
		} catch (SQLException ex) {
		}
		return acc;
	}
}
